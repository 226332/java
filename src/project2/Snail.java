package project2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Snail extends Thread {
    private Random          _generator     = new Random();
    private Tile            _tile;
    private Tile[][]        neighbours;
    public static int       EAT_AMOUNT     = 100;
    public final static int SIZE           = Tile.SIZE;
    public static int       MOVE_FREQUENCY = 12;
    public static int       EAT_FREQUENCY  = 15;

    Snail(Tile tile) {
        _tile = tile;
        _tile.setHasSnail(true);
        neighbours = Map.getMap().getNeighbouringTiles(_tile);
    }

    @Override
    public void run() {
        while (true) {
            update();
            try {
                sleep(RenderFrame.TICK_MS);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void eat() {
        int biggestGrass = 0;
        Tile tileToEatGrass = _tile;

        for (Tile[] row : neighbours) {
            for (Tile t : row) {
                if (t != null && t != _tile && t.getGrassLevel() > biggestGrass && !t.hasSnail()) {
                    tileToEatGrass = t;
                    biggestGrass = t.getGrassLevel();
                }
            }
        }
        if (tileToEatGrass != _tile) tileToEatGrass.decreaseGrassLevel(EAT_AMOUNT);
    }

    private void move() {

        int randomX = _generator.nextInt(3);
        int randomY = _generator.nextInt(3);
        while (neighbours[randomX][randomY] == null || neighbours[randomX][randomY].hasSnail()) {
            randomX = _generator.nextInt(3);
            randomY = _generator.nextInt(3);
        }
        _tile.setHasSnail(false);
        _tile = neighbours[randomX][randomY];
        _tile.setHasSnail(true);

    }

    public synchronized void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(_tile.getX() * Tile.SIZE, _tile.getY() * Tile.SIZE, SIZE, SIZE);
    }

    public void update() {
        if (_generator.nextInt(EAT_FREQUENCY) % (EAT_FREQUENCY + 1) == 0) {
            eat();
        }
        if (_generator.nextInt(MOVE_FREQUENCY) % (MOVE_FREQUENCY + 1) == 0) {
            move();
        }
        neighbours = Map.getMap().getNeighbouringTiles(_tile);
    }

}
