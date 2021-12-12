package gui;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SpaceInvaders");
        add(new MainPanel());
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
