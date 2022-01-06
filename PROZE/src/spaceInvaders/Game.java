package spaceInvaders;

import java.awt.*;
import java.io.IOException;

import configuration.HighScoreManager;
import configuration.LevelHelper;
import gameLogic.Animation;
import gameLogic.Cannon;
import configuration.Configer;
import configuration.Leveler;
import gui.GameOverFrame;
import gui.GameWonFrame;
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
    /** Atrybut klasy MenuFrame */
    final private MenuFrame menuFrame;
    /** Atrybut klasy Cannon */
    final private Cannon cannon;
    /** Atrybut klasy LevelHelper */
    final private LevelHelper levelHelper;

    /** Metoda zwracajaca obiekt klasy Animation */
    public Animation getAnimation() { return animation; }
    /** Metoda zwracajaca obiekt klasy Configer */
    public Configer getConfiger() {return configer; }
    /** Metoda zwracajaca obiekt klasy Leveler */
    public Leveler getLeveler() {
        return leveler;
    }
    /** Metoda zwracajaca obiekt klasy Cannon */
    public Cannon getCannon() { return cannon; }
    /** Metoda zwracajaca obiekt klasy MenuFrame */
    public MenuFrame getMenuFrame() { return menuFrame; }
    /** Metoda zwracajaca obiekt klasy HighScoreManager */
    public HighScoreManager getHighScoreManager() {
        return highScoreManager;
    }
    /** Metoda zwracajaca obiekt klasy LevelHelper */
    public LevelHelper getLevelHelper() { return levelHelper; }

    /** Konstruktor klasy Game */
    Game() {
        Configer conf;
        try {
            conf = new Configer("./PROZE/dataFiles/conf.txt");
        } catch (IOException e) {
            e.printStackTrace();
            conf = null;
        }
        this.leveler = new Leveler();
        this.levelHelper = new LevelHelper();
        configer = conf;
        highScoreManager = new HighScoreManager(configer.getPathHighScores());
        ColorTranslator col = new ColorTranslator();
        cannon = new Cannon(configer.getCannonXScreenPosition(), configer.getCannonYScreenPosition(), configer.getCannonWidth(), configer.getCannonHeight(), col.translateColor(configer.getColorCannon()), configer.getCannonLives());
        menuFrame = new MenuFrame(this);
        menuFrame.setPreferredSize(new Dimension(configer.getPreferredScreenWidth(), configer.getPreferredScreenHeight()));
        menuFrame.setSize(new Dimension(configer.getPreferredScreenWidth(), configer.getPreferredScreenHeight()));
        EventQueue.invokeLater(() -> menuFrame.setVisible(true));
    }
    /** Metoda rozpoczynajaca animacje */
    public void startAnimation() {
        Thread animationThread = new Thread(animation = new Animation(menuFrame.getGameFrame(),this));
        animation.setKicker(animationThread);
        animationThread.start();
    }
    /** Metoda konczaca animacje */
    public void stopAnimation() {
        animation.setKicker(null);
        animation = null;
    }
    /** Metoda wyswiwtlajaca okienko gameOver */
    public void showGameOver(){
        EventQueue.invokeLater(() -> {
            GameOverFrame gameOverFrame = new GameOverFrame(this, menuFrame, menuFrame.getGameFrame().getSize(), menuFrame.getGameFrame().getLocation());
            gameOverFrame.setVisible(true);
            gameOverFrame.requestFocus();
            gameOverFrame.setSize(getMenuFrame().getGameFrame().getSize());
        });
        EventQueue.invokeLater(getMenuFrame().getGameFrame()::dispose);
    }
    /** Metoda wyswiwtlajaca okienko gameWon */
    public void showGameWon() {
        EventQueue.invokeLater(() -> {
            GameWonFrame gameWonFrame = new GameWonFrame(this, menuFrame, menuFrame.getGameFrame().getSize(), menuFrame.getGameFrame().getLocation());
            gameWonFrame.setVisible(true);
            gameWonFrame.requestFocus();
            gameWonFrame.setSize(getMenuFrame().getGameFrame().getSize());
        });
        EventQueue.invokeLater(getMenuFrame().getGameFrame()::dispose);
    }
    /** Metoda uruchamiajaca cala gre */
    public static void main(String[] args) { new Game(); }
}