package spaceInvaders;

import java.awt.*;
import java.io.IOException;

import configuration.HighScoreManager;
import gameLogic.Animation;
import gameLogic.Cannon;
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
        highScoreManager= new HighScoreManager(conf.getPathHighScores());
        ColorTranslator col = new ColorTranslator();
        cannon = new Cannon(conf.getCannonXScreenPosition(), conf.getCannonYScreenPosition(), conf.getCannonWidth(), conf.getCannonHeight(), col.translateColor(conf.getColorCannon()), conf.getCannonLives());
        gameFrame = new GameFrame(this);
        menuFrame = new MenuFrame(this);
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
        Thread animationThread = new Thread(animation = new Animation(gameFrame));
        animation.setKicker(animationThread);
        animationThread.start();
    }
    /** Metoda konczaca animacje */
    public void stopAnimation() {
        animation.setKicker(null);
        animation = null;
    }
    /** metoda uruchamiajaca cala gre */
    public static void main(String[] args) { new Game(); }
}
