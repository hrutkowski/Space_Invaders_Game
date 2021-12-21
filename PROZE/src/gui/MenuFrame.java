package gui;

import configuration.Configer;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuFrame extends JFrame {
    private final HighScoreFrame highScoreFrame;
    private final InfoFrame infoFrame;
    private final SettingsFrame settingsFrame;

    public MenuFrame(Game game) {
        Configer confer = game.getConfiger();
        MenuFrame menuFrame = game.getMenuFrame();
        GameFrame gameFrame = game.getGameFrame();
        setTitle(confer.getMenuTitle());
        setPreferredSize(new Dimension(confer.getPreferredScreenWidth(), confer.getPreferredScreenHeight()));
        this.highScoreFrame = new HighScoreFrame(game, this);
        this.infoFrame = new InfoFrame(game, this);
        this.settingsFrame = new SettingsFrame(game, this);

        setLayout(new BorderLayout());

        Button startButton = new Button(confer.getButtonStartText());
        Button exitButton = new Button(confer.getButtonEndText());
        Button settingsButton = new Button(confer.getButtonSettingsText());
        Button highScoreButton = new Button(confer.getButtonRankText());
        Button infoButton = new Button(confer.getButtonInfoText());

        Panel mainPanel = new Panel();

        BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);

        mainPanel.setLayout(boxLayout);

        mainPanel.add(startButton);
        mainPanel.add(settingsButton);
        mainPanel.add(highScoreButton);
        mainPanel.add(infoButton);
        mainPanel.add(exitButton);

        add(mainPanel);

        startButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> gameFrame.setVisible(true));
        });
        infoButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> infoFrame.setVisible(true));
        });
        highScoreButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> highScoreFrame.setVisible(true));
        });
        settingsButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> settingsFrame.setVisible(true));
        });
        exitButton.addActionListener(e -> System.exit(1));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        pack();
    }
}

