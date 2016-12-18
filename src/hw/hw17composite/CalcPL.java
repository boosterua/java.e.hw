package hw.hw17composite;

import org.codehaus.groovy.runtime.powerassert.SourceText;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    Tree tree = new Tree();

    public CalcPL(String infixString) {
        tree.insert(infixString);
        tree.traversePostfix();
    }

    public  double getResult(){
        return tree.getResult();
    }

    public static void main(String[] args) {
        System.out.println(new CalcPL("(1+2)*4+5*(3+6)").getResult());
        System.out.println(new CalcPL("1*5+(3+2)").getResult());

    }
}


class Node {
    public char data;
    public Node left;
    public Node right;

    public Node(char x){
        data = x;
    }

    public Node(char x, Node l, Node r){
        data = x;
        this.left = l;
        this.right = r;
    }

    public String toString(){
        return Character.toString(data);
    }

}

class uniQueue <T>{ // Stack
    private LinkedList<T> queue;
    uniQueue(){
        this.queue = new LinkedList<>();
    }

    public void push(T e) {
        queue.add(e);
    }

    public T pull() {
        if (queue.isEmpty())
            throw new ArithmeticException("153. pull in CharQ / Empty stack.");
        T num = queue.getLast();
        queue.removeLast();
        return (T)num;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString(){
        return this.queue.toString();
    }
}

class Conv{
    private uniQueue<Character> s;
    private String inputStr;
    private List<Character> outArray = new ArrayList<>();

    public Conv(String str){
        inputStr = str;
        s = new uniQueue<>();
    }

    // ########## PARSER

    List <Character> infix2Postfix() {
        for (int i = 0; i < inputStr.length(); i++){
            char ch = inputStr.charAt(i);
            if(isOperator(ch)){                //    was: gotOperator [ch, ]
                while (!s.isEmpty()){
                    Character opFirst = s.pull();
                    if (opFirst == '('){
                        s.push(opFirst);
                        break;
                    } else {
                        if (operatorPrio(ch) > operatorPrio(opFirst) ) {
                            s.push(opFirst);
                            break;
                        } else
                            outArray.add(opFirst);
                    }
                }
                s.push(ch);
            }

            else if(ch == '(')
                s.push(ch);
            else if(ch == ')')
                while (!s.isEmpty()) {
                    char chNext = s.pull();
                    if (chNext == '(')
                        break;
                    else
                        outArray.add(chNext);
                }
            else
                outArray.add(ch);
        }
        while (!s.isEmpty())
            outArray.add(s.pull());
        return outArray;
    }

    private static int operatorPrio(char op){
        if(op=='+' || op=='-')
            return 1;
        if(op=='*' || op=='/' || op=='%')
            return 2;
        if(op=='^')
            return 3;
        return -1;
    }

    private static boolean isOperator(char c){
        Pattern p = Pattern.compile("[\\-+*/^]");
        Matcher m = p.matcher(c+"");
        return m.matches();
    }
}

class Tree {
    private Node root;
    LinkedList<Double> stk = new LinkedList<>();
    List <Character> record = new ArrayList<>();


    public Tree() {
        root = null;
    }

    public void insert(String s) {

        List <Character> ss;
        Conv c = new Conv(s);
        ss = c.infix2Postfix();                                //System.out.println(s +" >> " +ss);
        uniQueue<Node> stack = new uniQueue<> ();
        Node newNode;
        for(char ch: ss) {
            if (ch >= '0' && ch <= '9') {
                newNode = new Node(ch);
                stack.push(newNode);
            } else if (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^' || ch=='%'){
                Node n1 = stack.pull();
                Node n2 = stack.pull();
                newNode = new Node(ch, n2, n1);
                stack.push(newNode);
            }
        }
        root = stack.pull();
    }

    public void traversePostfix (){
        postOrder(root);
    }

    public Double getResult (){
        // ### Calc Result
        for(char c: record) {
            if (c >= '0' && c <= '9') {
                stk.add(Double.valueOf(c-48));
            } else {
                Double n1 = stk.pop();
                Double n2 = stk.pop();
                Double res = 0.0;
                if (c == '*') res = n1 * n2;
                 else if (c == '/') res = n1 / n2;
                 else if (c == '-') res = n1 - n2;
                 else if (c == '+') res = n1 + n2;
                 else if (c == '%') res = n1 % n2;
                stk.push(res);
            }
        }
        System.out.println(record.toString());
//        System.out.println(stk.peek());
        return stk.pop();
    }



    private void postOrder(Node thisRoot) {
        if (thisRoot != null){
            postOrder(thisRoot.left);
            postOrder(thisRoot.right);
//            System.out.print(thisRoot);
            record.add(thisRoot.toString().charAt(0));
        }

    }
}