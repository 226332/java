package Projekt1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class FigureRenderer extends JPanel implements MouseListener {
    private static final long serialVersionUID = 1L;
    private ArrayList<Figure> _figures;
    private Figure            _selected        = null;
    public static final int   MAX_X            = 800;
    public static final int   MAX_Y            = 600;

    public FigureRenderer(ArrayList<Figure> figures) {
        _figures = figures;
        setPreferredSize(new Dimension(MAX_X, MAX_Y));
        setBackground(Color.black);
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Figure figure : _figures) {
            figure.render(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        _selected = null;

        for (Figure f : _figures) {
            if (f.checkForBounds(e.getX(), e.getY())) {
                _selected = f;
            }
        }
        System.out.println(_selected + " " + e.getX() + " " + e.getY());
    }

    public void removeSelectedFigure(){
        if(_selected!=null)
            _figures.remove(_selected);
    }

    public Figure getSelectedFigure() {
        return _selected;
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
}
