package project2;

import javax.swing.JFrame;

public class RenderFrame extends JFrame  {
    private static final long serialVersionUID = 1L;
    public static final int   MAX_WIDTH        = 800;
    public static final int   MAX_HEIGHT       = 1040;
    public static final int   TICK_MS          = 10;
    private RenderPanel       _panel           = new RenderPanel();

    public RenderFrame() {
        super("Snails");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(_panel);
        pack();

    }

    public void update() {
        _panel.repaint();

    }


}
