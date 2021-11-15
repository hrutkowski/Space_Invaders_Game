package configuration;

import javax.imageio.metadata.IIOMetadataNode;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** Klasa odpowiedzialna za wczytywanie danych z pliku konfiguracyjnego i zapisywanie zmiennych uaktualnianych  trakcie
 * gry w pliku konfiguracyjnym
 */

public class Configer {
    /** Okresla startową wysokość okna gry*/
    private int gameHeight;
    /** Okresla startową szerokość okna gry*/
    private int gameWidth;
    /** Okresla maksymalną liczbę najwyższych wyników zapisywanych w Rankingu*/
    private int maxHighScoreSize;
    /** Tytuł gry*/
    private String gameTitle;
    /** tekst w przycisku START*/
    private String buttonStartText;
    /** tekst w przycisku RANKING*/
    private String buttonRankText;
    /** tekst w przycisku SETTINGS*/
    private String buttonSettingsText;
    /** tekst w przycisku INFO*/
    private String buttonInfoText;
    /** tekst w przycisku EXIT*/
    private String buttonEndText;
    /** tekst w przycisku BACK TO MENU*/
    private String buttonBackToMenuText;
    /** tekst w przycisku ACCEPT*/
    private String buttonAcceptText;
    /** tekst w przycisku PAUSE*/
    private String buttonPauseText;
    /** tekst w przycisku PLAY AGAIN*/
    private String buttonPlayAgainText;
    /** tekst w przycisku GAME OVER*/
    private String gameOverText;
    /** tekst w przycisku NICK*/
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
    /**
     *metoda wczytująca dane z pliku konfiguracyjnego i zapisująca je do odpowiednich pól w klasie
     */
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

    public int getGameHeight() {
        return gameHeight;
    }

    public int getGameWidth() {
        return gameWidth;
    }

    public int getMaxHighScoreSize() {
        return maxHighScoreSize;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public String getButtonStartText() {
        return buttonStartText;
    }

    public String getButtonRankText() {
        return buttonRankText;
    }

    public String getButtonSettingsText() {
        return  buttonSettingsText;
    }

    public String getButtonInfoText() {
        return buttonInfoText;
    }

    public String getButtonEndText() {
        return buttonEndText;
    }

    public String getButtonBackToMenuText() {
        return buttonBackToMenuText;
    }

    public String getButtonAcceptText() {
        return buttonAcceptText;
    }

    public String getButtonPauseText() {
        return buttonPauseText;
    }

    public String getButtonPlayAgainText() {
        return buttonPlayAgainText;
    }

    public String getGameOverText() {
        return gameOverText;
    }

    public String getNickText() {
        return nickText;
    }

    public String getPathInfo() {
        return pathInfo;
    }

    //pathSettings=

    public int getInitialPoints() {
        return initialPoints;
    }

    public int getLabelPoints() {
        return labelPoints;
    }

    public int getLabelLifesLeft() {
        return labelLifesLeft;
    }

    public int getFps() {
        return fps;
    }

    public int getEnemyLifes() {
        return enemyLifes;
    }

    public int getEnemyRedPoints() {
        return enemyRedPoints;
    }

    public int getEnemyBluePoints() {
        return enemyBluePoints;
    }

    public int getEnemyGreenPoints() {
        return enemyGreenPoints;
    }

    public int getEnemyYellowPoints() {
        return enemyYellowPoints;
    }

    public int getEnemyRedBulletSpeed() {
        return enemyRedBulletSpeed;
    }

    public int getEnemyBlueBulletSpeed() {
        return enemyBlueBulletSpeed;
    }

    public int getEnemyGreenBulletSpeed() {
        return enemyGreenBulletSpeed;
    }

    public int getEnemyYellowBulletSpeed() {
        return enemyYellowBulletSpeed;
    }

    public int getPlayerXScreenPosition() {
        return playerXScreenPosition;
    }

    public int getPlayerYScreenPosition() {
        return playerYScreenPosition;
    }



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
