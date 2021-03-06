package project2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RenderPanel extends JPanel implements ChangeListener, MouseListener {
    private static final long serialVersionUID = 1L;

    private Map             _map;
    private SnailsContainer _snailsContainer;
    private JSlider         _snailHunger  = new JSlider(JSlider.VERTICAL, 1, 255, Snail.EAT_AMOUNT);
    private JSlider         _snailSpeed   = new JSlider(JSlider.VERTICAL, 0, 255, (255 / Snail.MOVE_FREQUENCY));
    private SnailFactory    _snailFactory = new SnailFactory();

    public RenderPanel() {
        setPreferredSize(new Dimension(RenderFrame.MAX_WIDTH, RenderFrame.MAX_HEIGHT));
        setBackground(Color.black);
        _map = Map.getMap();
        _snailsContainer = SnailsContainer.getSnailsContainer();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        _snailHunger.addChangeListener(this);

        _snailSpeed.addChangeListener(this);

        Hashtable<Integer, JLabel> labelEat = new Hashtable<Integer, JLabel>();
        labelEat.put(3, new JLabel("Not Hungry"));
        labelEat.put(Snail.EAT_AMOUNT, new JLabel("Normal"));
        labelEat.put(255, new JLabel("Plague"));
        _snailHunger.setLabelTable(labelEat);
        _snailHunger.setPaintLabels(true);
        _snailHunger.setAlignmentX(Component.RIGHT_ALIGNMENT);
        _snailHunger.setAlignmentY(Component.TOP_ALIGNMENT);
        add(_snailHunger);

        Hashtable<Integer, JLabel> labelSpeed = new Hashtable<Integer, JLabel>();
        labelSpeed.put(0, new JLabel("Very slowly"));
        labelSpeed.put(128, new JLabel("Normal"));
        labelSpeed.put(255, new JLabel("Sonic"));
        _snailSpeed.setLabelTable(labelSpeed);
        _snailSpeed.setPaintLabels(true);
        _snailSpeed.setAlignmentX(Component.RIGHT_ALIGNMENT);
        _snailSpeed.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        add(_snailSpeed);
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        _map.render(g);
        _snailsContainer.render(g);
    }

    @Override
    public void stateChanged(ChangeEvent arg0) {
        JSlider source = (JSlider) arg0.getSource();
        if (source == _snailHunger) Snail.EAT_AMOUNT = (int) source.getValue();
        if (source == _snailSpeed) Snail.MOVE_FREQUENCY = (int) (((Math.log(512) - Math.log(source.getValue()))) * 8);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
        if (!(_map.getTile(e.getX() / Tile.SIZE, e.getY() / Tile.SIZE).hasSnail()))
            _snailsContainer.addSnail(_snailFactory.createSnail(e.getX() / Tile.SIZE, e.getY() / Tile.SIZE));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
