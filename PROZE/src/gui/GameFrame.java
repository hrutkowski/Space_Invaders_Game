package gui;
import configuration.Configer;
import configuration.Leveler;
import gameLogic.Cannon;
import gameLogic.Enemy;
import gameLogic.GameObjectList;
import spaceInvaders.Game;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/** Klasa odpowiadajaca za okno gry */
public class GameFrame extends JFrame implements  KeyListener{

    private final Game game;
    private final GameObjectList gameObjectList;
    private final Cannon cannon;
    private final GameCanvas gameCanvas;


    /**
     * Metoda zaracająca obiekt klasy GameCanvas
     */
    public GameCanvas getGameCanvas() {
        return gameCanvas;
    }

    /**
     * Konstruktor klasy GameFrame
     */
    public GameFrame(Game game) {

        super("Space Invaders");
        this.game = game;
        gameObjectList = new GameObjectList();
        Configer confer = game.getConfiger();
        Leveler lvl1 = game.getLeveler();
        setFocusable(true);
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        requestFocusInWindow();
        cannon = new Cannon(confer.getCannonXScreenPosition(), confer.getCannonYScreenPosition(), confer.getObjectWidth(), confer.getObjectHeight(), Color.getColor(confer.getColorCannon()));

        Enemy enemy1 = new Enemy(lvl1.getEnemy1XScreenPosition(),lvl1.getEnemy1YScreenPosition(), confer.getObjectWidth(), confer.getObjectHeight(), Color.getColor(lvl1.getColorEnemy()));
        gameObjectList.add(enemy1);
        Enemy enemy2 = new Enemy(lvl1.getEnemy2XScreenPosition(), lvl1.getEnemy2YScreenPosition(), confer.getObjectWidth(), confer.getObjectHeight(), Color.getColor(lvl1.getColorEnemy()));
        gameObjectList.add(enemy2);
        Enemy enemy3 = new Enemy(lvl1.getEnemy3XScreenPosition(), lvl1.getEnemy3YScreenPosition(), confer.getObjectWidth(), confer.getObjectHeight(), Color.getColor(lvl1.getColorEnemy()));
        gameObjectList.add(enemy3);
        Enemy enemy4 = new Enemy(lvl1.getEnemy4XScreenPosition(), lvl1.getEnemy4YScreenPosition(), confer.getObjectWidth(), confer.getObjectHeight(), Color.getColor(lvl1.getColorEnemy()));
        gameObjectList.add(enemy4);

        setLayout(new BorderLayout());

        final int[] points = {0};

        Panel panelTop = new Panel(new BorderLayout());
        Panel panelButton = new Panel(new FlowLayout());
        Panel panelBottom = new Panel(new BorderLayout());
        Panel panelCanvas = new Panel(new BorderLayout());
        Panel panelPoints = new Panel(new FlowLayout());
        Panel panelLives = new Panel(new FlowLayout());

        Label pointsLabel = new Label(confer.getLabelPoints());
        Label pointsAmount = new Label(Integer.toString(confer.getInitialPoints()));
        Label livesLabel = new Label(confer.getLabelLifesLeft());
        Label livesAmount = new Label(Integer.toString(confer.getInitialLives()));

        Button pauseButton = new Button(confer.getButtonStartText());
        Button exitButton = new Button(confer.getButtonEndText());


        exitButton.addActionListener(e -> System.exit(1));
        pauseButton.addActionListener(e -> {
            if (game.getAnimation() == null) {
                game.startAnimation();
                pauseButton.setLabel(confer.getButtonPauseText());
            } else {
                game.stopAnimation();
                pauseButton.setLabel(confer.getButtonStartText());
            }
            pack();
        });

        panelButton.add(pauseButton);
        panelButton.add(exitButton);

        panelPoints.add(pointsLabel);
        panelPoints.add(pointsAmount);

        panelLives.add(livesLabel);
        panelLives.add(livesAmount);

        panelTop.add(panelButton, BorderLayout.EAST);
        panelTop.add(panelPoints, BorderLayout.WEST);

        panelCanvas.add(gameCanvas = new GameCanvas(Color.getColor(lvl1.getColorBackground()), gameObjectList, cannon, BorderLayout.CENTER));
        panelCanvas.addKeyListener(this);
        panelCanvas.setFocusable(true);
        panelCanvas.requestFocusInWindow();
        panelCanvas.setFocusTraversalKeysEnabled(false);

        panelBottom.add(panelLives, BorderLayout.WEST);

        add(panelTop, BorderLayout.NORTH);
        //https://stackoverflow.com/questions/8498147/addkeylistener-doesnt-work-for-jpanel
        /*JPanel panel = new JPanel();
        panel.add(panelCanvas);
        add(panel, BorderLayout.CENTER);

        panelCanvas.addKeyListener(new KeyListener() {

            @Override
           public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Pressed " + e.getKeyChar());
            }
        });

        panel.setFocusable(true);
        panel.requestFocusInWindow();*/
        add(panelCanvas, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                gameCanvas.setPreferredSize(gameCanvas.getSize());
                System.out.println("componentResized");
            }
        });

        pack();
    }
    /** Metoda zwracajaca obiekt klasy GameObjectList */
    public GameObjectList getGameObjectList() { return gameObjectList; }

    /** Metoda zwracajaca obiekt klasy Cannon */
    public Cannon getCannon() { return cannon; }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (e.getKeyCode() == 'W' ) {System.out.println("elo");
    }
}
    @Override
    public void keyReleased(KeyEvent e) {

    }


}
