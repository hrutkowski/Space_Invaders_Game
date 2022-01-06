package gui;

import configuration.Configer;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameOverFrame extends JFrame {
    /** Konstruktor GameWonFrame */
    public GameOverFrame(Game game, MenuFrame menuFrame, Dimension lastFrameDimension, Point lastFrameLocation) {
        Configer confer = game.getConfiger();
        setTitle(confer.getGameOverTitle());
        setSize(confer.getFinishedGameFrameWidth(), confer.getFinishedGameFrameHeight());
        setLocation(lastFrameLocation);

        Panel mainPanel = new Panel(new BorderLayout());
        Panel labelPanel = new Panel(new FlowLayout());

        Label gameOverLabel = new Label(confer.getGameOverText());
        Label playerPoints = new Label(String.valueOf(game.getGameFrame().getPlayer().getPoints()));
        Label finalPoints = new Label(confer.getPlayerFinalPointsText());

        Button backToMenuButton = new Button(confer.getBackToMenuText());

        labelPanel.add(finalPoints);
        labelPanel.add(playerPoints);

        mainPanel.add(gameOverLabel, BorderLayout.NORTH);
        mainPanel.add(labelPanel, BorderLayout.CENTER);
        mainPanel.add(backToMenuButton, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);

        game.getHighScoreManager().addPlayer(game.getGameFrame().getPlayer());
        try {
            game.getHighScoreManager().saveScores();
        } catch (IOException e) {
            e.printStackTrace();
        }

        backToMenuButton.addActionListener(e -> {
            EventQueue.invokeLater(this::dispose);
            EventQueue.invokeLater(() -> {
                menuFrame.setSize(lastFrameDimension);
                menuFrame.setLocation(lastFrameLocation);
            });
            EventQueue.invokeLater(() -> menuFrame.setVisible(true));
        });

        pack();
    }


}

