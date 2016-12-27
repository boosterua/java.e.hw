package hw.hw25_ptnMemento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonchief on 12/25/2016.
 * Pattern Memento
 *
 * 25. Паттерн Memento. Реализовать алгоритм игры «крестики-нолики». Реализовать возможность «взять назад ход» *
 */


class Memento {
    private Integer[] cells;

    protected Memento(Integer[] cells) {
        this.cells = cells;
    }

    public Integer[] getCells(){
        return this.cells;
    }
}


class Originator{
    private Integer[] cells;

    public void set(Integer[] cells){
        this.cells = cells.clone();
    }

    public Memento saveToMemento(){
        return new Memento(cells);
    }

    public void restoreFromMemento(Memento m){
        cells = m.getCells();
    }

    public Integer[] getCells(){
        return cells;
    }

}

class Game { // CareTaker

    private static final int SIZE = 3;
    private Integer[] cells;
    private Originator field = new Originator();
    private List<Memento> fieldStates = new ArrayList<>();
    private int pointer = -1;

    public Game() {
        this.cells = new Integer[SIZE * SIZE];
    }

    public void set(int x, int y, int value) {
        checkBounds(x);
        checkBounds(y);
        cells[x + y * SIZE] = value;
        field.set(cells);
        System.out.println(pointer);
        if(++pointer >= fieldStates.size())
            fieldStates.add(field.saveToMemento());
        else
            fieldStates.set(pointer, field.saveToMemento());
    }

    private void checkBounds(int x) {
        if (x >= SIZE || x < 0)
            throw new IndexOutOfBoundsException();
    }

    public void getMemento(int undoSteps) {
        if(undoSteps > pointer) // was: > fieldStates.size()
            throw new ArrayIndexOutOfBoundsException("No such state saved.");
        pointer -= undoSteps;
        field.restoreFromMemento(fieldStates.get(pointer));
            //        field.restoreFromMemento(fieldStates.get(fieldStates.size() - undoSteps-1));
        cells = field.getCells();
    }


//    public void debug(){
//        int i=0;
//        for (Memento m : fieldStates){
//            field.restoreFromMemento(fieldStates.get(i++));
//            cells = field.getCells();
//            System.out.printf(toString());
//        }
//    }

    @Override
    public String toString(){
        String output="";
        int x = 0;
        for (Integer el: cells) {
            if(el == null)
                output += "[ ]";
            else
                output += (el == 1 ? "[X]" :  "[O]" );
            if(++x >= SIZE) {
                output += "\n";
                x = 0;
            }
        }
        return output +"\n";
    }
}


public class TicTacToeGame { //
    private static Game game = new Game();
    private static int currentPlayer ;

    public void turn(int x, int y) {
        game.set(x, y, currentPlayer);
        swapPlayer();
    }

    public void undoTurn() {
        game.getMemento(-1);
    }

    private int swapPlayer() {
        currentPlayer = 1 - currentPlayer;
        return currentPlayer;
    }

    public static void main(String[] args) {
        TicTacToeGame g = new TicTacToeGame();
        game.set(1,1, g.swapPlayer());
        System.out.println(game);
        game.set(2,2, g.swapPlayer());
        System.out.println(game);
        game.set(1,2, g.swapPlayer());
        System.out.println(game);
        game.getMemento(1);
//        game.getMemento(1);
        System.out.println(game);

    }

}