package gui;

import configuration.Configer;
import configuration.HighScoreManager;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HighScoreFrame extends JFrame {

    public HighScoreFrame(Game game, MenuFrame menuFrame){
        Configer confer = game.getConfiger();
        setPreferredSize(new Dimension(confer.getPreferredScreenWidth(), confer.getPreferredScreenHeight()));
        setTitle(confer.getHighScoreTitle());

        setLayout(new BorderLayout());

        Panel mainPanel = new Panel();

        Button backToMenuButton = new Button(confer.getBackToMenuText());

        HighScoreManager highScoreManager = game.getHighScoreManager();
        JTextArea text = new JTextArea(highScoreManager.showHighScore());
        text.setPreferredSize(new Dimension(confer.getPreferredScreenWidth()-100, confer.getPreferredScreenHeight()-100));
        text.setFont(new Font("Serif", Font.PLAIN, 20));
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setEditable(false);

        mainPanel.add(text, BorderLayout.CENTER);
        mainPanel.add(backToMenuButton, BorderLayout.SOUTH);

        add(mainPanel);

        backToMenuButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> menuFrame.setVisible(true));
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        pack();
    }

}
