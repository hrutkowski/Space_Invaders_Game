import java.awt.*;
import java.io.IOException;

import gui.MainFrame;
import configuration.Configer;

public class Game {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Configer conf = new Configer("./PROZE/src/conf.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
