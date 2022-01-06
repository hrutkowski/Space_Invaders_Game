package gui;

import configuration.Configer;
import gameLogic.Player;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/** Klasa odpowiadajca za okno przy wygranej */
public class GameWonFrame extends JFrame {

    /** Konstruktor GameWonFrame */
    public GameWonFrame(Game game, MenuFrame menuFrame, Dimension lastFrameDimension, Point lastFrameLocation) {
        Configer confer = game.getConfiger();
        setTitle(confer.getGameWonTitle());
        setSize(confer.getFinishedGameFrameWidth(), confer.getFinishedGameFrameHeight());
        setLocation(new Point((int)lastFrameLocation.getX()*2,(int)lastFrameLocation.getY()*2));

        Panel mainPanel = new Panel(new BorderLayout());
        Panel labelPanel = new Panel(new FlowLayout());
        JPanel congratulationPanel = new JPanel(new GridBagLayout());

        Label congratulationLabel = new Label(confer.getCongratulationsText());
        Label playerPoints = new Label(String.valueOf(game.getMenuFrame().getLoginFrame().getPlayer().getPoints()));
        Label finalPoints = new Label(confer.getPlayerFinalPointsText());

        Button backToMenuButton = new Button(confer.getBackToMenuText());

        labelPanel.add(finalPoints);
        labelPanel.add(playerPoints);

        congratulationPanel.add(congratulationLabel);
        congratulationPanel.setBorder(BorderFactory.createEmptyBorder());

        mainPanel.add(congratulationPanel, BorderLayout.NORTH);
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

        JFrame gameWonFrame = this;
        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) {
            EventQueue.invokeLater(() -> gameWonFrame.setVisible(false));
            EventQueue.invokeLater(() -> {
                ExitFrame exitFrame = new ExitFrame(game, gameWonFrame, gameWonFrame.getSize(), gameWonFrame.getLocation());
                exitFrame.setVisible(true);
            });
        }});

        pack();
    }


}

