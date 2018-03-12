package Zad2;

public class Point_2D extends Point_1D {
    protected int y;

    public Point_2D(int x, int y) {
        super(x);
        this.y = y;
    }

    public Point_2D(Point_2D point) {
        super(point.x);
        this.y = point.y;
    }

    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y;
    }
    
    public int distance(Point_2D p2) {
        return (int) Math.sqrt((this.y-p2.y)*(this.y-p2.y)+(this.x-p2.x)*(this.x-p2.x));
    }

    public String toString() {
        return String.valueOf(x) + " " + String.valueOf(y);
    }
}