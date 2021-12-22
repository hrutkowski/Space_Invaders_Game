package gameLogic;

import java.awt.*;

/** Klasa odpowiadajaca obiektami ruchomymi w grze */
public class MovingObject {

    /** Atrybuty polozenia dziala */
    private float x, y;
    /** Atrybuty wymiarow dziala */
    private final float width, height;
    /** Atrybut koloru dziala */
    private Color color;

    /** Konstruktor klasy MovingObject */
    public MovingObject(float x, float y, float width, float height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    /** Metoda zwracajaca pozycje x dziala */
    public float getX() { return x; }
    /** Metoda zwracajaca pozycje y dziala */
    public float getY() { return y; }
    /** Metoda zwracajaca szerokosc dziala */
    public float getWidth() { return width; }
    /** Metoda zwracajaca wysokosc dziala */
    public float getHeight() { return height; }
    /** Metoda zwracajaca kolor obiektu */
    public Color getColor() { return color; }
    /** Metoda ustawiajaca kolor dziala */
    public void setColor(Color color) { this.color = color; }
    /** Metoda ustawiajaca pozycje x dziala */
    public void setX(float x) { this.x = x;}
    /** Metoda ustawiajaca pozycje y dziala */
    public void setY(float y) { this.y = y;}
}
