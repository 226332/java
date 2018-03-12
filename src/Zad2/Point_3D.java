package Zad2;

public class Point_3D extends Point_2D {
    public int z;

    public Point_3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public String toString() {
        return String.valueOf(x) + " " + String.valueOf(y) + " " + String.valueOf(z);
    }
}