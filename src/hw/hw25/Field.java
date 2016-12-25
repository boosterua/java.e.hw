package hw.hw25;

/**
 * Created by tonchief on 12/25/2016.
 */

public class Field {
    private static final int SIZE = 3;

    private int[] cells;

    public Field() {
        this.cells = new int[SIZE * SIZE];
    }

    public void set(int x, int y, int value) {
        checkBounds(x);
        checkBounds(y);

        cells[x + y * SIZE] = value;
    }

    public void restore(Memento memento) {
        this.cells = memento.getCells();
    }

    public Memento createMemento() {
        return new Memento(cells);
    }

    private void checkBounds(int x) {
        if (x >= SIZE || x < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static class Memento {
        private int[] cells;

        protected Memento(int[] cells) {
            this.cells = cells.clone();
        }

        public int[] getCells() {
            return cells;
        }

        public void setCells(int[] cells) {
            this.cells = cells;
        }
    }
}
