package gameLogic;

import gui.GameFrame;
import gui.GameCanvas;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/** Klasa odpowiadajaca za animacje */
public class Animation implements Runnable, KeyListener {

    final private GameFrame gameFrame;


    /**
     * Zmienna okreslajaca stan w ktorym znajduje sie dzialo gracza - ruch w prawo i w lewo
     */
    private Animation.typeOfMove cannonState;
    private Thread kicker;

    /**
     * Konstruktor klasy Animation
     */
    public Animation(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        cannonState = Animation.typeOfMove.STOPPED;
    }

    /**
     * Metoda ustawiajaca stan dziala gracza
     *
     * @param state stan w zaleznosci od tego jaki przycisk zostal wcisniety
     */
    private void setMovementState(Animation.typeOfMove state) {
        cannonState = state;
    }

    /**
     * Metoda ustawiajaca watek
     */
    public void setKicker(Thread kicker) {
        this.kicker = kicker;
    }

    private enum typeOfMove {
        LEFT,
        RIGHT,
        STOPPED
    }


    public void moveCannon() {
        Cannon cannon = gameFrame.getCannon();
        float newMove = cannon.getX();
        if (cannonState == Animation.typeOfMove.LEFT) {
            if (Float.compare(cannon.getX() + cannon.getWidth(), 1f) >= 0) {
                cannon.setX(newMove - 0.01f);
            } else cannon.setX(newMove);
            if (cannonState == Animation.typeOfMove.RIGHT) {
                if (Float.compare(cannon.getX(), 0f) <= 0) {
                    cannon.setX(newMove + 0.01f);
                } else cannon.setX(newMove);
            }
        }
    }
    /**
     * Metoda odpowiadajaca za wykonywanie sie animacji
     */
    @Override
    public void run() {
        GameObjectList gameObjectList = gameFrame.getGameObjectList();
        float dX = 0.015f;
        while (kicker == Thread.currentThread()) {
            try {
                Thread.sleep(50);
                gameFrame.getGameCanvas().repaint();}
            catch (InterruptedException ignore) {
            }
            moveCannon();
            //for (Enemy shape : gameObjectList) {      // Petla po wszystkich obiektach gameObjectList
                //float newX = shape.getX() + 0.015f;
                //if (Float.compare(newX + shape.getWidth(), 1f) >= 0) {
                    //shape.setX(newX - 1);
                //} else {
                   // shape.setX(newX);
               // }
                // !!!!!!!!!!!!! NIE USUWAĆ TEGO POWYŻEJ !!!!!!!!!!!!!!!!!!!!
                for (Enemy shape : gameObjectList) {
                    if ((shape.getX() + dX) >= (1f - shape.getWidth()) || shape.getX() + dX <= 0f) {
                        dX = -dX;
                    }
                    shape.setX(shape.getX() + dX);
                //float newY = shape.getY() + 0.02f * ThreadLocalRandom.current().nextFloat();
                //shape.setY(Float.compare(shape.getY() + shape.getHeight(), 1f) >= 0 ? 0f : newY);
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
            setMovementState(Animation.typeOfMove.LEFT);
            moveCannon();
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            setMovementState(Animation.typeOfMove.RIGHT);
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

            setMovementState(Animation.typeOfMove.STOPPED);
            System.out.println("VK_LEFT");
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            setMovementState(Animation.typeOfMove.STOPPED);
            System.out.println("VK_RIGHT");
        }
        System.out.println("keyReleased");
    }
}
