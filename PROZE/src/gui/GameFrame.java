package gui;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GameFrame extends Frame {

    public GameFrame() {
        super("Space Invaders");

        setLayout(new BorderLayout());

        Panel panelTop = new Panel(new BorderLayout());
        Panel panelButton = new Panel(new FlowLayout());
        Panel panelBottom = new Panel(new BorderLayout());
        Panel panelCanvas = new Panel(new BorderLayout());
        Panel panelPoints = new Panel(new FlowLayout());
        Panel panelLives = new Panel(new FlowLayout());

        TextArea pointsLabel = new TextArea(1,7);
        pointsLabel.setText("Points:");
        pointsLabel.setEditable(false);

        TextArea pointsAmount = new TextArea(1,3);
        pointsAmount.setText("000");
        pointsAmount.setEditable(false);

        TextArea livesLabel = new TextArea(1,11);
        livesLabel.setText("Lives left:");
        livesLabel.setEditable(false);

        TextArea livesAmount = new TextArea(1,1);
        livesAmount.setText("0");
        livesAmount.setEditable(false);

        Button buttonPause = new Button("PAUSE");
        Button buttonExit = new Button("EXIT");

        buttonExit.addActionListener(e -> System.exit(1));
        buttonPause.addActionListener(e -> System.out.println("PAUSE pressed"));

        panelButton.add(buttonPause);
        panelButton.add(buttonExit);

        panelPoints.add(pointsLabel);
        panelPoints.add(pointsAmount);

        panelLives.add(livesLabel);
        panelLives.add(livesAmount);

        panelTop.add(panelButton, BorderLayout.EAST);
        panelTop.add(panelPoints, BorderLayout.WEST);

        panelCanvas.add(new GameCanvas(Color.blue), BorderLayout.CENTER);

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

        pack();
    }

    public static void main(String... args) {
        GameFrame guiWindow = new GameFrame();
        EventQueue.invokeLater(() -> guiWindow.setVisible(true));
    }
}
