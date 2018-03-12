package Projekt1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Zad2.Point_2D;

public class Triangle implements Figure {
    private ArrayList<Point_2D> points;

    public Triangle(Point_2D p1, Point_2D p2, Point_2D p3) {
        points = new ArrayList<Point_2D>();
        points.add(new Point_2D(p1));
        points.add(new Point_2D(p2));
        points.add(new Point_2D(p3));
    }

    @Override
    public void render(Graphics g) {
        int x[] = new int[3];
        int y[] = new int[3];
        for (int i = 0; i < 3; i++) {
            x[i] = points.get(i).getx();
            y[i] = points.get(i).gety();
        }
        g.setColor(Color.BLUE);
        g.fillPolygon(x, y, 3);
    }
}
