package Projekt1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class FigureRenderer extends JPanel {
    private ArrayList<Figure> _figures;
    public static final int MAX_X=800;
    public static final int MAX_Y=600;
    
    public FigureRenderer(ArrayList<Figure> figures) {
        _figures = figures;
        setPreferredSize(new Dimension(MAX_X, MAX_Y));
        setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (Figure figure : _figures) {
            figure.render(g);
        }
    }
}
