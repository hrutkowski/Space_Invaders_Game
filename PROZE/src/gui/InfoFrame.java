package gui;

import configuration.Configer;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** Klasa okna z infirmacjami */
public class InfoFrame extends JFrame {

    /** Konstruktor InfoFrame */
    InfoFrame(Game game, MenuFrame menuFrame) {
        Configer confer = game.getConfiger();
        setTitle(confer.getInfoTitle());

        setLayout(new BorderLayout());

        Panel mainPanel = new Panel(new BorderLayout());

        JTextArea text = new JTextArea(20,10);
        text.setText(confer.getInfoText());
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setEditable(false);

        Button backToMenuButton = new Button(confer.getBackToMenuText());

        mainPanel.add(text,BorderLayout.CENTER);
        mainPanel.add(backToMenuButton, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);

        backToMenuButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> this.setVisible(false));
            EventQueue.invokeLater(() -> {
                menuFrame.setSize(this.getSize());
                menuFrame.setLocation(this.getLocation()); });
            EventQueue.invokeLater(() -> menuFrame.setVisible(true) );
        });

        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) {
            EventQueue.invokeLater(() -> game.getMenuFrame().getInfoFrame().setVisible(false));
            EventQueue.invokeLater(() -> {
                ExitFrame exitFrame = new ExitFrame(game, game.getMenuFrame().getInfoFrame(), game.getMenuFrame().getInfoFrame().getSize(), game.getMenuFrame().getInfoFrame().getLocation());
                exitFrame.setVisible(true);
            });
        }});

        pack();
    }
}
