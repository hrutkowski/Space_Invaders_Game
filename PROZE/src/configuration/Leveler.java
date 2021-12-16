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
    public float getPlayerSpeed() {
        return Float.parseFloat(proper.getProperty("playerSpeed"));
    }
    /** Metoda zwracająca PlayerBulletSpeed */
    public float getPlayerBulletSpeed() {
        return Float.parseFloat(proper.getProperty("playerBulletSpeed"));
    }
    /** Metoda zwracająca EnemyNumber */
    public int getEnemyNumber() { return Integer.parseInt(proper.getProperty("enemyNumber"));}
    /** Metoda zwracająca ColorEnemy */
    public String getColorEnemy() {return proper.getProperty("colorEnemy");}
    /** Metoda zwracająca bulletSpeedEnemy */
    public float getBulletSpeedEnemy() {return Float.parseFloat(proper.getProperty("bulletSpeedEnemy"));}
    /** Metoda zwracająca enemyPoints */
    public int getEnemyPoints() { return Integer.parseInt(proper.getProperty("enemyPoints")); }
    /** Metoda zwracająca ColorBackground */
    public String getColorBackground() {return proper.getProperty("colorBackground");}
    /** Metoda zwracająca enemy1XScreenPosition */
    public float getEnemy1XScreenPosition() {return Float.parseFloat(proper.getProperty("enemy1XScreenPosition"));}
    /** Metoda zwracająca enemy1YScreenPosition */
    public float getEnemy1YScreenPosition() {return Float.parseFloat(proper.getProperty("enemy1YScreenPosition"));}
    /** Metoda zwracająca enemy2XScreenPosition */
    public float getEnemy2XScreenPosition() {return Float.parseFloat(proper.getProperty("enemy2XScreenPosition"));}
    /** Metoda zwracająca enemy2YScreenPosition */
    public float getEnemy2YScreenPosition() {return Float.parseFloat(proper.getProperty("enemy2YScreenPosition"));}
    /** Metoda zwracająca enemy3XScreenPosition */
    public float getEnemy3XScreenPosition() {return Float.parseFloat(proper.getProperty("enemy3XScreenPosition"));}
    /** Metoda zwracająca enemy3YScreenPosition */
    public float getEnemy3YScreenPosition() {return Float.parseFloat(proper.getProperty("enemy3YScreenPosition"));}
    /** Metoda zwracająca enemy4XScreenPosition */
    public float getEnemy4XScreenPosition() {return Float.parseFloat(proper.getProperty("enemy4XScreenPosition"));}
    /** Metoda zwracająca enemy4YScreenPosition */
    public float getEnemy4YScreenPosition() {return Float.parseFloat(proper.getProperty("enemy4YScreenPosition"));}
    /**
     * Metoda do testowania klasy
     */
    public static void main(String[] args) throws IOException {

        Leveler level1 = new Leveler("./PROZE/dataFiles/level1.txt");
        Leveler level2 = new Leveler("./PROZE/dataFiles/level2.txt");
        Leveler level3 = new Leveler("./PROZE/dataFiles/level3.txt");

        System.out.println("PlayerSpeed = " + level1.getPlayerSpeed());
        System.out.println("PlayerBulletSpeed = " + level1.getPlayerBulletSpeed());
        System.out.println("EnemyNumber = " + level1.getEnemyNumber());
        System.out.println("EnemyColor = " + level1.getColorEnemy());
        System.out.println("BulletSpeedEnemy = " + level1.getBulletSpeedEnemy());
        System.out.println("EnemyPoints = " + level1.getEnemyPoints());
        System.out.println("BackGroundColor = " + level1.getColorBackground());
    }
}