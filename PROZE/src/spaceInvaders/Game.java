package spaceInvaders;

import java.awt.*;
import java.io.IOException;

import gameLogic.Animation;
import gui.GameFrame;
import configuration.Configer;

/** Glowna klasa gry */
public class Game {
    final private Configer configer;
    final private Thread repaintThread;
    private Thread animationThread;
    private Animation animation;
    final private GameFrame gameFrame;
    /** Metoda zwracajaca obiekt klasy Configer */
    public Configer getConfiger() {
        return configer;
    }
    /** Konstruktor klasy Game */
    Game() {
        Configer conf;
        try {
            conf = new Configer("./dataFiles/conf.txt");
        } catch (IOException e) {
            e.printStackTrace();
            conf = null;
        }
        configer = conf;
        gameFrame = new GameFrame(this);
        EventQueue.invokeLater(() -> gameFrame.setVisible(true));
        repaintThread = new Thread(() -> {
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
        animationThread = new Thread(animation = new Animation(gameFrame));
        animation.setKicker(animationThread);
        animationThread.start();
    }
    /** Metoda konczaca animacje */
    public void stopAnimation() {
        animation.setKicker(null);
        animation = null;
    }
    /** Metoda zwracajaca obiekt klasy Animation */
    public Animation getAnimation() { return animation; }
    /** metoda uruchamiajaca cala gre */
    public static void main(String[] args) {
        new Game();
    }
}
