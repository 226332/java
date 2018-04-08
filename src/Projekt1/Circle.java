package Projekt1;

import java.awt.Graphics;
import java.awt.Color;

import Zad2.Point_2D;

public class Circle implements Figure {
    private int      radius;
    private Point_2D center;

    public Circle(Point_2D c, int r) {
        this.radius = r;
        this.center = c;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);
    }

    @Override
    public void move(int x, int y) {
        center.setX(center.getX() + x);
        center.setY(center.getY() + y);
    }

    @Override
    public boolean checkForBounds(int x, int y) {
        Point_2D temp = new Point_2D(x, y);
        if (center.distance(temp) <= radius) return true;
        return false;
    }

}
