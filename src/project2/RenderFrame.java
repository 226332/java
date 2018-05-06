package project2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class RenderFrame extends JFrame implements MouseListener {
    private static final long serialVersionUID = 1L;
    public static final int   MAX_WIDTH        = 800;
    public static final int   MAX_HEIGHT       = 1040;
    public static final int   TICK_MS          = 10;
    private RenderPanel       _panel           = new RenderPanel();
    private Map               _map             = Map.getMap();
    private SnailsContainer   _snailsContainer = SnailsContainer.getSnailsContainer();
    private SnailFactory      _snailFactory    = new SnailFactory();

    public RenderFrame() {
        super("Snails");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(_panel);
        pack();
        this.addMouseListener(this);
    }

    public void update() {
        _panel.repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!(_map.getTile(e.getX() / Tile.SIZE, e.getY() / Tile.SIZE).hasSnail())) 
            _snailsContainer.addSnail(_snailFactory.createSnail(e.getX() / Tile.SIZE, e.getY() / Tile.SIZE));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
