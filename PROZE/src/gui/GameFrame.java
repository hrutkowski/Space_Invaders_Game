package gui;

import gameLogic.*;
import helpfulTools.ColorTranslator;
import configuration.Configer;
import configuration.Leveler;
import spaceInvaders.Game;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/** Klasa odpowiadajaca za okno gry */
public class GameFrame extends JFrame implements KeyListener {

    /** Atrybut klasy GameObjectList */
    private final GameObjectList gameEnemyList;
    /** Atrybut klasy GameObjectList */
    private final GameObjectList gameCannonBulletList;
    /** Atrybut klasy GameObjectList */
    private final GameObjectList gameEnemyBulletList;
    /** Atrybut klasy GameCanvas */
    private final GameCanvas gameCanvas;
    /** Atrybut klasy Cannon */
    private final Cannon cannon;
    /** Atrybut klasy TypeOfMove */
    private typeOfMove cannonState;
    /** Prywatna enumeracja */
    private enum typeOfMove { LEFT, RIGHT, STOPPED }
    /** Atrybut klasy Configer */
    private final Configer confer;
    /** Atrybut klasy Leveler */
    private final Leveler lvl;
    /** Atrybut klasy Label */
    private final Label pointsAmount;
    /** Atrybut klasy Label */
    private final Label livesAmount;
    /** Atrybut klasy Label */
    private final Label levelNumber;
    /** Atrybut klasy Panel */
    private final Panel canvasPanel;
    /** Atrybut klasy Player */
    private final Player player;


