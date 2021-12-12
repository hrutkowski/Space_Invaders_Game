package gameLogic;


import configuration.Configer;

/**
 * Klasa opisujaca MovingObject i jego zachowanie
 */


public class MovingObject {
    /**
            * Zmienna okreslajaca polozenie w X
     */
    public int xPosition;
    /**
     * Zmienna okreslajaca polozenie w Y
     */
    public int yPosition;

    /**
     * Znormalizowana pozycja Y
     */

    private double normalizedYPosition;

    /**
     * Znormalizowana pozycja X
     */

    private double normalizedXPosition;
    /**
     * Zmienna okreslajaca liczbe klatek w grze
     */
    public int FPS;
    /**
     * Zmienna okreslajaca szybkosc poruszania sie obiektu
     */
    public static int speed;

    /**
     * Funkcja do rysowania obiektow
     */
    public void paint() {
    }


    /**
     * Konstrutor klasy MovingObject
     */

    public MovingObject() {
        FPS = Configer.getFps();
    }
}
