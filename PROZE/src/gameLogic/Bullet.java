package gameLogic;

import java.awt.*;

public class Bullet extends MovingObject{ // Jeszcze nie wiem co będzie go różniło od Character

    /** Konstruktor klasy Bullet */
    public Bullet(float x, float y, float width, float height, Color color){
        super(x, y, width, height, color);
    }

    public void draw(Graphics g, Dimension size){
        g.setColor(getColor());
        g.fillRect((int) (getX() * size.getWidth()), (int) (getY() * size.getHeight()),
                (int) (getWidth() * size.getWidth()), (int) (getHeight() * size.getHeight()));
    }

}
