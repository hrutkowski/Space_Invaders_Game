package gameLogic;

import gui.GameFrame;
import gui.GameCanvas;

import java.awt.*;


/** Klasa odpowiadajaca za animacje */
public class Animation implements Runnable {

    final private GameFrame gameFrame;


    /**
     * Zmienna okreslajaca stan w ktorym znajduje sie dzialo gracza - ruch w prawo i w lewo
     */

    private Thread kicker;

    /**
     * Konstruktor klasy Animation
     */
    public Animation(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        this.gameFrame.setFocusable(true);
        this.gameFrame.setFocusTraversalKeysEnabled(false);
    }



    /**
     * Metoda ustawiajaca watek
     */
    public void setKicker(Thread kicker) {
        this.kicker = kicker;
    }


    /**
     * Metoda odpowiadajaca za wykonywanie sie animacji
     */
    @Override
    public void run() {

        GameObjectList gameObjectList = gameFrame.getGameObjectList();
        float dX = 0.015f;
        float dY = 0.015f;
        while (kicker == Thread.currentThread()) {
            try {Thread.sleep(50);}
            catch (InterruptedException ignore) {}
            //for (Enemy shape : gameObjectList) {      // Petla po wszystkich obiektach gameObjectList
                //float newX = shape.getX() + 0.015f;
                //if (Float.compare(newX + shape.getWidth(), 1f) >= 0) {
                    //shape.setX(newX - 1);
                //} else {
                   // shape.setX(newX);
               // }
                // !!!!!!!!!!!!! NIE USUWAĆ TEGO POWYŻEJ !!!!!!!!!!!!!!!!!!!!
            float wartoscXprzeciwnikaPoPrawejStronie = 0;
            float wartoscXprzeciwnikaPoLewejStronie = 1;
            float szerokoscPrzeciwnikaPoPrawej = 0;
            float pomocniczyY = 0;
            for (Enemy shape : gameObjectList) {
                if(shape.getX() > wartoscXprzeciwnikaPoPrawejStronie) {wartoscXprzeciwnikaPoPrawejStronie = shape.getX();
                    szerokoscPrzeciwnikaPoPrawej = shape.getWidth();}
                if(shape.getX() < wartoscXprzeciwnikaPoLewejStronie) {wartoscXprzeciwnikaPoLewejStronie = shape.getX();}
                }
            if ((wartoscXprzeciwnikaPoPrawejStronie + dX) >= (1f - szerokoscPrzeciwnikaPoPrawej) || wartoscXprzeciwnikaPoLewejStronie + dX <= 0f)
            {dX = -dX;
            pomocniczyY = dY;
            }
            for (Enemy shape : gameObjectList) {
                shape.setX(shape.getX() + dX);
                shape.setY(shape.getY() + pomocniczyY);}

            gameFrame.getGameCanvas().repaint();
        }


    }


}
