package configuration;

import javax.imageio.metadata.IIOMetadataNode;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** Klasa odpowiedzialna za wczytywanie danych z pliku konfiguracyjnego */

public class Configer {
    /** Określa startową wysokość okna gry*/
    private int gameHeight;
    /** Określa startową szerokość okna gry*/
    private int gameWidth;
    /** Określa maksymalną liczbę najwyższych wyników zapisywanych w Rankingu*/
    private int maxHighScoreSize;
    /** Tytuł gry*/
    private String gameTitle;
    /** Tekst w przycisku START*/
    private String buttonStartText;
    /** Tekst w przycisku RANKING*/
    private String buttonRankText;
    /** Tekst w przycisku SETTINGS*/
    private String buttonSettingsText;
    /** Tekst w przycisku INFO*/
    private String buttonInfoText;
    /** Tekst w przycisku EXIT*/
    private String buttonEndText;
    /** Tekst w przycisku BACK TO MENU*/
    private String buttonBackToMenuText;
    /** Tekst w przycisku ACCEPT*/
    private String buttonAcceptText;
    /** Tekst w przycisku PAUSE*/
    private String buttonPauseText;
    /** Tekst w przycisku PLAY AGAIN*/
    private String buttonPlayAgainText;
    /** Tekst w przycisku GAME OVER*/
    private String gameOverText;
    /** Tekst w przycisku NICK*/
    private String nickText;
    /** Instrukcja gry*/
    private String pathInfo;
    //pathRank;
    //private String Settings;
    /** zmienna określająca domyślną ilość punktów*/
    private int initialPoints;
    /** zmienna określająca liczbę zdobytych punktów*/
    private int labelPoints;
    /** zmienna określająca liczbę pozostałych graczowi żyć*/
    private int labelLifesLeft;
    /** zmienna określająca ilość FPS*/
    private int fps;
    /** zmienna określająca liczbę żyć przeciników*/
    private int enemyLifes;
    /** zmienna określająca ilość punktów za zabicie przeciwnika czerwonego*/
    private int enemyRedPoints;
    /** zmienna określająca ilość punktów za zabicie przeciwnika niebieskiego*/
    private int enemyBluePoints;
    /** zmienna określająca ilość punktów za zabicie przeciwnika zielonego*/
    private int enemyGreenPoints;
    /** zmienna określająca ilość punktów za zabicie przeciwnika zółtego*/
    private int enemyYellowPoints;
    /** zmienna określająca szybkość lotu pocisku czerwonego przeciwnika*/
    private int enemyRedBulletSpeed;
    /** zmienna określająca szybkość lotu pocisku niebieskiego przeciwnika*/
    private int enemyBlueBulletSpeed;
    /** zmienna określająca szybkość lotu pocisku zielonego przeciwnika*/
    private int enemyGreenBulletSpeed;
    /** zmienna określająca szybkość lotu pocisku żółtego przeciwnika*/
    private int enemyYellowBulletSpeed;
    /** zmienna określająca położenie działa w osi X*/
    private int playerXScreenPosition;
    /** zmienna określająca położenie działa w osi Y*/
    private int playerYScreenPosition;





