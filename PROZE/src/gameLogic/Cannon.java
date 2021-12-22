package gameLogic;

import helpfulTools.ColorTranslator;

import java.awt.*;

/** Klasa odpwiadajaca za dzialo */
public class Cannon extends Character {

    /** Konstrutor klasy Cannon */
    public Cannon(float x, float y, float width, float height, Color color, int lives) {
        super(x, y, width, height, color, lives);
    }
    /** Metoda nadajaca kolor dla Cannon */
    public void setColor(String col) {
        ColorTranslator colorTranslator = new ColorTranslator();
        super.setColor(colorTranslator.translateColor(col));
    }
    /** Metoda rusyjaca dzialo */
    public void draw(Graphics g, Dimension size) {
        g.setColor(getColor());
        g.fillRect((int) (getX() * size.getWidth()), (int) (getY() * size.getHeight()),
                   (int) (getWidth() * size.getWidth()), (int) (getHeight() * size.getHeight()));
    }
}
