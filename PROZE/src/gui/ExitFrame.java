package gui;

import configuration.Configer;
import spaceInvaders.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ExitFrame extends JFrame {
    public ExitFrame(Game game, JFrame lastFrame, Dimension lastFrameDimension, Point lastFrameLocation) {
        Configer confer = game.getConfiger();
        setTitle(confer.getQuitDialogTitle());
        setSize(confer.getExitFrameWidth(), confer.getExitFrameHeight());
        setLocation(lastFrameLocation);

        JFrame exitFrame = this;

        Panel mainPanel = new Panel(new BorderLayout());
        Panel buttonPanel = new Panel(new FlowLayout());

        Button yesButton = new Button(confer.getQuitDialogYes());
        Button noButton = new Button(confer.getQuitDialogNo());

        Label questionLabel = new Label(confer.getQuitDialogText());

        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        mainPanel.add(questionLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
        yesButton.addActionListener(e-> System.exit(0));
        noButton.addActionListener(e -> {
            EventQueue.invokeLater(this::dispose);
            EventQueue.invokeLater(() -> {
                lastFrame.setSize(lastFrameDimension);
                lastFrame.setLocation(lastFrameLocation);
            });
            EventQueue.invokeLater(() -> lastFrame.setVisible(true));
        });

        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) {
            EventQueue.invokeLater(exitFrame::dispose);
            EventQueue.invokeLater(() -> {
                lastFrame.setSize(lastFrameDimension);
                lastFrame.setLocation(lastFrameLocation);
            });
            EventQueue.invokeLater(() -> lastFrame.setVisible(true));
        }});

        pack();
    }
}
