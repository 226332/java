package project1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Zad2.Point_2D;

public class Triangle implements Figure {
    private ArrayList<Point_2D> _points;

    public Triangle(Point_2D p1, Point_2D p2, Point_2D p3) {
        _points = new ArrayList<Point_2D>();
        _points.add(new Point_2D(p1));
        _points.add(new Point_2D(p2));
        _points.add(new Point_2D(p3));
    }

    @Override
    public void render(Graphics g) {
        int x[] = new int[3];
        int y[] = new int[3];
        for (int i = 0; i < 3; i++) {
            x[i] = _points.get(i).getX();
            y[i] = _points.get(i).getY();
        }
        g.setColor(Color.BLUE);
        g.fillPolygon(x, y, 3);
    }

    @Override
    public boolean checkForBounds(int x, int y) {
        Point_2D point = new Point_2D(x,y);
        boolean b1 = sign(point, _points.get(0), _points.get(1)) < 0.0;
        boolean b2 = sign(point, _points.get(1), _points.get(2)) < 0.0;
        boolean b3 = sign(point, _points.get(2), _points.get(0)) < 0.0;

        return ((b1 == b2) && (b2 == b3));
    }

    @Override
    public void move(int x, int y) {
        for (Point_2D p : _points) {
            p.setX(p.getX() + x);
            p.setY(p.getY() + y);
        }

    }
    
    private double sign(Point_2D a, Point_2D b, Point_2D c) {
        return (a.getX() - c.getX()) * (b.getY() - c.getY()) - (b.getX() - c.getX()) * (a.getY() - c.getY());
    }

}