    /** Konstruktor klasy GameFrame */
    public GameFrame(Game game) {
        gameEnemyList = new GameObjectList();
        gameCannonBulletList = new GameObjectList();
        gameEnemyBulletList = new GameObjectList();
        this.confer = game.getConfiger();
        setTitle(confer.getGameTitle());
        ColorTranslator colorTranslator = new ColorTranslator();
        this.lvl = game.getLeveler();
        player = new Player("",confer.getInitialPoints());

        cannon = game.getCannon();

        addEnemy(lvl.getEnemyNumber(), colorTranslator);

        setLayout(new BorderLayout());

        Panel topPanel = new Panel(new BorderLayout());
        Panel buttonPanel = new Panel(new FlowLayout());
        Panel bottomPanel = new Panel(new BorderLayout());
        canvasPanel = new Panel(new BorderLayout());
        Panel pointsPanel = new Panel(new FlowLayout());
        Panel livesPanel = new Panel(new FlowLayout());
        Panel levelPanel = new Panel(new FlowLayout());

        Label pointsLabel = new Label(confer.getLabelPoints());
        pointsAmount = new Label(Integer.toString(confer.getInitialPoints()));
        Label livesLabel = new Label(confer.getLabelLivesLeft());
        livesAmount = new Label(Integer.toString(confer.getInitialLives()));
        Label levelLabel = new Label(confer.getLabelLevel());
        levelNumber = new Label(Integer.toString(confer.getInitialLevel()));

        Button pauseButton = new Button(confer.getButtonStartText());
        Button exitButton = new Button(confer.getButtonEndText());

        exitButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> game.getGameFrame().setVisible(false));
            EventQueue.invokeLater(() -> {ExitFrame exitFrame = new ExitFrame(game, game.getGameFrame(), game.getGameFrame().getSize(), game.getGameFrame().getLocation());
                exitFrame.setVisible(true); });
        });
        pauseButton.addActionListener(e -> {
            if (game.getAnimation() == null) {
                game.startAnimation();
                pauseButton.setLabel(confer.getButtonPauseText());
                canvasPanel.requestFocus();
            } else {
                game.stopAnimation();
                pauseButton.setLabel(confer.getButtonStartText());
                canvasPanel.requestFocus();
            }
            pack(); });

        buttonPanel.add(pauseButton);
        buttonPanel.add(exitButton);

        pointsPanel.add(pointsLabel);
        pointsPanel.add(pointsAmount);

        livesPanel.add(livesLabel);
        livesPanel.add(livesAmount);

        levelPanel.add(levelLabel);
        levelPanel.add(levelNumber);

        topPanel.add(buttonPanel, BorderLayout.EAST);
        topPanel.add(levelPanel, BorderLayout.CENTER);
        topPanel.add(pointsPanel, BorderLayout.WEST);

        canvasPanel.add(gameCanvas = new GameCanvas(colorTranslator.translateColor(lvl.getColorBackground()), gameEnemyList, gameCannonBulletList, gameEnemyBulletList, cannon, game), BorderLayout.CENTER);
        canvasPanel.addKeyListener(this);
        bottomPanel.add(livesPanel, BorderLayout.WEST);

        add(topPanel, BorderLayout.NORTH);
        add(canvasPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        addComponentListener(new ComponentAdapter() { @Override public void componentResized(ComponentEvent e) { gameCanvas.setPreferredSize(gameCanvas.getSize()); } });

        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        addKeyListener(this);

        addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) {
            EventQueue.invokeLater(() -> game.getGameFrame().setVisible(false));
            EventQueue.invokeLater(() -> {
                ExitFrame exitFrame = new ExitFrame(game, game.getGameFrame(), game.getGameFrame().getSize(), game.getGameFrame().getLocation());
                exitFrame.setVisible(true);
            });
        }});

        if(game.isGameOver()) {
            EventQueue.invokeLater(() -> {
                // GameOverFrame gameOverFrame = new GameOverFrame(game, this, this.getSize(), this.getLocation());
                // gameOverFrame.setVisible(true);
            });
        }
        if(game.isGameWon()) {
            EventQueue.invokeLater(() -> {
                // GameWonFrame gameWonFrame = new GameWonFrame(game, this, this.getSize(), this.getLocation());
                // gameWinFrame.setVisible(true);
            });
        }

        pack();
    }
    /** Metoda zwracajaca obiekt klasy GameObjectList */
    public GameObjectList getGameEnemyList() {
        return gameEnemyList;
    }
    /** Metoda zwracajaca obiekt klasy GameBulletList */
    public GameObjectList getGameCannonBulletList() {
        return gameCannonBulletList;
    }
    /** Metoda zwracajaca obiekt klasy GameEnemyBulletList */
    public GameObjectList getGameEnemyBulletList() {
        return gameEnemyBulletList;
    }
    /** Metoda zwracająca obiekt klasy GameCanvas */
    public GameCanvas getGameCanvas() {
        return gameCanvas;
    }
    /** Metoda ustawiajaca stan dziala */
    private void setMovementState(typeOfMove state) { cannonState = state; }
    /** Metoda odpowiadajaca za poruszanie dzialem gracza */
    public void moveCannon() {
        float stepX = 0.01f;
        if (cannonState == typeOfMove.LEFT) {
            if (Float.compare(cannon.getX(), 0.01f) > 0) {
                cannon.setX(cannon.getX() - stepX);
            }
        } else if (cannonState == typeOfMove.RIGHT) {
            if (Float.compare(cannon.getX() + stepX + cannon.getWidth(), 1f) < 0) {
                cannon.setX(cannon.getX() + stepX);
            }
        }
    }
    /** Metoda tworząca Enemy */
    public void addEnemy(int enemyNumber, ColorTranslator color) {
        int rows = calulateRows(enemyNumber);
        int columns;
        for (int j = 0; j < rows; j++) {
            float positionY = 0.1f * (j+1);
            columns = Math.min(enemyNumber, confer.getLimitEnemyColumns());
            for (int i = 0; i < columns; i++) {
                float positionX = 1f / (columns + 1) * (i + 1) - confer.getEnemyWidth() / 2;
                gameEnemyList.add(new Enemy(positionX, positionY, confer.getEnemyWidth(), confer.getEnemyHeight(), color.translateColor(lvl.getColorEnemy()), confer.getEnemyLives()));
            }
            enemyNumber-=confer.getLimitEnemyColumns();
        }
    }
    /** Metoda wyliczajaca ilośc kolumn */
    public int calulateRows(int enemyNumber){
        int rows=0;
        if(enemyNumber<=10) rows=1;
        else if(enemyNumber<=20) rows=2;
        else if(enemyNumber<=30) rows=3;
        else if(enemyNumber<=40) rows=4;
        return rows;
    }
    /** Metoda nadpisujaca keyTyped */
    @Override
    public void keyTyped(KeyEvent e) {
    }
    /** Metoda nadpisujaca keyPressed */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                canvasPanel.requestFocus();
                setMovementState(typeOfMove.LEFT);
                moveCannon();
            }
            case KeyEvent.VK_RIGHT -> {
                canvasPanel.requestFocus();
                setMovementState(typeOfMove.RIGHT);
                moveCannon();
            }
            case KeyEvent.VK_SPACE -> cannon.fire(gameCannonBulletList, confer.getBulletWidth(), confer.getBulletHeight());
            default -> {
                setMovementState(typeOfMove.STOPPED);
                canvasPanel.requestFocus();
            }
        }
    }
    /** Metoda nadpisujaca keyReleased */
    @Override
    public void keyReleased(KeyEvent e) {
        setMovementState(typeOfMove.STOPPED);
    }
    /** Metoda aktualizujac wynik */
    public void setScore(int points){ pointsAmount.setText(String.valueOf(points)); }
    /** Metoda aktualizujac ilosc zyc */
    public void setLives(int lives){ livesAmount.setText(String.valueOf(lives)); }
    /** Metoda aktualizujac numer poziomu */
    public void nextLevel(){ levelNumber.setText(String.valueOf(Integer.parseInt(levelNumber.getText())+1)); }
    /** Metoda zwracajaca obiekt klasy Player */
    public Player getPlayer() { return player; }
}