package Projekt1;

import java.awt.Color;
import java.awt.Graphics;

import Zad2.Point_2D;

public class Square implements Figure{
    private Point_2D p1;
    private Point_2D p2;

    public Square(Point_2D p1, Point_2D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(p1.getx(), p2.gety(), p1.distance(p2), p1.distance(p2));
    }

}
