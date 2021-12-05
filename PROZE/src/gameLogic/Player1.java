package gameLogic;

import configuration.Configer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Player1 extends Character implements KeyListener {

    /**
     * Zmienna okreslajaca stan w ktorym znajduje sie dzialo gracza - ruch w prawo i w lewo
     */
    private typeOfMove playerState;

    private Rectangle playerRect;


    /**
     * Konstrutor klasy Player1
     *
     * @param speed szybkosc poruszania sie gracza
     */
    public Player1(int speed) {
        super(speed);
        speed = Configer.getPlayerMovingSpeed();
        playerState=typeOfMove.STOPPED;
        playerRect=new Rectangle(xPosition,yPosition,width,height);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyTyped");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private enum typeOfMove {
        LEFT,
        RIGHT,
        STOPPED
    }

    /**
     * Metoda ustawia dzialo gracza w srodkowej pozycji
     */
    public void setStartPosition(){

        normalizedXPosition=1.0*Configer.getObjectXScreenRatio()-0.5*normalizedWidth;
        normalizedYPosition=1-1.0*Configer.getObjectYScreenRatio()*normalizedHeight;
        normalizedYPosition=1-Configer.getObjectYScreenRatio()+normalizedHeight;
        playerRect.setSize((int)Math.round(normalizedWidth*screenWidth),(int)Math.round(normalizedHeight*screenHeight));
        playerRect.setLocation((int)Math.round(normalizedXPosition*screenWidth),(int)Math.round(normalizedYPosition*screenHeight));

    }
}
