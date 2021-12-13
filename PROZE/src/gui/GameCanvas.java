package gui;

import java.awt.*;

public class GameCanvas extends Canvas {

    public GameCanvas(Color colorBackground){
        setForeground(colorBackground);
    }

    public Dimension getPreferredSize(){
        return new Dimension(500,300);
    }

    public void addNotify(){
        super.addNotify();
    }

    public void paint(Graphics g){
        Dimension size = getSize();

        g.fillRect(0,0, size.width, size.height);

        g.setColor(Color.green);
        g.fillRect(250,200,50,50);
        g.setColor(Color.black);
        g.drawRect(250,200,50,50);
    }
}
