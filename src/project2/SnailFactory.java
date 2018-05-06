package project2;

import java.util.Random;

public class SnailFactory {
    private Random _generator = new Random();

    public Snail createRandomSnail() {
        int x = _generator.nextInt(Tile.MAX_X);
        int y = _generator.nextInt(Tile.MAX_Y);
        return new Snail(Map.getMap().getTile(x, y));
    }
    
    public Snail createSnail(int x, int y) {
        return new Snail(Map.getMap().getTile(x, y));
    }

}
