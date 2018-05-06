package project2;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class SnailsContainer {
    private ArrayList<Snail>       _snails;
    private static SnailsContainer _snailsContainer;
    private SnailFactory           _snailFactory = new SnailFactory();

    final public static int STARTING_SNAILS_AMOUNT = 10;

    private SnailsContainer() {
        _snails = new ArrayList<Snail>();
        for (int i = 0; i < STARTING_SNAILS_AMOUNT; i++) {
            Snail snail = _snailFactory.createRandomSnail();
            _snails.add(snail);
            snail.start();
        }
    }

    public static SnailsContainer getSnailsContainer() {
        if (_snailsContainer == null)
            return _snailsContainer = new SnailsContainer();
        else
            return _snailsContainer;
    }

    public void addSnail(Snail snail) {
        _snails.add(snail);
        snail.start();
    }

    public void render(Graphics g) {
        for (Snail s : _snails) {
            s.render(g);
        }
    }

}
