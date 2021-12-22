package gameLogic;

import java.awt.*;

/** Klasa odpowiadajaca za postacie z życiem */
public class Character extends MovingObject {
    /** Konstruktor klasy Character */

    public Character(float x, float y, float width, float height, Color color, int lives) {
        super(x, y, width, height, color);
    }
}
