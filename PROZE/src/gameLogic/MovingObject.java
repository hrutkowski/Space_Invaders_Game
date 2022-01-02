package gameLogic;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/** Klasa odpowiadajaca obiektami ruchomymi w grze */
public class MovingObject {

    /** Atrybuty polozenia */
    private float x, y;
    /** Atrybuty wymiarow*/
    private final float width, height;
    /** Atrybut koloru*/
    private Color color;
    /** Atrybut zycia obiektu */
    private boolean killed;

    /** Konstruktor klasy MovingObject */
    public MovingObject(float x, float y, float width, float height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    /** Metoda zwracajaca pozycje x */
    public float getX() { return x; }
    /** Metoda zwracajaca pozycje y */
    public float getY() { return y; }
    /** Metoda zwracajaca szerokosc */
    public float getWidth() { return width; }
    /** Metoda zwracajaca wysokosc */
    public float getHeight() { return height; }
    /** Metoda zwracajaca kolor */
    public Color getColor() { return color; }
    /** Metoda ustawiajaca kolor */
    public void setColor(Color color) { this.color = color; }
    /** Metoda ustawiajaca pozycje x */
    public void setX(float x) { this.x = x;}
    /** Metoda ustawiajaca pozycje y */
    public void setY(float y) { this.y = y;}
    /** Metoda zwracajaca object typu Reactangle pomocny w sprawdzaniu kolizji */
    public Rectangle2D.Float getBounds(){ return new Rectangle2D.Float(this.x,this.y,this.width,this.height); }
    /** Metoda sprawdzajaca czy Enemy żyje */
    public boolean isKilled(){ return killed; }
    /** Metoda uśmiercająca Enemy */
    public void kill(){ killed=true; }
}
