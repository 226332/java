package project2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        RenderFrame frame = new RenderFrame();
        while (true) {
            frame.update();
            Thread.sleep(5);
        }
    }

}
