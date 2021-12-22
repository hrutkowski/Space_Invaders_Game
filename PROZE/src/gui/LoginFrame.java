package gui;

import configuration.Configer;
import gameLogic.Player;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class LoginFrame extends JFrame {

    public LoginFrame(Game game, MenuFrame menuFrame) {
        Configer confer = game.getConfiger();
        GameFrame gameFrame = game.getGameFrame();
        Player player = game.getPlayer();
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
                nickField.setText("name");
            }
            else {
                EventQueue.invokeLater(() -> player.setNick(nickField.getText()));
                EventQueue.invokeLater(() -> this.setVisible(false));
                EventQueue.invokeLater(() -> {
                    gameFrame.setVisible(true);
                    gameFrame.setSize(this.getSize());
                });
            }
        });
        backToMenuButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> {
                menuFrame.setVisible(true);
                menuFrame.setSize(this.getSize());});
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}