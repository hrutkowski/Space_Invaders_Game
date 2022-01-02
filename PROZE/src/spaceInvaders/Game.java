package spaceInvaders;

import java.awt.*;
import java.io.IOException;

import configuration.HighScoreManager;
import gameLogic.Animation;
import gameLogic.Cannon;
import gameLogic.Player;
import gui.GameFrame;
import configuration.Configer;
import configuration.Leveler;
import gui.MenuFrame;
import helpfulTools.ColorTranslator;

/** Glowna klasa gry */
public class Game {

    /** Atrybut klasy Configer */
    final private Configer configer;
    /** Atrybut klasy Leveler */
    final private Leveler leveler;
    /** Atrybut klasy HighScoreManager */
    final private HighScoreManager highScoreManager;
    /** Atrybut klasy Animation */
    private Animation animation;
    /** Atrybut klasy GameFrame */
    final private GameFrame gameFrame;
    /** Atrybut klasy MenuFrame */
    final private MenuFrame menuFrame;
    /** Atrybut klasy Cannon */
    final private Cannon cannon;
    /** Atrybut klasy Player */
    final private Player player;
    /** Atrybut mowiacy o koncu gry */
    public boolean gameOver;

    /** Metoda zwracajaca obiekt klasy Animation */
    public Animation getAnimation() { return animation; }
    /** Metoda zwracajaca obiekt klasy Configer */
    public Configer getConfiger() {return configer;}
    /** Metoda zwracajaca obiekt klasy Leveler */
    public Leveler getLeveler() {
        return leveler;
    }
    /** Metoda zwracajaca obiekt klasy Cannon */
    public Cannon getCannon() { return cannon; }
    /** Metoda zwracajaca obiekt klasy MenuFrame */
    public MenuFrame getMenuFrame() { return menuFrame; }
    /** Metoda zwracajaca obiekt klasy GameFrame */
    public GameFrame getGameFrame() { return gameFrame; }
    /** Metoda zwracajaca obiekt klasy HighScoreManager */
    public HighScoreManager getHighScoreManager() {
        return highScoreManager;
    }
    /** Metoda zwracajaca obiekt klasy Player */
    public Player getPlayer() { return player; }
    /** Metoda zwracajaca GameOver */
    public boolean isGameOver() { return gameOver; }
    /** Metoda ustawiajaca GameOver */
    public void GameOver() { gameOver=true; }

    /** Konstruktor klasy Game */
    Game() {
        Configer conf;
        try {
            conf = new Configer("./PROZE/dataFiles/conf.txt");
        } catch (IOException e) {
            e.printStackTrace();
            conf = null;
        }
        Leveler lev1;
        try {
            lev1 = new Leveler(conf.getPathLevel1());
        } catch (IOException e) {
            e.printStackTrace();
            lev1 = null;
        }
        leveler = lev1;
        configer = conf;
        gameOver = false;
        player = new Player("",0);
        highScoreManager = new HighScoreManager(configer.getPathHighScores());
        ColorTranslator col = new ColorTranslator();
        cannon = new Cannon(configer.getCannonXScreenPosition(), configer.getCannonYScreenPosition(), configer.getCannonWidth(), configer.getCannonHeight(), col.translateColor(configer.getColorCannon()), configer.getCannonLives());
        gameFrame = new GameFrame(this);
        menuFrame = new MenuFrame(this);
        menuFrame.setPreferredSize(new Dimension(configer.getPreferredScreenWidth(), configer.getPreferredScreenHeight()));
        menuFrame.setSize(new Dimension(configer.getPreferredScreenWidth(), configer.getPreferredScreenHeight()));
        EventQueue.invokeLater(() -> menuFrame.setVisible(true));
        Thread repaintThread = new Thread(() -> {
            try {
                Thread.sleep(configer.getFps()); // FPS
                gameFrame.repaint();
            } catch (InterruptedException ignore) {
            }
        });
        repaintThread.start();
    }
    /** Metoda rozpoczynajaca animacje */
    public void startAnimation() {
        Thread animationThread = new Thread(animation = new Animation(gameFrame,this));
        animation.setKicker(animationThread);
        animationThread.start();
    }
    /** Metoda konczaca animacje */
    public void stopAnimation() {
        animation.setKicker(null);
        animation = null;
    }
    /** Metoda uruchamiajaca cala gre */
    public static void main(String[] args) { new Game(); }
}