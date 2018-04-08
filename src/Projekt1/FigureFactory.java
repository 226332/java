package Projekt1;

import java.util.Random;

import Zad2.Point_2D;

public class FigureFactory {
    private Random _generator = new Random();

    public Figure createRandomFigure() {
        int nextFigure = _generator.nextInt(3);
        if (nextFigure == 0) {
             return createRandomTriangle();
        } else if (nextFigure == 1) {
            return createRandomSquare();
        } else
            return createRandomCircle();
    }

    public Triangle createRandomTriangle() {
        Point_2D[] points = new Point_2D[3];
        for (int i = 0; i < 3; i++) {
            points[i] = new Point_2D(_generator.nextInt(FigureRenderer.MAX_X),
                    _generator.nextInt(FigureRenderer.MAX_Y));
        }
        return new Triangle(points[0], points[1], points[2]);
    }

    public Square createRandomSquare() {
        Point_2D[] points = new Point_2D[2];
        points[0] = new Point_2D(_generator.nextInt(FigureRenderer.MAX_X), _generator.nextInt(FigureRenderer.MAX_Y));
        do {
            int x = _generator.nextInt(FigureRenderer.MAX_X);
            points[1] = new Point_2D(x, points[0].getY() + (x - points[0].getX()));
        } while ((points[0].getX() >= points[1].getX()) && (points[0].getY() >= points[1].getY()));
        return new Square(points[0], points[1]);
    }

    public Circle createRandomCircle() {
        Point_2D center = new Point_2D(_generator.nextInt(FigureRenderer.MAX_X),
                _generator.nextInt(FigureRenderer.MAX_Y));
        int radius = _generator.nextInt(150);
        return new Circle(center, radius);
    }
}
