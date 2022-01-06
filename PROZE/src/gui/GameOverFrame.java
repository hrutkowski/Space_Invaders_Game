package gui;

import configuration.Configer;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameOverFrame extends JFrame {
    /** Konstruktor GameWonFrame */
    public GameOverFrame(Game game, MenuFrame menuFrame, Dimension lastFrameDimension, Point lastFrameLocation) {
        Configer confer = game.getConfiger();
        setTitle(confer.getGameOverText());
        setSize(confer.getFinishedGameFrameWidth(), confer.getFinishedGameFrameHeight());
        setLocation(lastFrameLocation);

        JFrame gameOverFrame = this;

        Panel mainPanel = new Panel(new BorderLayout());
        Panel buttonPanel = new Panel(new FlowLayout());

        Label gameOverLabel = new Label(confer.getGameOverText());

        Button backToMenuButton = new Button(confer.getBackToMenuText());

        mainPanel.add(gameOverLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(backToMenuButton, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);

        backToMenuButton.addActionListener(e -> {
            EventQueue.invokeLater(gameOverFrame::dispose);
            EventQueue.invokeLater(() -> {
                menuFrame.setSize(lastFrameDimension);
                menuFrame.setLocation(lastFrameLocation);
            });
            EventQueue.invokeLater(() -> menuFrame.setVisible(true));
        });

        pack();
    }


}

