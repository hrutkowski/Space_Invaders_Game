package gui;

import configuration.Configer;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** Klasa okna menu */
public class MenuFrame extends JFrame {

    /** Atrybut klasy HighScoreFrame */
    private final HighScoreFrame highScoreFrame;
    /** Atrybut klasy InfoFrame */
    private final InfoFrame infoFrame;
    /** Atrybut klasy SettingFrame */
    private final SettingsFrame settingsFrame;

    /** Konstruktor klasy MenuFrame */
    public MenuFrame(Game game) {
        Configer confer = game.getConfiger();
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
            EventQueue.invokeLater(() -> {
                gameFrame.setVisible(true);
                gameFrame.setSize(this.getSize());});
        });
        infoButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> {
                infoFrame.setVisible(true);
                infoFrame.setSize(this.getSize());});
        });
        highScoreButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> {
                highScoreFrame.setVisible(true);
                highScoreFrame.setSize(this.getSize());});
        });
        settingsButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> {
                settingsFrame.setVisible(true);
                settingsFrame.setSize(this.getSize());});
        });
        exitButton.addActionListener(e -> System.exit(1));

        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) { System.exit(0); } });

        pack();
    }
}

