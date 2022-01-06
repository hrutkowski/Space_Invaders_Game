package gui;

import configuration.Configer;
import gameLogic.Player;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** Klasa ona logowania */
public class LoginFrame extends JFrame {

    /** Konstruktor klasy LoginFrame */
    LoginFrame(Game game, MenuFrame menuFrame) {
        Configer confer = game.getConfiger();
        GameFrame gameFrame = game.getGameFrame();
        Player player = game.getGameFrame().getPlayer();
        setTitle(confer.getLoginTitle());

        Panel mainPanel = new Panel(new BorderLayout());
        Panel loginPanel = new Panel();

        Button backToMenuButton = new Button(confer.getBackToMenuText());
        Button loginButton = new Button(confer.getButtonLogin());

        Label loginLabel = new Label(confer.getLabelLogin());

        TextField nickField = new TextField("",15);

        loginPanel.add(loginLabel, BorderLayout.NORTH);
        loginPanel.add(nickField, BorderLayout.CENTER);
        loginPanel.add(loginButton, BorderLayout.SOUTH);

        mainPanel.add(loginPanel,BorderLayout.CENTER);
        mainPanel.add(backToMenuButton, BorderLayout.SOUTH);

        add(mainPanel);

        loginButton.addActionListener(e -> {
            if (nickField.getText().isEmpty()) {
                nickField.setText(confer.getDefaultNick());
            }
            else {
                EventQueue.invokeLater(() -> player.setNick(nickField.getText()));
                EventQueue.invokeLater(() -> this.setVisible(false));
                EventQueue.invokeLater(() -> {
                    gameFrame.setSize(this.getSize());
                    gameFrame.setLocation(this.getLocation());
                });
                EventQueue.invokeLater(() -> gameFrame.setVisible(true) );
            }
        });
        backToMenuButton.addActionListener(e -> {
            EventQueue.invokeLater(this::dispose);
            EventQueue.invokeLater(() -> {
                menuFrame.setSize(this.getSize());
                menuFrame.setLocation(this.getLocation()); });
            EventQueue.invokeLater(() -> menuFrame.setVisible(true) );
        });
        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) {
            EventQueue.invokeLater(() -> game.getMenuFrame().getLoginFrame().setVisible(false));
            EventQueue.invokeLater(() -> {
                ExitFrame exitFrame = new ExitFrame(game,game.getMenuFrame().getLoginFrame(), game.getMenuFrame().getLoginFrame().getSize(), game.getMenuFrame().getLoginFrame().getLocation());
                exitFrame.setVisible(true);
            });
        }});
    }
}