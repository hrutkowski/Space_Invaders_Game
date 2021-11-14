package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configer {

    private int height;
    private int width;
    private int maxHighScoreSize;
    Properties proper = new Properties();

    public Configer(String pathToMainConfiguration) {

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getMaxHighScoreSize() {
        return maxHighScoreSize;
        //
    }

    public static void main(String[] args) throws IOException {

        InputStream propertiesFile = new FileInputStream("./Hello/src/config.txt");
        proper.load(propertiesFile);

        height = Integer.parseInt(proper.getProperty("gameHeight"));
        width = Integer.parseInt(proper.getProperty("gameWidth"));
        maxHighScoreSize = Integer.parseInt(proper.getProperty("highScoreSize"));

        System.out.println("Wysokość okna = " + height + "/n");
        System.out.println("Szerokość okna = " + width + "/n");
    }
}
