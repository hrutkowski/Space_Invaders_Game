package configuration;

import javax.imageio.metadata.IIOMetadataNode;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** Klasa odpowiedzialna za wczytywanie danych z pliku konfiguracyjnego */

public class Configer {
    /** Klasa typu Properties do wyciągania wartości z pliku txt */
    static Properties proper = new Properties();
    /** Metoda wczytująca dane z pliku konfiguracyjnego */
    public Configer(String pathToMainConfiguration) throws IOException {
        InputStream propertiesFile = new FileInputStream(pathToMainConfiguration);
        proper.load(propertiesFile);

        //Settings

        propertiesFile.close();
    }
    /** Metoda zwracająca gameHeight */
    public int getGameHeight() {
        return Integer.parseInt(proper.getProperty("gameHeight"));
    }
    /** Metoda zwracająca gameWidth */
    public int getGameWidth() {
        return Integer.parseInt(proper.getProperty("gameWidth"));
    }
    /** Metoda zwracająca maxHighScoreSize */
    public int getMaxHighScoreSize() {
        return Integer.parseInt(proper.getProperty("maxHighScoreSize"));
    }
    /** Metoda zwracająca gameTitle */
    public static String getGameTitle() { return proper.getProperty("gameTitle"); }
    /** Metoda zwracająca buttonStartText */
    public static String getButtonStartText() { return proper.getProperty("buttonStartText"); }
    /** Metoda zwracająca buttonRankText */
    public String getButtonRankText() { return proper.getProperty("buttonRankText"); }
    /** Metoda zwracająca buttonSettingsText */
    public static String getButtonSettingsText() {
        return proper.getProperty("buttonSettingsText");
    }
    /** Metoda zwracająca buttonInfoText */
    public static String getButtonInfoText() {
        return proper.getProperty("buttonInfoText");
    }
    /** Metoda zwracająca buttonEndText */
    public static String getButtonEndText() {
        return proper.getProperty("buttonEndText");
    }
    /** Metoda zwracająca quitDialogText */
    public static String getQuitDialogText() {
        return proper.getProperty("quitDialogText");
    }
    /** Metoda zwracająca quitDialogYes */
    public static String getQuitDialogYes() {
        return proper.getProperty("quitDialogYes");
    }
    /** Metoda zwracająca quitDialogNo */
    public static String getQuitDialogNo() {
        return proper.getProperty("quitDialogNo");
    }
    /** Metoda zwracająca buttonBackToMenuText */
    public String getButtonBackToMenuText() {
        return proper.getProperty("buttonBackToMenuText");
    }
    /** Metoda zwracająca buttonAcceptText */
    public String getButtonAcceptText() {
        return proper.getProperty("buttonAcceptText");
    }
    /** Metoda zwracająca buttonPauseText */
    public String getButtonPauseText() {
        return proper.getProperty("buttonPauseText");
    }
    /** Metoda zwracająca buttonPlayAgainText */
    public String getButtonPlayAgainText() {
        return proper.getProperty("buttonPlayAgainText");
    }
    /** Metoda zwracająca gameOverText */
    public String getGameOverText() {
        return proper.getProperty("gameOverText");
    }
    /** Metoda zwracająca nickText */
    public String getNickText() {
        return proper.getProperty("nickText");
    }
    /** Metoda zwracająca pathInfo */
    public String getPathInfo() {
        return proper.getProperty("pathInfo");
    }
    //pathSettings=
    /** Metoda zwracająca initialPoints */
    public int getInitialPoints() {
        return Integer.parseInt(proper.getProperty("initialPoints"));
    }
    /** Metoda zwracająca labelPoints */
    public int getLabelPoints() {
        return Integer.parseInt(proper.getProperty("labelPoints"));
    }
    /** Metoda zwracająca labelLifesLeft */
    public int getLabelLifesLeft() {
        return Integer.parseInt(proper.getProperty("labelLifesLeft"));
    }
    /** Metoda zwracająca fps */
    public int getFps() {
        return Integer.parseInt(proper.getProperty("fps"));
    }
    /** Metoda zwracająca enemyLifes */
    public int getEnemyLifes() {
        return Integer.parseInt(proper.getProperty("enemyLifes"));
    }
    /** Metoda zwracająca enemyRedPoints */
    public int getEnemyRedPoints() {
        return Integer.parseInt(proper.getProperty("enemyRedPoints"));
    }
    /** Metoda zwracająca enemyBluePoints */
    public int getEnemyBluePoints() {
        return Integer.parseInt(proper.getProperty("enemyBluePoints"));
    }
    /** Metoda zwracająca enemyGreenPoints */
    public int getEnemyGreenPoints() { return Integer.parseInt(proper.getProperty("enemyGreenPoints")); }
    /** Metoda zwracająca enemyYellowPoints */
    public int getEnemyYellowPoints() { return Integer.parseInt(proper.getProperty("enemyYellowPoints")); }
    /** Metoda zwracająca enemyRedBulletSpeed */
    public int getEnemyRedBulletSpeed() {
        return Integer.parseInt(proper.getProperty("enemyRedBulletSpeed"));
    }
    /** Metoda zwracająca blueBulletSpeed */
    public int getEnemyBlueBulletSpeed() {
        return Integer.parseInt(proper.getProperty("enemyBlueBulletSpeed"));
    }
    /** Metoda zwracająca enemyGreenBulletSpeed */
    public int getEnemyGreenBulletSpeed() {
        return Integer.parseInt(proper.getProperty("enemyGreenBulletSpeed"));
    }
    /** Metoda zwracająca enemyYellowBulletSpeed */
    public int getEnemyYellowBulletSpeed() {
        return Integer.parseInt(proper.getProperty("enemyYellowBulletSpeed"));
    }
    /** Metoda zwracająca playerXScreenPosition */
    public float getPlayerXScreenPosition() {
        return Float.parseFloat(proper.getProperty("playerXScreenPosition"));
    }
    /** Metoda zwracająca playerYScreenPosition */
    public float getPlayerYScreenPosition() {
        return Float.parseFloat(proper.getProperty("playerYScreenPosition"));
    }


