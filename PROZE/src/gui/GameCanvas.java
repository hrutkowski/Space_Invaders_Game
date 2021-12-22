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
    private final GameObjectList gameObjectList;
    /** Atrybut klasy Cannon */
    private final Cannon cannon;
    /** Atrybut klasy Configer */
    private final Configer confer;

    /** Konstruktor klasy GameCanvas */
    public GameCanvas(Color colorBackground, GameObjectList gameObjectList, Cannon cannon, Game game) {
        setBackground(colorBackground);
        this.gameObjectList = gameObjectList;
        this.cannon = cannon;
        this.confer = game.getConfiger();
    }
    /** Metoda laczaca z zasobami ekranu */
    public void addNotify() {
        super.addNotify();
        setPreferredSize(new Dimension(confer.getPreferredScreenWidth(), confer.getPreferredScreenHeight()));
    }
    /** Metoda rysujaca po plotnie */
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
