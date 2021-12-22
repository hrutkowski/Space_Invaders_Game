package gui;

import configuration.Configer;
import gameLogic.Cannon;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** Klasa okna z ustawieniami */
public class SettingsFrame extends JFrame {

    /** Konstruktor klasy SettingsFrame */
    SettingsFrame(Game game, MenuFrame menuFrame){
        Configer confer = game.getConfiger();
        setTitle(confer.getSettingsTitle());

        Cannon cannon = game.getCannon();

        setLayout(new BorderLayout());

        Panel mainPanel = new Panel(new BorderLayout());
        Panel buttonPanel = new Panel(new FlowLayout());

        Button backToMenuButton = new Button(confer.getBackToMenuText());
        Button blackColorButton = new Button("black"); // POTEM DO ZMIANY
        Button blueColorButton = new Button("blue");
        Button yellowColorButton = new Button("yellow");

        Label colorCannonLabel = new Label(confer.getLabelColorCannon());

        buttonPanel.add(colorCannonLabel);
        buttonPanel.add(blueColorButton);
        buttonPanel.add(blackColorButton);
        buttonPanel.add(yellowColorButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(backToMenuButton, BorderLayout.SOUTH);

        add(mainPanel);

        backToMenuButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> {
                menuFrame.setVisible(true);
                menuFrame.setSize(this.getSize());});
        });
        blueColorButton.addActionListener(e -> cannon.setColor("blue"));
        blackColorButton.addActionListener(e -> cannon.setColor("black"));
        yellowColorButton.addActionListener(e -> cannon.setColor("yellow"));

        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) { System.exit(0);} });

        pack();
    }
}
