package configuration;

import javax.imageio.metadata.IIOMetadataNode;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Leveler {
    /**
     * Określa predkosc gracza
     */
    private int playerSpeed;
    /**
     * Określa predkoc pocisku gracza
     */
    private int playerBulletSpeed;
    /**
     * Określa liczbe przeciwnikow na mapie
     */
    private int enemyNumber;

    Properties proper = new Properties();

    /**
     * Metoda wczytująca dane z pliku level1
     */
    public Leveler(String pathToMainConfiguration) throws IOException {
        InputStream propertiesFile = new FileInputStream(pathToMainConfiguration);
        proper.load(propertiesFile);

        playerSpeed = Integer.parseInt(proper.getProperty("playerSpeed"));
        playerBulletSpeed = Integer.parseInt(proper.getProperty("playerBulletSpeed"));
        enemyNumber = Integer.parseInt(proper.getProperty("enemyNumber"));

        propertiesFile.close();

    }
    /** Metoda zwracająca playerSpeed */
    public int getPlayerSpeed() {
        return playerSpeed;
    }

    /** Metoda zwracająca PlayerBulletSpeed */
    public int getPlayerBulletSpeed() {
        return playerBulletSpeed;
    }

    /** Metoda zwracająca EnemyNumber */
    public int getEnemyNumber() {
        return enemyNumber;
    }

    /**
     * Metoda do testowania klasy
     */
    public static void main(String[] args) throws IOException {

        Leveler level1 = new Leveler("./PROZE/src/level1.txt");

        System.out.println("PlayerSpeed = " + level1.getPlayerSpeed());
        System.out.println("PlayerBulletSpeed = " + level1.getPlayerBulletSpeed());
        System.out.println("EnemyNumber = " + level1.getEnemyNumber());
    }
}