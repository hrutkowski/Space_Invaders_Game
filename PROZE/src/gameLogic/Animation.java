package gameLogic;

import gui.GameFrame;
import gui.MyShape;

import java.util.concurrent.ThreadLocalRandom;
/** Klasa odpowiadajaca za animacje */
public class Animation implements Runnable {

    final private GameFrame gameFrame;
    private Thread kicker;
/** Konstruktor klasy Animation */
    public Animation(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
/** Metoda ustawiajaca watek */
    public void setKicker(Thread kicker) {
        this.kicker = kicker;
    }
/** Metoda odpowiadajaca za wykonywanie sie animacji */
    @Override
    public void run() {
        GameObjectList gameObjectList = gameFrame.getGameObjectList();
        while (kicker == Thread.currentThread()) {
            try {
                Thread.sleep(50);
                gameFrame.getGameCanvas().repaint();
            } catch (InterruptedException ignore) {
            }
            for (MyShape shape : gameObjectList) {      // Petla po wszystkich obiektach gameObjectList
                float newX = shape.getX() + 0.015f * ThreadLocalRandom.current().nextFloat();
                if (Float.compare(newX + shape.getWidth(), 1f) >= 0) {
                    shape.setX(0f);
                } else {
                    shape.setX(newX);
                }
                float newY = shape.getY() + 0.02f * ThreadLocalRandom.current().nextFloat();
                shape.setY(Float.compare(shape.getY() + shape.getHeight(), 1f) >= 0 ? 0f : newY);
            }
        }
    }
}
