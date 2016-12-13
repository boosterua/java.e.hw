package hw.hw17;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Created by tonchief on 12/13/2016.
 *
 * 17. Написать калькулятор, ка вход которого подается выражение вида  (1+2)*4+5*(3+6)
 * на выходе должно быть значение этого выражения. Использовать паттерн Composite.
 *
 * Вопросы: как отслеживать ошибки через тесты? Напр, намеренно неправильно заданный параметр (стринг вс инт).
 *
 */


public class CalcPL{  // Divide string into operators and numbers, return result
    static OperQ operQ = new OperQ();
    static NumQ numQ = new NumQ();

    CalcPL(){};
    CalcPL(String expression){
        for(char c: expression.toCharArray()) {
            if (isDelimiter(c))
                continue;
            else if (isDigit(c))
                new Value().eval(c);
            else if (isOperator(c) || isParenthesis(c))
                new Operation().eval(c);
        }
        new Operation().calcPostfix();
    }

    public Float getResult(){
//        System.out.println("Final:" + numQ + operQ);
        return numQ.pull();
    }

    static boolean isParenthesis(char c){
        return ( c=='(' || c==')' );
    }
    static boolean isOperator(char c){
        Pattern p = Pattern.compile("[\\-+()*/]");
        Matcher m = p.matcher(c+"");
        return m.matches();
    }
    static boolean isDelimiter(char c){
        // Check if not number or simple operation;
        Pattern p = Pattern.compile("[^0-9\\-+()*/]");
        Matcher m = p.matcher(c+"");
        return m.matches();
    }

    static boolean isDigit(char c){
        // Check if number
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(c+"");
        return m.matches();
    }





    public static void main(String[] args) {
//        System.out.println(new CalcPL("(1+2)*4+5*(3+6)").getResult());
    }

}

class Operation   extends CalcPL   { // COMPOSITE

    public int eval(char oper) {

//        System.out.println("Opers:"+ operQ+"; Nums:"+numQ + " \t New Operation: " + oper);

        if (oper == '(') {
            operQ.push(oper);
        }
        else if (oper == ')'){
            while (operQ.peek() != '('){
                float l = numQ.pull();
                float r = numQ.pull();
                numQ.push(evalOp(l, r, operQ.pull()));
                if (operQ.isEmpty()) throw new IllegalArgumentException();
            }
            operQ.pull();
        }
        else { //            * / - + (
            while (!operQ.isEmpty() && operatorPrio(oper) <= operatorPrio(operQ.peek())) {
                float l = numQ.pull();
                float r = numQ.pull();
                numQ.push(evalOp(l, r, operQ.pull()));
            }
            operQ.push(oper);
        }
        return 0;
    }

    public int calcPostfix() {
            while (!operQ.isEmpty()){  //                System.out.println("Opers:"+ operQ+"; Nums:"+numQ + " \t PF Oper: " + operQ.peek());
                float l = numQ.pull();
                float r = numQ.pull();
                numQ.push(evalOp(l, r, operQ.pull()));
            }
        return 0;
    }

    private float evalOp(float l, float r, char op) {
//        System.out.printf("l %.2f,r %.2f,op %s\n",l,r,op);
        if(op=='+') return l+r;
        if(op=='-') return l-r;
        if(op=='*') return l*r;
        if(op=='/') return l/r;
        if(op=='%') return l%r;
        return 0;
    }


    static int operatorPrio(char op){
        if(op=='+' || op=='-')
            return 1;
        if(op=='*' || op=='/' || op=='%')
            return 2;
        return -1;
    }

}


class Value extends CalcPL { // LEAF
    static float eval(char e) {
        float v = Float.valueOf(""+e);
        numQ.push(v);
        return v;
    }
}






class NumQ {
    LinkedList<Float> numbers;

    NumQ(){
         this.numbers = new LinkedList<>();
    }

    public void push(Float e) {
        numbers.add(e);
//        System.out.println(numbers);
    }

    public Float pull() {
//        System.out.println(numbers);
        if (numbers.isEmpty()) throw new IllegalArgumentException();
        Float num = numbers.getLast();
        numbers.removeLast();
//        System.out.println("Pull:"+num + " arr.left:"+numbers);
        return num;
    }

    public Float peek() {
//        System.out.println(numbers + " peek="+numbers.getLast());
        return numbers.getLast();
    }

    public boolean isEmpty() {
        return numbers.isEmpty();
    }

    @Override
    public String toString(){
        return this.numbers.toString();
    }

}

class OperQ {
    LinkedList<Character> operations = new LinkedList<>();

    public void push(char op) {
        operations.add(op);

    }

    public char pull() {
        char op = operations.getLast();
        operations.removeLast();
        return op;
    }

    public char peek() {
        return operations.getLast();
    }

    public boolean isEmpty() {
        return operations.isEmpty();
    }

    @Override
    public String toString(){
        return this.operations.toString();
    }

}