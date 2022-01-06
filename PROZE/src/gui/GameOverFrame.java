package gui;

import configuration.Configer;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/** Klasa odpowiadajca za okno przy przegranej */
public class GameOverFrame extends JFrame {

    /** Konstruktor GameWonFrame */
    public GameOverFrame(Game game, MenuFrame menuFrame, Dimension lastFrameDimension, Point lastFrameLocation) {
        Configer confer = game.getConfiger();
        setTitle(confer.getGameOverTitle());
        setSize(confer.getFinishedGameFrameWidth(), confer.getFinishedGameFrameHeight());
        setLocation(new Point((int)lastFrameLocation.getX()*2,(int)lastFrameLocation.getY()*2));

        Panel mainPanel = new Panel(new BorderLayout());
        Panel labelPanel = new Panel(new FlowLayout());
        JPanel gameOverPanel = new JPanel(new GridBagLayout());

        Label gameOverLabel = new Label(confer.getGameOverText(), SwingConstants.CENTER);
        Label playerPoints = new Label(String.valueOf(game.getMenuFrame().getLoginFrame().getPlayer().getPoints()));
        Label finalPoints = new Label(confer.getPlayerFinalPointsText());

        Button backToMenuButton = new Button(confer.getBackToMenuText());

        labelPanel.add(finalPoints);
        labelPanel.add(playerPoints);

        gameOverPanel.add(gameOverLabel);
        gameOverPanel.setBorder(BorderFactory.createEmptyBorder());

        mainPanel.add(gameOverPanel, BorderLayout.NORTH);
        mainPanel.add(labelPanel, BorderLayout.CENTER);
        mainPanel.add(backToMenuButton, BorderLayout.SOUTH);

        add(mainPanel);

        game.getHighScoreManager().addPlayer(game.getMenuFrame().getLoginFrame().getPlayer());
        try {
            game.getHighScoreManager().saveScores();
        } catch (IOException e) {
            e.printStackTrace();
        }

        backToMenuButton.addActionListener(e -> {
            EventQueue.invokeLater(this::dispose);
            EventQueue.invokeLater(menuFrame.getGameFrame()::dispose);
            EventQueue.invokeLater(() -> {
                menuFrame.setSize(lastFrameDimension);
                menuFrame.setLocation(lastFrameLocation);
            });
            EventQueue.invokeLater(() -> menuFrame.setVisible(true));
        });

        JFrame gameOverFrame = this;
        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) {
            EventQueue.invokeLater(() -> gameOverFrame.setVisible(false));
            EventQueue.invokeLater(() -> {
                ExitFrame exitFrame = new ExitFrame(game, gameOverFrame, gameOverFrame.getSize(), gameOverFrame.getLocation());
                exitFrame.setVisible(true);
            });
        }});

        pack();
    }


}

