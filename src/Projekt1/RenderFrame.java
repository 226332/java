package Projekt1;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RenderFrame extends JFrame {
    public RenderFrame() {
        super("Figures");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        ArrayList<Figure> figures = new ArrayList<Figure>();
        FigureFactory factory = new FigureFactory();
        for (int i = 0; i < 3; i++) {
            figures.add(factory.createRandomFigure());
        }
        JPanel panel = new FigureRenderer(figures);
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RenderFrame();
    }
}
