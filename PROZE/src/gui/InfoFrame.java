package gui;

import configuration.Configer;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InfoFrame extends JFrame {

    InfoFrame(Game game, MenuFrame menuFrame) {
        Configer confer = game.getConfiger();
        setPreferredSize(new Dimension(confer.getPreferredScreenWidth(), confer.getPreferredScreenHeight()));
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
