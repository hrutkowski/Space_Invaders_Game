package gameLogic;

import configuration.Configer;


public class Character extends MovingObject {

    /** Zmienna okreslajaca  szerokosc objektu
     */
    public int width;
    /**
     * Zmienna okreslajaca wysokosc paletki
     */
    public int height;

    /**
     * Zmienna okreslajaca szerokosc planszy do gry
     */
    public int screenWidth;
    /**
     * Zmienna okreslajaca wysokosc planszy do gry
     */
    public int screenHeight;

    /**
     * Znormalizowana pozycja Y obiektu
     */

    public double normalizedYPosition;

    /**
     * Znormalizowana pozycja X obiektu
     */

    public double normalizedXPosition;

    /**
     * Znormalizowana szerokosc obiektu
     */

    public double normalizedWidth;

    /**
     * Znormalizowana wysokosc obiektu
     */

    public double normalizedHeight;

    /**
     * Zmienna okreslajaca ramke ekranu
     */
    public float screenStroke;

    /** Metoda zwracajaca poczatkowa pozycje */
    public void setStartPosition() {
    }

    /**
     * Funkcja do ruszania sie
     */
    public void move(){

    }

    /**
     * Funkcja do strzelania
     */
    public void fire() {

    }

    /**
     * Funkcja do rysowania obiektow
     */
    public void paint() {
    }
    /**
     * Zmienna okreslajaca ilosc zyc
     */
    private int numberOfLifes;


    /**
     * Konstrutor klasy Character
     */
    public Character(){ // To raczej bez sensu, bo po co tej klasie te informacje?

        screenWidth=Configer.getGameHeight();
        screenHeight=Configer.getGameWidth();
        screenStroke=Configer.getStroke();
        normalizedWidth= Configer.getObjectWidthRatio();
        normalizedHeight=Configer.getObjectHeightRatio();
    }

}


