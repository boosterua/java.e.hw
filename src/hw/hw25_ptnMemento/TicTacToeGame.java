package hw.hw25_ptnMemento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonchief on 12/25/2016.
 * Pattern Memento
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
        this.cells = cells;
    }

    public Memento saveToMemento(){
        return new Memento(cells);
    }

    public void restoreFromMemento(Memento m){
        cells = m.getCells();
    }

}

class Game { // CareTaker

    private static final int SIZE = 3;
    private Integer[] cells;
    private Originator field = new Originator();
    private List<Memento> fieldStates = new ArrayList<>();


    public Game() {
        this.cells = new Integer[SIZE * SIZE];
    }

    public void set(int x, int y, int value) {
        checkBounds(x);
        checkBounds(y);
        cells[x + y * SIZE] = value;
        field.set(cells);
        fieldStates.add(field.saveToMemento());
    }

    private void checkBounds(int x) {
        if (x >= SIZE || x < 0)
            throw new IndexOutOfBoundsException();
    }

    public void getMemento(int undoSteps) {
        if(undoSteps > fieldStates.size())
            throw new ArrayIndexOutOfBoundsException("No such state saved.");
        field.restoreFromMemento(fieldStates.get(fieldStates.size() - undoSteps));
    }
}


class Player { // Caretaker , Observer
//    private Memento previousTurn;
    private Game game = new Game();
    private int currentPlayer ;

    public void turn(int x, int y) {
        game.set(x, y, currentPlayer);
        swapPlayer();
    }

    public void undoTurn() {
        game.getMemento(-1);
    }

    private void swapPlayer() {
        currentPlayer = 1 - currentPlayer;
    }

}