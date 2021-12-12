package gui;

import javax.swing.*;
import java.awt.*;
import gameLogic.Cannon;


public class MainPanel extends JPanel {

    private Cannon cannon = new Cannon();

    public MainPanel() {
        setPreferredSize(new Dimension(Board.maxX, Board.maxY));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Board.draw(g);
        //cannon.draw(g);
    }



}
