package gameLogic;

import configuration.Configer;
import configuration.Leveler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;


public class Cannon extends Character implements KeyListener {

    /**
     * Zmienna okreslajaca stan w ktorym znajduje sie dzialo gracza - ruch w prawo i w lewo
     */
    private typeOfMove cannonState;

    private Rectangle cannonRect;
    /**
     * Konstrutor klasy Cannon
     */
    public Cannon() {
        //FPS = Configer.getFps();
        cannonState=typeOfMove.STOPPED;
        cannonRect=new Rectangle(xPosition,yPosition,width,height);
    }


    private enum typeOfMove {
        LEFT,
        RIGHT,
        STOPPED
    }

    /**
     * Metoda ustawiajaca stan dziala gracza
     * @param state stan w zaleznosci od tego jaki przycisk zostal wcisniety
     */
    private void setMovementState(typeOfMove state){
        cannonState=state;
    }

    /**
     * Metoda do pobrania szybkosci ruchu dziala gracza
     * @return szybkosc poruszania sie dziala gracza
     */
    private double getPlayerMovingSpeed(){
        return Configer.getPlayerMovementSpeed();
    }

    /**
     * Metoda do poruszania dzialem gracza
     */
    public void moveCannon() {
        if (cannonState == typeOfMove.LEFT) {
            System.out.println("LEWO");
            if (normalizedXPosition*screenWidth > screenStroke)
                normalizedXPosition -= speed / FPS;
            else
                normalizedXPosition = 1.0*screenStroke/screenWidth;

        }

        if (cannonState == typeOfMove.RIGHT) {
            System.out.println("PRAWO");
            if ((normalizedXPosition + normalizedWidth)*screenWidth < screenWidth - screenStroke)
                normalizedXPosition += speed / FPS;
            else
                normalizedXPosition = 1.0*(screenWidth - screenStroke)/screenWidth - normalizedWidth;

        }
    }

    /**
     * Metoda ustawia dzialo gracza w srodkowej pozycji
     */
    public void setStartPosition(){

        normalizedXPosition=1.0*Configer.getObjectXScreenRatio()-0.5*normalizedWidth;
        normalizedYPosition=1-Configer.getObjectYScreenRatio()+normalizedHeight;
        cannonRect.setSize((int)Math.round(normalizedWidth*screenWidth),(int)Math.round(normalizedHeight*screenHeight));
        cannonRect.setLocation((int)Math.round(normalizedXPosition*screenWidth),(int)Math.round(normalizedYPosition*screenHeight));
        System.out.println("Position: " + normalizedXPosition + "," + normalizedYPosition);
    }

    /**
     * Metoda zwracajaca prostokat opisujacy dzialo
     * @return prostokat opisujacy rozmiar i polozenie dziala gracza
     */
    public Rectangle getCannonRect(){
        System.out.println("cannonRectangle");
        return cannonRect;
    }

    /**
     * Metoda zmieniajaca rozmiary dziala i jego polozenie gdy okno gry zmienia rozmiar
     * @param screenWidth szerokosc ekrany
     * @param screenHeight wysokosc ekranu
     */
    public void resize(int screenWidth, int screenHeight) {
        this.screenWidth=screenWidth;
        this.screenHeight=screenHeight;
        cannonRect.setLocation((int)Math.round(normalizedXPosition*screenWidth),(int)Math.round(normalizedYPosition*screenHeight));
        cannonRect.setSize((int)Math.round(normalizedWidth*screenWidth),(int)Math.round(normalizedHeight*screenHeight));
        System.out.println("Resized");
    }

    /**
     * Aktualizacja polozeenia dziala
     */

    public  void update(){
        cannonRect.setLocation((int)Math.round(normalizedXPosition*screenWidth),(int)Math.round(normalizedYPosition*screenHeight));
        cannonRect.setSize((int)Math.round(normalizedWidth*screenWidth),(int)Math.round(normalizedHeight*screenHeight));
        System.out.println("Updated");
    }


    /**
     * Metoda opisujaca co ma sie stac z dzialem gdy nacisnie sie przycisk
     * @param keyEvent obiekt zdarzenia zwiazanego z nacisnieciem przycisku
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        System.out.println("keyTyped");
    }

    /**
     * Metoda opisujaca co ma sie stac z dzialem gdy nacisnie sie przycisk
     * @param keyEvent obiekt zdarzenia zwiazanego z wcisnieciem przycisku
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if(keyCode==keyEvent.VK_LEFT)
        {
            setMovementState(typeOfMove.LEFT);
            moveCannon();
            System.out.println("VK_LEFT");
        }
        if(keyCode==keyEvent.VK_RIGHT)
        {
            setMovementState(typeOfMove.RIGHT);
            moveCannon();
            System.out.println("VK_RIGHT");
        }
        System.out.println("Key Pressed");
    }

    /**
     * Metoda opisujaca co ma sie stac gdy zwolniony zostanie przycisk
     * @param keyEvent obiekt zdarzenia zwiazanego ze zwolnieniem przycisku
     */


    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if(keyCode==keyEvent.VK_LEFT)
        {

            setMovementState(typeOfMove.STOPPED);
            System.out.println("VK_LEFT");
        }
        if(keyCode==keyEvent.VK_RIGHT)
        {
            setMovementState(typeOfMove.STOPPED);
            System.out.println("VK_RIGHT");
        }
        System.out.println("keyReleased");
    }

    public static void main(String[] args) throws IOException {
        Configer conf = new Configer("./PROZE/src/conf.txt");
        Cannon can = new Cannon();
        can.setMovementState(typeOfMove.LEFT);
        can.moveCannon();
        can.setMovementState(typeOfMove.RIGHT);
        can.moveCannon();
        can.getCannonRect();
        can.setStartPosition();
        can.resize(can.screenWidth, can.screenHeight);
        can.update();
        /*can.keyTyped();*/
        /*can.keyPressed(KeyEvent.VK_LEFT);*/
        /*can.keyReleased(KeyEvent.VK_LEFT);*/
    }

}
