package project1;

import java.awt.Color;
import java.awt.Graphics;

import Zad2.Point_2D;

public class Square implements Figure {
    private Point_2D p1;
    private Point_2D p2;

    public Square(Point_2D p1, Point_2D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(p1.getX(), p1.getY(), Math.abs(p1.getX() - p2.getX()), Math.abs(p1.getY() - p2.getY()));
    }

    @Override
    public boolean checkForBounds(int x, int y) {
        if ((x >= p1.getX() && x <= p2.getX()) && (y >= p1.getY() && y <= p2.getY())) {
            return true;
        } else
            return false;
    }

    @Override
    public void move(int x, int y) {
        p1.setX(p1.getX() + x);
        p1.setY(p1.getY() + y);
        p2.setX(p2.getX() + x);
        p2.setY(p2.getY() + y);
    }

}
