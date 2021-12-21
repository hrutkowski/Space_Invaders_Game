package gameLogic;

import helpfulTools.ColorTranslator;
import helpfulTools.PROZEUtil;

import java.awt.*;

public class Cannon extends Character {

    //private Color color;

    /** Konstrutor klasy Cannon */
    public Cannon(float x, float y, float width, float height, Color color, int lives) {
        super(x, y, width, height, color, lives);
    }
    /** Metoda nadajaca kolor dla Cannon */
    public void setColor(String col) {
        ColorTranslator colorTranslator = new ColorTranslator();
        super.setColor(colorTranslator.translateColor(col));
    }

    public void draw(Graphics g, Dimension size) {
        g.setColor(getColor());
        g.fillRect((int) (getX() * size.getWidth()), (int) (getY() * size.getHeight()),
                (int) (getWidth() * size.getWidth()), (int) (getHeight() * size.getHeight()));
    }
}
