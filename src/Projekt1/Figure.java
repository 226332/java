package Projekt1;

import java.awt.Graphics;

interface Figure {
    public void render(Graphics g);
    public boolean checkForBounds(int x, int y);
    public void move(int x, int y);
}
