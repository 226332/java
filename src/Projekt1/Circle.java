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
        g.fillOval(center.getx(), center.gety(), radius, radius);

    }
}
