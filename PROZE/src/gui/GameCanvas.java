package gui;

import configuration.Configer;
import gameLogic.Cannon;
import gameLogic.GameObjectList;
import gameLogic.MovingObject;
import spaceInvaders.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Klasa odpowiadajaca za plotno do wyswietlania gry
 */
public class GameCanvas extends Canvas {

    private final GameObjectList gameObjectList;
    private final Cannon cannon;
    private final Configer confer;

    /**
     * Konstruktor klasy GameCanvas
     */
    public GameCanvas(Color colorBackground, GameObjectList gameObjectList, Cannon cannon, Game game) {
        System.out.println("konstrukcja dziala");
        setBackground(colorBackground);
        this.gameObjectList = gameObjectList;
        this.cannon = cannon;
        this.confer = game.getConfiger();
    }

    /**
     * Metoda laczaca z zasobami ekranu
     */
    public void addNotify() {
        super.addNotify();
        setPreferredSize(new Dimension(confer.getPreferredScreenWidth(), confer.getPreferredScreenHeight()));
    }

    /**
     * Metoda rysujaca po plotnie
     */
    public void paint(Graphics g) {
        Dimension size = getSize();

        for (MovingObject shape : gameObjectList) {
            g.setColor(shape.getColor());
            g.fillRect((int) (shape.getX() * size.getWidth()), (int) (shape.getY() * size.getHeight()),
                    (int) (shape.getWidth() * size.getWidth()), (int) (shape.getHeight() * size.getHeight()));
        }
        cannon.draw(g, size);
    }

}
