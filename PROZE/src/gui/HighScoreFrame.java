package gui;

import configuration.Configer;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** Klasa odpowiadajca za okno z rankingiem */
public class HighScoreFrame extends JFrame {

    /** Konstruktor klasy HighScoreFrame */
    HighScoreFrame(Game game, MenuFrame menuFrame){
        Configer confer = game.getConfiger();
        setTitle(confer.getHighScoreTitle());

        setLayout(new BorderLayout());

        Panel mainPanel = new Panel(new BorderLayout());

        Button backToMenuButton = new Button(confer.getBackToMenuText());

        JTextArea ranking = new JTextArea(game.getHighScoreManager().showHighScore());
        ranking.setPreferredSize(new Dimension(confer.getPreferredScreenWidth()-100, confer.getPreferredScreenHeight()-100));
        ranking.setFont(new Font("Serif", Font.PLAIN, 20));
        ranking.setLineWrap(true);
        ranking.setWrapStyleWord(true);
        ranking.setEditable(false);

        mainPanel.add(ranking, BorderLayout.CENTER);
        mainPanel.add(backToMenuButton, BorderLayout.SOUTH);

        add(mainPanel);

        backToMenuButton.addActionListener(e -> {
            EventQueue.invokeLater(this::dispose);
            EventQueue.invokeLater(() -> {
                menuFrame.setSize(this.getSize());
                menuFrame.setLocation(this.getLocation()); });
            EventQueue.invokeLater(() -> menuFrame.setVisible(true) );
        });

        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) {
            EventQueue.invokeLater(() -> game.getMenuFrame().getHighScoreFrame().setVisible(false));
            EventQueue.invokeLater(() -> {
                ExitFrame exitFrame = new ExitFrame(game, game.getMenuFrame().getHighScoreFrame(), game.getMenuFrame().getHighScoreFrame().getSize(), game.getMenuFrame().getHighScoreFrame().getLocation());
                exitFrame.setVisible(true);
            });
        }});
        pack();
    }
}
