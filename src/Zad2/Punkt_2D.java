package Zad2;

public class Punkt_2D extends Punkt_1D {
    protected int y;

    public Punkt_2D(int x, int y) {
        super(x);
        this.y = y;
    }

    public String toString() {
        return String.valueOf(x) + " " + String.valueOf(y);
    }
}