    /** Metoda do testowania klasy */
    public static void main(String[] args) throws IOException {

        Configer conf = new Configer("./PROZE/src/conf.txt");

        System.out.println("Wysokość okna = " + conf.getGameHeight());
        System.out.println("Szerokość okna = " + conf.getGameWidth());
        System.out.println("Maks graczy = " + conf.getMaxHighScoreSize());
        System.out.println("Nazwa gry = " + conf.getGameTitle());
        System.out.println("Przycisk Startu: " + conf.getButtonStartText());
        System.out.println("Przycisk Ranking: " + conf.getButtonRankText());
        System.out.println("Przycisk Ustawienia: " + conf.getButtonSettingsText());
        System.out.println("Przycisk Informacji: " + conf.getButtonInfoText());
        System.out.println("Przycisk Końca gry " + conf.getButtonEndText());
        System.out.println("Komunikat o wyjsciu z gry " + conf.getQuitDialogText());
        System.out.println("Komunikat o wyjsciu z gry - odpowiedz twoerdzaca " + conf.getQuitDialogYes());
        System.out.println("Komunikat o wyjsciu z gry - odpowiedz przeczaca " + conf.getQuitDialogNo());
        System.out.println("Przycisk Powrotu do menu: " + conf.getButtonBackToMenuText());
        System.out.println("Przycisk akceptacji: " + conf.getButtonAcceptText());
        System.out.println("Przycisk pauzy: " + conf.getButtonPauseText());
        System.out.println("Przycisk by zagrac jeszcze raz: " + conf.getButtonPlayAgainText());
        System.out.println("Tekst gameover: " + conf.getGameOverText());
        System.out.println("Tekst przy nicku: " + conf.getNickText());
        System.out.println("Intrukcja gry: " + conf.getPathInfo());


        //pathSettings=

        System.out.println("Początkowa liczba pkt = " + conf.getInitialPoints());
        System.out.println("Zdobyta liczba pkt = " + conf.getLabelPoints());
        System.out.println("Pozostała liczba żyć = " + conf.getLabelLifesLeft());
        System.out.println("FPS = " + conf.getFps());
        System.out.println("Pozostała liczba żyć przeciwnika = " + conf.getEnemyLifes());
        System.out.println("Pkt za zniszczenie czerwonego przeciwnika = " + conf.getEnemyRedPoints());
        System.out.println("Pkt za zniszczenie niebieskiego przeciwnika = " + conf.getEnemyBluePoints());
        System.out.println("Pkt za zniszczenie zielonego przeciwnika = " + conf.getEnemyGreenPoints());
        System.out.println("Pkt za zniszczenie żółtego przeciwnika = " + conf.getEnemyYellowPoints());
        System.out.println("Prędkość pocisku czerwonego przeciwnika = " + conf.getEnemyRedBulletSpeed());
        System.out.println("Prędkość pocisku niebieskiego przeciwnika = " + conf.getEnemyBlueBulletSpeed());
        System.out.println("Prędkość pocisku zielonego przeciwnika = " + conf.getEnemyGreenBulletSpeed());
        System.out.println("Prędkość pocisku żółtego przeciwnika = " + conf.getEnemyYellowBulletSpeed());
        System.out.println("Położenie działa na osi X = " + conf.getPlayerXScreenPosition());
        System.out.println("Położenie działa na osi Y = " + conf.getPlayerYScreenPosition());

    }
}
