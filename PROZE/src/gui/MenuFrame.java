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
    private HighScoreFrame highScoreFrame;
    /** Atrybut klasy InfoFrame */
    private InfoFrame infoFrame;
    /** Atrybut klasy SettingFrame */
    private SettingsFrame settingsFrame;
    /** Atrybut klasy LoginFrame */
    private  LoginFrame loginFrame;

    /** Metoda zwracajaca obiekt klasy InfoFrame */
    public InfoFrame getInfoFrame() { return infoFrame; }
    /** Metoda zwracajaca obiekt klasy SettingsFrame */
    public SettingsFrame getSettingsFrame() { return settingsFrame; }
    /** Metoda zwracajaca obiekt klasy HighScoreFrame */
    public HighScoreFrame getHighScoreFrame() { return highScoreFrame; }
    /** Metoda zwracajaca obiekt klasy LoginFrame */
    public LoginFrame getLoginFrame() { return loginFrame; }

    /** Konstruktor klasy MenuFrame */
    public MenuFrame(Game game) {
        Configer confer = game.getConfiger();
        setTitle(confer.getMenuTitle());

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
                this.loginFrame = new LoginFrame(game, this);
                loginFrame.setSize(this.getSize());
                loginFrame.setLocation(this.getLocation());
            });
            EventQueue.invokeLater(() -> loginFrame.setVisible(true));
        });
        infoButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> {
                this.infoFrame = new InfoFrame(game, this);
                infoFrame.setSize(this.getSize());
                infoFrame.setLocation(this.getLocation());
            });
            EventQueue.invokeLater(() -> infoFrame.setVisible(true));
        });
        highScoreButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> {
                this.highScoreFrame = new HighScoreFrame(game, this);
                highScoreFrame.setSize(this.getSize());
                highScoreFrame.setLocation(this.getLocation());
            });
            EventQueue.invokeLater(() -> highScoreFrame.setVisible(true));
        });
        settingsButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> {
                this.settingsFrame = new SettingsFrame(game, this);
                settingsFrame.setSize(this.getSize());
                settingsFrame.setLocation(this.getLocation()); });
            EventQueue.invokeLater(() -> settingsFrame.setVisible(true));
        });
        exitButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> {
                ExitFrame exitFrame = new ExitFrame(game,this, this.getSize(), this.getLocation());
                exitFrame.setVisible(true);
            });
        });

        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) {
            EventQueue.invokeLater(() -> game.getMenuFrame().setVisible(false));
            EventQueue.invokeLater(() -> {
                ExitFrame exitFrame = new ExitFrame(game, game.getMenuFrame(), game.getMenuFrame().getSize(), game.getMenuFrame().getLocation());
                exitFrame.setVisible(true);
            });
        }});
        pack();
    }
}

