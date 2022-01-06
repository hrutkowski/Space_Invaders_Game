package gui;

import configuration.Configer;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWonFrame extends JFrame {
    /** Konstruktor GameWonFrame */
    public GameWonFrame(Game game, MenuFrame menuFrame, Dimension lastFrameDimension, Point lastFrameLocation) {
        Configer confer = game.getConfiger();
        setTitle(confer.getGameWonText());
        setSize(confer.getFinishedGameFrameWidth(), confer.getFinishedGameFrameHeight());
        setLocation(lastFrameLocation);

        JFrame gameWonFrame = this;

        Panel mainPanel = new Panel(new BorderLayout());
        Panel buttonPanel = new Panel(new FlowLayout());

        Label gameWonLabel = new Label(confer.getGameWonText());

        Button backToMenuButton = new Button(confer.getBackToMenuText());

        mainPanel.add(gameWonLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(backToMenuButton, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);

        backToMenuButton.addActionListener(e -> {
            EventQueue.invokeLater(gameWonFrame::dispose);
            EventQueue.invokeLater(() -> {
                menuFrame.setSize(lastFrameDimension);
                menuFrame.setLocation(lastFrameLocation);
            });
            EventQueue.invokeLater(() -> menuFrame.setVisible(true));
        });

        pack();
    }


}

