package project2;

import java.awt.Color;
import java.awt.Graphics;

public class Tile {
    private double          _grassLevel      = 128;
    private int             _x, _y;
    private boolean         _hasSnail        = false;
    public static final int SIZE             = 10;
    public static final int MAX_X            = RenderFrame.MAX_WIDTH / SIZE;
    public static final int MAX_Y            = RenderFrame.MAX_HEIGHT / SIZE;
    public static final int MAX_GRASS        = 255;
    public static double    GRASS_GROWTHRATE = 0.15;

    public boolean hasSnail() {
        return _hasSnail;
    }

    public synchronized void  setHasSnail(boolean has) {
        _hasSnail = has;
    }

    public Tile(int x, int y, int grassLevel) {
        _x = x;
        _y = y;
        _grassLevel = grassLevel;
    }

    public Tile(int x, int y) {
        _x = x;
        _y = y;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public int getGrassLevel() {
        return (int) _grassLevel;
    }

    public synchronized void decreaseGrassLevel(int amount) {
        if (_grassLevel < amount)
            _grassLevel = 0;
        else
            _grassLevel -= amount;
    }

    public synchronized void update() {
        if (_grassLevel < MAX_GRASS) _grassLevel += GRASS_GROWTHRATE;
    }

    public void render(Graphics g) {
        g.setColor(new Color(34, (int) _grassLevel, 10));
        g.fillRect(_x * SIZE, _y * SIZE, SIZE, SIZE);
    }
}
