package gameLogic;

import java.awt.*;

/** Klasa odpowiadajaca za przeciwnika */
public class Enemy extends Character{

    /** Konstrutor klasy Enemy */
    public Enemy( float x, float y, float width, float height, Color color, int lives) {
        super(x, y , width, height, color, lives);
    }
}