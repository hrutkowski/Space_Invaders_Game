package gui;

import java.awt.*;

public class Board {
    public static final int fieldX = 20; // do wymyślenia
    public static final int fieldY = 20;
    public static final int size = 30;
    public static final int maxX = fieldX*size;
    public static final int maxY = fieldY*size;


    public static void draw(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(0,0,maxX,maxY);
    }
}
