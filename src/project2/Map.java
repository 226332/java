package project2;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.Random;

public class Map extends Thread {
    private Random     _generator = new Random();
    private Tile[][]   _tiles     = new Tile[Tile.MAX_X][Tile.MAX_Y];
    private static Map _map;

    private Map() {
        for (int x = 0; x < _tiles.length; x++) {
            for (int y = 0; y < _tiles[0].length; y++) {
                _tiles[x][y] = new Tile(x, y, _generator.nextInt(Tile.MAX_GRASS));
            }
        }
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

    public static Map getMap() {
        if (_map == null) {
            _map = new Map();
            _map.start();
            return _map;
        } else
            return _map;
    }

    public Tile getTile(int x, int y) {
        return _tiles[x][y];
    }

    public void update() {
        for (Tile[] row : _tiles) {
            for (Tile t : row) {
                t.update();
            }
        }
    }

    public void render(Graphics g) {
        for (Tile[] row : _tiles) {
            for (Tile t : row) {
                t.render(g);
            }
        }
    }

    public Tile[][] getNeighbouringTiles(Tile tile) {
        Tile[][] neighbours = new Tile[3][3];
        int startX = tile.getX() - 1;
        int startY = tile.getY() - 1;
        for (int x = startX; x < tile.getX() + 2; x++) {
            for (int y = startY; y < tile.getY() + 2; y++) {
                try {
                    neighbours[x - startX][y - startY] = _tiles[x][y];
                } catch (ArrayIndexOutOfBoundsException e) {
                    neighbours[x - startX][y - startY] = null;
                }
            }
        }
        return neighbours;
    }
}