    Properties proper = new Properties();
    /** Metoda wczytująca dane z pliku konfiguracyjnego */
    public Configer(String pathToMainConfiguration) throws IOException {
        InputStream propertiesFile = new FileInputStream(pathToMainConfiguration);
        proper.load(propertiesFile);

        gameHeight = Integer.parseInt(proper.getProperty("gameHeight"));
        gameWidth = Integer.parseInt(proper.getProperty("gameWidth"));
        maxHighScoreSize = Integer.parseInt(proper.getProperty("maxHighScoreSize"));
        gameTitle = proper.getProperty("gameTitle");
        buttonStartText=proper.getProperty("buttonStartText");
        buttonRankText=proper.getProperty("buttonRankText");
        buttonSettingsText=proper.getProperty("buttonSettingsText");
        buttonInfoText=proper.getProperty("buttonInfoText");
        buttonEndText=proper.getProperty("buttonEndText");
        buttonBackToMenuText=proper.getProperty("buttonBackToMenuText");
        buttonAcceptText=proper.getProperty("buttonAcceptText");
        buttonPauseText=proper.getProperty("buttonPauseText");
        buttonPlayAgainText=proper.getProperty("buttonPlayAgainText");
        gameOverText=proper.getProperty("gameOverText");
        nickText=proper.getProperty("nickText");
        pathInfo=proper.getProperty("pathInfo");
        //Settings
        initialPoints=Integer.parseInt(proper.getProperty("initialPoints"));
        labelPoints=Integer.parseInt(proper.getProperty("labelPoints"));
        labelLifesLeft=Integer.parseInt(proper.getProperty("labelLifesLeft"));
        fps=Integer.parseInt(proper.getProperty("fps"));
        enemyLifes=Integer.parseInt(proper.getProperty("enemyLifes"));
        enemyRedPoints=Integer.parseInt(proper.getProperty("enemyRedPoints"));
        enemyBluePoints=Integer.parseInt(proper.getProperty("enemyBluePoints"));
        enemyGreenPoints=Integer.parseInt(proper.getProperty("enemyGreenPoints"));
        enemyYellowPoints=Integer.parseInt(proper.getProperty("enemyYellowPoints"));
        enemyRedBulletSpeed=Integer.parseInt(proper.getProperty("enemyRedBulletSpeed"));
        enemyBlueBulletSpeed=Integer.parseInt(proper.getProperty("enemyBlueBulletSpeed"));
        enemyGreenBulletSpeed=Integer.parseInt(proper.getProperty("enemyGreenBulletSpeed"));
        enemyYellowBulletSpeed=Integer.parseInt(proper.getProperty("enemyYellowBulletSpeed"));
        playerXScreenPosition=Integer.parseInt(proper.getProperty("playerXScreenPosition"));
        playerYScreenPosition=Integer.parseInt(proper.getProperty("playerYScreenPosition"));


        propertiesFile.close();
    }
    /** Metoda zwracająca gameHeight */
    public int getGameHeight() {
        return gameHeight;
    }
    /** Metoda zwracająca gameWidth */
    public int getGameWidth() {
        return gameWidth;
    }
    /** Metoda zwracająca maxHighScoreSize */
    public int getMaxHighScoreSize() {
        return maxHighScoreSize;
    }
    /** Metoda zwracająca gameTitle */
    public String getGameTitle() {
        return gameTitle;
    }
    /** Metoda zwracająca buttonStartText */
    public String getButtonStartText() {
        return buttonStartText;
    }
    /** Metoda zwracająca buttonRankText */
    public String getButtonRankText() {
        return buttonRankText;
    }
    /** Metoda zwracająca buttonSettingsText */
    public String getButtonSettingsText() {
        return  buttonSettingsText;
    }
    /** Metoda zwracająca buttonInfoText */
    public String getButtonInfoText() {
        return buttonInfoText;
    }
    /** Metoda zwracająca buttonEndText */
    public String getButtonEndText() {
        return buttonEndText;
    }
    /** Metoda zwracająca buttonBackToMenuText */
    public String getButtonBackToMenuText() {
        return buttonBackToMenuText;
    }
    /** Metoda zwracająca buttonAcceptText */
    public String getButtonAcceptText() {
        return buttonAcceptText;
    }
    /** Metoda zwracająca buttonPauseText */
    public String getButtonPauseText() {
        return buttonPauseText;
    }
    /** Metoda zwracająca buttonPlayAgainText */
    public String getButtonPlayAgainText() {
        return buttonPlayAgainText;
    }
    /** Metoda zwracająca gameOverText */
    public String getGameOverText() {
        return gameOverText;
    }
    /** Metoda zwracająca nickText */
    public String getNickText() {
        return nickText;
    }
    /** Metoda zwracająca pathInfo */
    public String getPathInfo() {
        return pathInfo;
    }

    //pathSettings=
    /** Metoda zwracająca initialPoints */
    public int getInitialPoints() {
        return initialPoints;
    }
    /** Metoda zwracająca labelPoints */
    public int getLabelPoints() {
        return labelPoints;
    }
    /** Metoda zwracająca labelLifesLeft */
    public int getLabelLifesLeft() {
        return labelLifesLeft;
    }
    /** Metoda zwracająca fps */
    public int getFps() {
        return fps;
    }
    /** Metoda zwracająca enemyLifes */
    public int getEnemyLifes() {
        return enemyLifes;
    }
    /** Metoda zwracająca enemyRedPoints */
    public int getEnemyRedPoints() {
        return enemyRedPoints;
    }
    /** Metoda zwracająca enemyBluePoints */
    public int getEnemyBluePoints() {
        return enemyBluePoints;
    }
    /** Metoda zwracająca enemyGreenPoints */
    public int getEnemyGreenPoints() {
        return enemyGreenPoints;
    }
    /** Metoda zwracająca enemyYellowPoints */
    public int getEnemyYellowPoints() {
        return enemyYellowPoints;
    }
    /** Metoda zwracająca enemyRedBulletSpeed */
    public int getEnemyRedBulletSpeed() {
        return enemyRedBulletSpeed;
    }
    /** Metoda zwracająca blueBulletSpeed */
    public int getEnemyBlueBulletSpeed() {
        return enemyBlueBulletSpeed;
    }
    /** Metoda zwracająca enemyGreenBulletSpeed */
    public int getEnemyGreenBulletSpeed() {
        return enemyGreenBulletSpeed;
    }
    /** Metoda zwracająca enemyYellowBulletSpeed */
    public int getEnemyYellowBulletSpeed() {
        return enemyYellowBulletSpeed;
    }
    /** Metoda zwracająca playerXScreenPosition */
    public int getPlayerXScreenPosition() {
        return playerXScreenPosition;
    }
    /** Metoda zwracająca playerYScreenPosition */
    public int getPlayerYScreenPosition() {
        return playerYScreenPosition;
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
