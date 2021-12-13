package gui;

import gameLogic.GameObjectList;
import java.awt.*;
/** Klasa odpowiadajaca za plotno do wyswietlania gry */
public class GameCanvas extends Canvas {

    private final GameObjectList gameObjectList;
    /** Konstruktor klasy GameCanvas */
    public GameCanvas(Color colorBackground, GameObjectList gameObjectList){
        setForeground(colorBackground);
        this.gameObjectList = gameObjectList;
    }
    /** Metoda laczaca z zasobami ekranu */
    public void addNotify(){
        super.addNotify();
            setPreferredSize(new Dimension(500, 300));
        }
    /** Metoda rysujaca po plotnie */
    public void paint(Graphics g){
        Dimension size = getSize();

        for (MyShape shape: gameObjectList) {
            g.setColor(shape.getColor());
            g.fillRect((int) (shape.getX() * size.getWidth()), (int) (shape.getY() * size.getHeight()),
                    (int) (shape.getWidth() * size.getWidth()), (int) (shape.getHeight() * size.getHeight()));
        }
    }
}
