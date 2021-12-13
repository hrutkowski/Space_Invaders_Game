import java.awt.*;
import java.io.IOException;

import gui.GameFrame;
import configuration.Configer;

public class Game {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Configer conf = new Configer("./src/conf.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            GameFrame gameFrame = new GameFrame();
            gameFrame.setVisible(true);
        });
    }
}
