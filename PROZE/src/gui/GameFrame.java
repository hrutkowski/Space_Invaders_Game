package gui;
import helpfulTools.ColorTranslator;
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
public class GameFrame extends JFrame implements KeyListener{

    private final Game game;
    private final GameObjectList gameObjectList;
    private final Cannon cannon;
    private final GameCanvas gameCanvas;

    /**
     * Metoda zwracająca obiekt klasy GameCanvas
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
        ColorTranslator color = new ColorTranslator();
        Leveler lvl1 = game.getLeveler();

        cannon = new Cannon(confer.getCannonXScreenPosition(), confer.getCannonYScreenPosition(), confer.getObjectWidth(), confer.getObjectHeight(), color.translateColor(confer.getColorCannon()));

        Enemy enemy1 = new Enemy(lvl1.getEnemy1XScreenPosition(), lvl1.getEnemy1YScreenPosition(), confer.getObjectWidth(), confer.getObjectHeight(), color.translateColor(lvl1.getColorEnemy()));
        Enemy enemy2 = new Enemy(lvl1.getEnemy2XScreenPosition(), lvl1.getEnemy2YScreenPosition(), confer.getObjectWidth(), confer.getObjectHeight(), color.translateColor(lvl1.getColorEnemy()));
        Enemy enemy3 = new Enemy(lvl1.getEnemy3XScreenPosition(), lvl1.getEnemy3YScreenPosition(), confer.getObjectWidth(), confer.getObjectHeight(), color.translateColor(lvl1.getColorEnemy()));
        Enemy enemy4 = new Enemy(lvl1.getEnemy4XScreenPosition(), lvl1.getEnemy4YScreenPosition(), confer.getObjectWidth(), confer.getObjectHeight(), color.translateColor(lvl1.getColorEnemy()));
        gameObjectList.add(enemy1);
        gameObjectList.add(enemy2);
        gameObjectList.add(enemy3);
        gameObjectList.add(enemy4);

        setLayout(new BorderLayout());

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
                panelCanvas.requestFocus();
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

        panelCanvas.add(gameCanvas = new GameCanvas(color.translateColor(lvl1.getColorBackground()), gameObjectList, cannon), BorderLayout.CENTER);
        panelCanvas.addKeyListener(this);
        panelBottom.add(panelLives, BorderLayout.WEST);

        add(panelTop, BorderLayout.NORTH);
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
            }
        });

        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        addKeyListener(this);

        pack();
    }

    /**
     * Metoda zwracajaca obiekt klasy GameObjectList
     */
    public GameObjectList getGameObjectList() {
        return gameObjectList;
    }

    /**
     * Metoda zwracajaca obiekt klasy Cannon
     */
    public Cannon getCannon() {
        return cannon;
    }

    private typeOfMove cannonState;


    private enum typeOfMove {
        LEFT,
        RIGHT,
        STOPPED
    }

    private void setMovementState(typeOfMove state) {
        cannonState = state;
    }

    /**
     * Metoda do poruszania dzialem gracza
     */
    public void moveCannon() {
        float stepX = 0.01f;
        if (cannonState == typeOfMove.LEFT) {
            if (Float.compare(cannon.getX(), 0f) > 0) {
                cannon.setX(cannon.getX() - stepX);
            }
        } else if (cannonState == typeOfMove.RIGHT) {
            if (Float.compare(cannon.getX() + stepX + cannon.getWidth(), 1f) < 0) {
                cannon.setX(cannon.getX() + stepX);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                setMovementState(typeOfMove.LEFT);
                moveCannon();
            }
            case KeyEvent.VK_RIGHT -> {
                setMovementState(typeOfMove.RIGHT);
                moveCannon();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        setMovementState(typeOfMove.STOPPED);
    }
}