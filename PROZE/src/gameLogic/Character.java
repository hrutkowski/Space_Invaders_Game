package gameLogic;

import java.awt.*;

/** Klasa odpowiadajaca za postacie z życiem */
public class Character extends MovingObject {

    /** Atrybut zyc */
    private int lives;

    /** Konstruktor klasy Character */
    public Character(float x, float y, float width, float height, Color color, int lives) {
        super(x, y, width, height, color);
        this.lives = lives;
    }
    /** Metoda zwracajaca ilosc zyc */
    public int getLives() { return lives; }
    /** Metoda nadajaca ilosc zyc */
    public void setLives(int amount) { lives = amount; }
    /** Metoda odpowiadajaca za trafienie */
    public void hit() { lives -= 1; }
}
