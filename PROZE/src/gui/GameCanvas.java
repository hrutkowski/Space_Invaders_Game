package gui;

import gameLogic.Cannon;
import gameLogic.GameObjectList;
import gameLogic.MovingObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/** Klasa odpowiadajaca za plotno do wyswietlania gry */
public class GameCanvas extends Canvas {

    private final GameObjectList gameObjectList;
    private final Cannon cannon;


    /**
     * Konstruktor klasy GameCanvas
     */
    public GameCanvas(Color colorBackground, GameObjectList gameObjectList, Cannon cannon) {
        setBackground(colorBackground);
        this.gameObjectList = gameObjectList;
        this.cannon = cannon;
    }

    /**
     * Metoda laczaca z zasobami ekranu
     */
    public void addNotify() {
        super.addNotify();
        setPreferredSize(new Dimension(500, 300));
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
        drawCannon(g);
    }

    private void drawCannon(Graphics g) {
        Dimension size = getSize();
        g.setColor(cannon.getColor());
        g.fillRect((int) (cannon.getX() * size.getWidth()), (int) (cannon.getY() * size.getHeight()),
                (int) (cannon.getWidth() * size.getWidth()), (int) (cannon.getHeight() * size.getHeight()));
    }

    }
