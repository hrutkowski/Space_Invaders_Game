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

    public Configer(String pathToMainConfiguration) throws IOException {
        InputStream propertiesFile = new FileInputStream(pathToMainConfiguration);
        proper.load(propertiesFile);

        height = Integer.parseInt(proper.getProperty("gameHeight"));
        width = Integer.parseInt(proper.getProperty("gameWidth"));
        maxHighScoreSize = Integer.parseInt(proper.getProperty("highScoreSize"));

        propertiesFile.close();
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

        Configer conf = new Configer("./PROZE/src/conf.txt");

        System.out.println("Wysokość okna = " + conf.getHeight());
        System.out.println("Szerokość okna = " + conf.getWidth());
        System.out.println("Maks graczy = " + conf.getMaxHighScoreSize());
    }
}
