package hw.hw25;

/**
 * Created by tonchief on 12/25/2016.
 *
 * 25. Паттерн Memento. Реализовать алгоритм игры «крестики-нолики». Реализовать возможность «взять назад ход»
 */

public class TicTacToe {
    private Field.Memento previousTurn;

    private Field field;
    private int currentPlayer ;

    public void turn(int x, int y) {
        previousTurn = field.createMemento();
        field.set(x, y, currentPlayer);
        swapPlayer();
    }

    public void undoTurn() {
        field.restore(previousTurn);
    }

    private void swapPlayer() {
        currentPlayer  = 1 - currentPlayer;
    }
}
