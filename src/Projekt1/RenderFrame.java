package Projekt1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class RenderFrame extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1L;
    private FigureRenderer _panel;
    
    public RenderFrame() {
        super("Figures");
        this.addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        ArrayList<Figure> figures = new ArrayList<Figure>();
        FigureFactory factory = new FigureFactory();
        for (int i = 0; i < 6; i++) {
            figures.add(factory.createRandomFigure());
        }
        _panel = new FigureRenderer(figures);
        add(_panel);
        pack();
    }
    
    public void update() {
        _panel.repaint();
    }

    public static void main(String[] args) throws InterruptedException {
        RenderFrame frame = new RenderFrame();
        while (true) {
            frame.update();
            Thread.sleep(10);
        }
    }
    

    @Override
    public void keyPressed(KeyEvent arg) {
        int moveQuant = 10;
        if (_panel.getSelectedFigure() != null) {
            switch (arg.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    _panel.getSelectedFigure().move(-moveQuant, 0);
                    break;
                case KeyEvent.VK_RIGHT:
                    _panel.getSelectedFigure().move(moveQuant, 0);
                    break;
                case KeyEvent.VK_UP:
                    _panel.getSelectedFigure().move(0, -moveQuant);
                    break;
                case KeyEvent.VK_DOWN:
                    _panel.getSelectedFigure().move(0, moveQuant);
                    break;
                case KeyEvent.VK_DELETE:
                    _panel.removeSelectedFigure();
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

}
