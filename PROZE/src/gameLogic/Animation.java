package gameLogic;

import gui.GameFrame;
import spaceInvaders.Game;

/** Klasa odpowiadajaca za animacje */
public class Animation implements Runnable {

    /** Atrybut klasy Game */
    final private Game game;
    /** Atrybut klasy GameFrame */
    final private GameFrame gameFrame;
    /** Atrubut klasy Thread */
    private Thread kicker;
    /** Atrybut klasy Physics */
    private final Physics physics;

    /** Konstruktor klasy Animation */
    public Animation(GameFrame gameFrame, Game game) {
        this.gameFrame = gameFrame;
        this.game = game;
        this.gameFrame.setFocusable(true);
        this.gameFrame.setFocusTraversalKeysEnabled(false);
        this.physics = new Physics(game);
    }
    /**Metoda ustawiajaca watek */
    public void setKicker(Thread kicker) {
        this.kicker = kicker;
    }
    /** Metoda odpowiadajaca za wykonywanie sie animacji */
    @Override
    public void run() {
        GameObjectList gameEnemyList = gameFrame.getGameEnemyList();
        GameObjectList gameBulletList = gameFrame.getGameBulletList();
        float dX = 0.015f;
        float dY = 0.015f;
        while (kicker == Thread.currentThread()) {
            try {Thread.sleep(50);}
            catch (InterruptedException ignore) {}
            float valueXRightEnemy = 0;
            float valueXLeftEnemy = 1;
            float widthRightEnemy = 0;
            float helpfulY = 0;
            for (MovingObject shape : gameEnemyList) {
                if(shape.getX() > valueXRightEnemy) {
                    valueXRightEnemy = shape.getX();
                    widthRightEnemy = shape.getWidth();}
                if(shape.getX() < valueXLeftEnemy) {
                    valueXLeftEnemy = shape.getX();}
            }
            if ((valueXRightEnemy + dX) >= (1f - widthRightEnemy) || valueXLeftEnemy + dX <= 0f) {
                dX = -dX;
                helpfulY = dY;
            }
            for (MovingObject shape : gameEnemyList) {
                shape.setX(shape.getX() + dX);
                shape.setY(shape.getY() + helpfulY);
            }

            for(MovingObject bullet : gameBulletList) {
                float temp = (float) (bullet.getY() - 0.01);
                bullet.setY(temp);
            }

            gameFrame.setScore(game.getPlayer().getPoints());

            gameBulletList.removeIf( bullet -> ( (bullet.getY()+bullet.getHeight()) <= 0.1f) );

            physics.collision(gameEnemyList,gameBulletList);

            gameFrame.getGameCanvas().repaint();
        }
    }
}
