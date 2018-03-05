package Zad2;

public class Punkt_3D extends Punkt_2D {
    public int z;

    public Punkt_3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public String toString() {
        return String.valueOf(x) + " " + String.valueOf(y) + " " + String.valueOf(z);
    }
}