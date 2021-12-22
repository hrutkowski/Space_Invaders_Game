package gameLogic;

import gui.GameFrame;

/** Klasa odpowiadajaca za animacje */
public class Animation implements Runnable {

    /** Atrybut klasy GameFrame */
    final private GameFrame gameFrame;
    /** Atrubut klasy Thread */
    private Thread kicker;

    /** Konstruktor klasy Animation */
    public Animation(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        this.gameFrame.setFocusable(true);
        this.gameFrame.setFocusTraversalKeysEnabled(false);
    }
    /**Metoda ustawiajaca watek */
    public void setKicker(Thread kicker) {
        this.kicker = kicker;
    }
    /** Metoda odpowiadajaca za wykonywanie sie animacji */
    @Override
    public void run() {
        GameObjectList gameObjectList = gameFrame.getGameObjectList();
        float dX = 0.015f;
        float dY = 0.015f;
        while (kicker == Thread.currentThread()) {
            try {Thread.sleep(50);}
            catch (InterruptedException ignore) {}
            float valueXRightEnemy = 0;
            float valueXLeftEnemy = 1;
            float wodthRightEnemy = 0;
            float helpfulY = 0;
            for (Enemy shape : gameObjectList) {
                if(shape.getX() > valueXRightEnemy) {
                    valueXRightEnemy = shape.getX();
                    wodthRightEnemy = shape.getWidth();}
                if(shape.getX() < valueXLeftEnemy) {
                    valueXLeftEnemy = shape.getX();}
            }
            if ((valueXRightEnemy + dX) >= (1f - wodthRightEnemy) || valueXLeftEnemy + dX <= 0f) {
                dX = -dX;
                helpfulY = dY;
            }
            for (Enemy shape : gameObjectList) {
                shape.setX(shape.getX() + dX);
                shape.setY(shape.getY() + helpfulY);
            }
            gameFrame.getGameCanvas().repaint();
        }
    }
}
