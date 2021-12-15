package gui;

import configuration.Configer;
import gameLogic.Cannon;
import gameLogic.GameObjectList;
import gameLogic.MovingObject;
import spaceInvaders.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.Color.blue;
import static java.awt.Color.yellow;

/** Klasa odpowiadajaca za plotno do wyswietlania gry */
public class GameCanvas extends Canvas implements KeyListener {

    private final GameObjectList gameObjectList;
    private final Cannon cannon;


    /**
     * Zmienna okreslajaca stan w ktorym znajduje sie dzialo gracza - ruch w prawo i w lewo
     */
    private typeOfMove cannonState;

    /**
     * Konstruktor klasy GameCanvas
     */
    public GameCanvas(Color colorBackground, GameObjectList gameObjectList, Cannon cannon) {
        setForeground(colorBackground);
        this.gameObjectList = gameObjectList;
        this.cannon = cannon;
        cannonState = typeOfMove.STOPPED;

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
        g.setColor(Color.blue);
        g.fillRect((int) (cannon.getX() * size.getWidth()), (int) (cannon.getY() * size.getHeight()),
                (int) (cannon.getWidth() * size.getWidth()), (int) (cannon.getHeight() * size.getHeight()));
    }

    private enum typeOfMove {
        LEFT,
        RIGHT,
        STOPPED
    }

    /**
     * Metoda ustawiajaca stan dziala gracza
     *
     * @param state stan w zaleznosci od tego jaki przycisk zostal wcisniety
     */
    private void setMovementState(typeOfMove state) {
        cannonState = state;
    }

    /**
     * Metoda do poruszania dzialem gracza
     */
    public void moveCannon() {
        float newX = getX();
        if (cannonState == typeOfMove.LEFT) {
            if (Float.compare(cannon.getX() * cannon.getWidth(), 1f) >= 0) {
                cannon.setX(newX-1);
            } else cannon.setX(newX);
            if (cannonState == typeOfMove.RIGHT) {
                if (Float.compare(cannon.getX() * cannon.getWidth(), 0f) <= 0) {
                    cannon.setX(newX+1);
                } else cannon.setX(newX);
            }
        }
    }

/**
 * Metoda opisujaca co ma sie stac z dzialem gdy nacisnie sie przycisk
 * @param keyEvent obiekt zdarzenia zwiazanego z nacisnieciem przycisku
 */
            @Override
            public void keyTyped (KeyEvent keyEvent){
                System.out.println("keyTyped");
            }

            /**
             * Metoda opisujaca co ma sie stac z dzialem gdy nacisnie sie przycisk
             * @param keyEvent obiekt zdarzenia zwiazanego z wcisnieciem przycisku
             */
            @Override
            public void keyPressed (KeyEvent keyEvent){
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {
                    setMovementState(typeOfMove.LEFT);
                    moveCannon();
                }
                if (keyCode == KeyEvent.VK_RIGHT) {
                    setMovementState(typeOfMove.RIGHT);
                    moveCannon();
                }
            }

            /**
             * Metoda opisujaca co ma sie stac gdy zwolniony zostanie przycisk
             * @param keyEvent obiekt zdarzenia zwiazanego ze zwolnieniem przycisku
             */


            @Override
            public void keyReleased (KeyEvent keyEvent){
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {

                    setMovementState(typeOfMove.STOPPED);
                    System.out.println("VK_LEFT");
                }
                if (keyCode == KeyEvent.VK_RIGHT) {
                    setMovementState(typeOfMove.STOPPED);
                    System.out.println("VK_RIGHT");
                }
                System.out.println("keyReleased");
            }

    }
