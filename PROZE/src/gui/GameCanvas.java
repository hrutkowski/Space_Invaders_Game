package gui;

import configuration.Configer;
import gameLogic.Cannon;
import gameLogic.GameObjectList;
import gameLogic.MovingObject;
import spaceInvaders.Game;

import java.awt.*;

/** Klasa odpowiadajaca za plotno do wyswietlania gry */
public class GameCanvas extends Canvas {

    /** Atrybut klasy GameObjectList */
    private final GameObjectList gameEnemyList;
    private final GameObjectList gameBulletList;
    /** Atrybut klasy Cannon */
    private final Cannon cannon;
    /** Atrybut klasy Configer */
    private final Configer confer;

    /** Konstruktor klasy GameCanvas */
    public GameCanvas(Color colorBackground, GameObjectList gameEnemyList, GameObjectList gameBulletList, Cannon cannon, Game game) {
        setBackground(colorBackground);
        this.gameEnemyList = gameEnemyList;
        this.cannon = cannon;
        this.confer = game.getConfiger();
        this.gameBulletList = gameBulletList;
    }
    /** Metoda laczaca z zasobami ekranu */
    public void addNotify() {
        super.addNotify();
        setPreferredSize(new Dimension(confer.getPreferredScreenWidth(), confer.getPreferredScreenHeight()));
    }
    /** Metoda rysujaca po plotnie */
    public void paint(Graphics g) {
        Dimension size = getSize();
        for (MovingObject enemy : gameEnemyList) {
            g.setColor(enemy.getColor());
            g.fillRect((int) (enemy.getX() * size.getWidth()), (int) (enemy.getY() * size.getHeight()),
                    (int) (enemy.getWidth() * size.getWidth()), (int) (enemy.getHeight() * size.getHeight()));
        }
        for (MovingObject bullet : gameBulletList) {
            g.setColor(bullet.getColor());
            g.fillRect((int) (bullet.getX() * size.getWidth()), (int) (bullet.getY() * size.getHeight()),
                    (int) (bullet.getWidth() * size.getWidth()), (int) (bullet.getHeight() * size.getHeight()));
        }
        cannon.draw(g, size);

    }
}
