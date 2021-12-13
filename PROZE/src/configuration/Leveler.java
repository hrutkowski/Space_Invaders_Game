package configuration;

import javax.imageio.metadata.IIOMetadataNode;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Leveler {
    /** Klasa typu Properties do wyciągania wartości z pliku txt */
    static Properties proper = new Properties();

    /**
     * Metoda wczytująca dane z pliku level1
     */
    public Leveler(String pathToMainConfiguration) throws IOException {
        InputStream propertiesFile = new FileInputStream(pathToMainConfiguration);
        proper.load(propertiesFile);
        propertiesFile.close();

    }
    /** Metoda zwracająca playerSpeed */
    public int getPlayerSpeed() {
        return Integer.parseInt(proper.getProperty("playerSpeed"));
    }

    /** Metoda zwracająca PlayerBulletSpeed */
    public int getPlayerBulletSpeed() {
        return Integer.parseInt(proper.getProperty("playerBulletSpeed"));
    }

    /** Metoda zwracająca EnemyNumber */
    public int getEnemyNumber() { return Integer.parseInt(proper.getProperty("enemyNumber"));}
    /** Metoda zwracająca EnemyColumns */
    public int getEnemyColumns() { return Integer.parseInt(proper.getProperty("enemyColumns"));}
    /** Metoda zwracająca EnemyRows */
    public int getEnemyRows() { return Integer.parseInt(proper.getProperty("enemyRows"));}
    /**
     * Metoda do testowania klasy
     */
    public static void main(String[] args) throws IOException {

        Leveler level1 = new Leveler("./dataFiles/level1.txt");

        System.out.println("PlayerSpeed = " + level1.getPlayerSpeed());
        System.out.println("PlayerBulletSpeed = " + level1.getPlayerBulletSpeed());
        System.out.println("EnemyNumber = " + level1.getEnemyNumber());
    }
}