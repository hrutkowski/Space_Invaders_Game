package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** Klasa odpowiedzialna za odczytywanie paramertów poziomów z pliku txt */
public class Leveler {

    /** Klasa typu Properties do wyciągania wartości z pliku txt */
    static Properties proper = new Properties();

    /** Konstruktor klasy Leveler */
    public Leveler() {}
    /** Metoda wczytująca dane z pliku txt */
    public void loadLevelConfiguration(String pathToTxt) throws IOException {
        InputStream propertiesFile = new FileInputStream(pathToTxt);
        proper.load(propertiesFile);
        propertiesFile.close();
    }
    /** Metoda zwracająca EnemyNumber */
    public int getEnemyNumber() { return Integer.parseInt(proper.getProperty("enemyNumber")); }
    /** Metoda zwracająca ColorEnemy */
    public String getColorEnemy() {return proper.getProperty("colorEnemy"); }
    /** Metoda zwracająca enemyPoints */
    public int getEnemyPoints() { return Integer.parseInt(proper.getProperty("enemyPoints")); }
    /** Metoda zwracająca ColorBackground */
    public String getColorBackground() {return proper.getProperty("colorBackground"); }
    /** Metoda zwracająca endLevelPoints */
    public int getEndLevelPoints() { return Integer.parseInt(proper.getProperty("endLevelPoints")); }
    /** Metoda zwracająca shootingRatio */
    public int getShootingRatio() {
        System.out.println(proper.getProperty("shootingRatio"));
        return Integer.parseInt(proper.getProperty("shootingRatio")); }
}