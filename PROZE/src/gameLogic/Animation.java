package gameLogic;

import gui.GameFrame;
import helpfulTools.ColorTranslator;
import spaceInvaders.Game;

import java.io.IOException;
import java.util.Random;

/** Klasa odpowiadajaca za animacje */
public class Animation implements Runnable {

    /** Atrybut klasy Game */
    final private Game game;
    /** Atrybut klasy GameFrame */
    final private GameFrame gameFrame;
    /** Atrubut klasy Thread */
    private Thread kicker;
    /** Atrybut klasy Physics */
    final private Physics physics;


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
        GameObjectList gameCannonBulletList = gameFrame.getGameCannonBulletList();
        GameObjectList gameEnemyBulletList = gameFrame.getGameEnemyBulletList();

        int counter=0;
        float dX = 0.015f;
        float dY = 0.015f;

        while (kicker == Thread.currentThread()) {
            try {
                Thread.sleep(game.getConfiger().getFps());
            } catch (InterruptedException ignore) {
            }
            float valueXRightEnemy = 0;
            float valueXLeftEnemy = 1;
            float widthRightEnemy = 0;
            float helpfulY = 0;
            for (MovingObject shape : gameEnemyList) {
                if (shape.getX() > valueXRightEnemy) {
                    valueXRightEnemy = shape.getX();
                    widthRightEnemy = shape.getWidth();
                }
                if (shape.getX() < valueXLeftEnemy) {
                    valueXLeftEnemy = shape.getX();
                }
            }

            if ((valueXRightEnemy + dX) >= (1f - widthRightEnemy) || valueXLeftEnemy + dX <= 0f) {
                dX = -dX;
                helpfulY = dY;
            }

            for (MovingObject shape : gameEnemyList) {
                shape.setX(shape.getX() + dX);
                shape.setY(shape.getY() + helpfulY);
            }

            for (MovingObject bullet : gameCannonBulletList) {
                float temp = (float) (bullet.getY() - 0.02);
                bullet.setY(temp);
            }

            for (MovingObject bullet : gameEnemyBulletList) {
                float temp = (float) (bullet.getY() + 0.02);
                bullet.setY(temp);
            }

            if (game.getLevelHelper().getLevel() == game.getConfiger().getNumberLevels() && gameEnemyList.isEmpty()) {
                game.stopAnimation();
                game.setGameWon();
                game.getHighScoreManager().addPlayer(game.getGameFrame().getPlayer());
                try {
                    game.getHighScoreManager().saveScores();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (gameEnemyList.isEmpty() && !game.isGameWon()) {
                game.getLevelHelper().nextLevel();
                try {
                    game.getLeveler().loadLevelConfiguration(game.getLevelHelper().getLevelPath(game.getConfiger()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ColorTranslator colorTranslator = new ColorTranslator();
                game.getGameFrame().addEnemy(game.getLeveler().getEnemyNumber(), colorTranslator);
                game.getGameFrame().getGameCanvas().setBackground(colorTranslator.translateColor(game.getLeveler().getColorBackground()));
                game.getGameFrame().getPlayer().setPoints(game.getGameFrame().getPlayer().getPoints()+game.getLeveler().getEndLevelPoints());
                game.getGameFrame().nextLevel();
                gameEnemyBulletList.clear();
                gameCannonBulletList.clear();
            }
            else {
                if(counter==15 && !game.gameWon) {
                    Random rand = new Random();
                    gameEnemyList.get(rand.nextInt(gameEnemyList.size())).fire(gameEnemyBulletList, game.getConfiger().getBulletWidth(), game.getConfiger().getBulletHeight());
                    counter = 0;
                }
            }

            gameCannonBulletList.removeIf( bullet -> ( (bullet.getY()+bullet.getHeight()) <= 0.05f) );
            gameEnemyBulletList.removeIf( bullet -> ( (bullet.getY()) >= 0.95f) );

            physics.collisionEnemy(gameEnemyList, gameCannonBulletList);
            physics.collisionCannon(game.getCannon(), gameEnemyBulletList);
            physics.collisionEnemyHitCannon(game.getCannon(), gameEnemyList);
            physics.downWallEnemy(game.getCannon(), gameEnemyList);

            counter+=1;

            gameFrame.setScore(game.getGameFrame().getPlayer().getPoints());
            gameFrame.setLives(game.getCannon().getLives());

            if(game.getCannon().getLives()==0) {
                game.stopAnimation();
                game.showGameOver();
                game.showGameWon();
            }

            gameFrame.getGameCanvas().repaint();
        }
    }
}
