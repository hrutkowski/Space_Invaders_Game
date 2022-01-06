package configuration;

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
        propertiesFile.close();
    }
    /** Metoda zwracająca gameHeight */
    public int getGameHeight() { return Integer.parseInt(proper.getProperty("gameHeight")); }
    /** Metoda zwracająca gameWidth */
    public int getGameWidth() { return Integer.parseInt(proper.getProperty("gameWidth")); }
    /** Metoda zwracająca gameTitle */
    public String getGameTitle() { return proper.getProperty("gameTitle"); }
    /** Metoda zwracająca buttonStartText */
    public String getButtonStartText() { return proper.getProperty("buttonStartText"); }
    /** Metoda zwracająca buttonRankText */
    public String getButtonRankText() { return proper.getProperty("buttonRankText"); }
    /** Metoda zwracająca buttonSettingsText */
    public String getButtonSettingsText() {
        return proper.getProperty("buttonSettingsText");
    }
    /** Metoda zwracająca buttonInfoText */
    public String getButtonInfoText() {
        return proper.getProperty("buttonInfoText");
    }
    /** Metoda zwracająca buttonEndText */
    public String getButtonEndText() {
        return proper.getProperty("buttonEndText");
    }
    /** Metoda zwracająca quitDialogTitle */
    public String getQuitDialogTitle() {
        return proper.getProperty("quitDialogTitle");
    }
    /** Metoda zwracająca quitDialogText */
    public String getQuitDialogText() {
        return proper.getProperty("quitDialogText");
    }
    /** Metoda zwracająca quitDialogYes */
    public  String getQuitDialogYes() {
        return proper.getProperty("quitDialogYes");
    }
    /** Metoda zwracająca quitDialogNo */
    public String getQuitDialogNo() {
        return proper.getProperty("quitDialogNo");
    }
    /** Metoda zwracająca buttonPauseText */
    public String getButtonPauseText() {
        return proper.getProperty("buttonPauseText");
    }
    /** Metoda zwracająca gameOverText */
    public String getGameOverText() {
        return proper.getProperty("gameOverText");
    }
    /** Metoda zwracająca congratulationsText */
    public String getCongratulationsText() {
        return proper.getProperty("congratulationsText");
    }
    /** Metoda zwracająca playerFinalPointsText */
    public String getPlayerFinalPointsText() {
        return proper.getProperty("playerFinalPointsText");
    }
    /** Metoda zwracająca initialPoints */
    public int getInitialPoints() {
        return Integer.parseInt(proper.getProperty("initialPoints"));
    }
    /** Metoda zwracająca initialLives */
    public int getInitialLives() {
        return Integer.parseInt(proper.getProperty("initialLives"));
    }
    /** Metoda zwracająca initialLevel */
    public int getInitialLevel() { return Integer.parseInt(proper.getProperty("initialLevel")); }
    /** Metoda zwracająca labelPoints */
    public String getLabelPoints() { return (proper.getProperty("labelPoints")); }
    /** Metoda zwracająca labelColorCannon */
    public String getLabelColorCannon() { return (proper.getProperty("labelColorCannon")); }
    /** Metoda zwracająca labelLifesLeft */
    public String getLabelLivesLeft() {
        return (proper.getProperty("labelLivesLeft"));
    }
    /** Metoda zwracająca fps */
    public int getFps() {
        return Integer.parseInt(proper.getProperty("fps"));
    }
    /** Metoda zwracająca enemyLifes */
    public int getEnemyLives() { return Integer.parseInt(proper.getProperty("enemyLives")); }
    /** Metoda zwracająca cannonLifes */
    public int getCannonLives() { return Integer.parseInt(proper.getProperty("cannonLives")); }
     /** Metoda zwracająca cannonXScreenPosition */
    public float getCannonXScreenPosition() {return Float.parseFloat(proper.getProperty("cannonXScreenPosition")); }
    /** Metoda zwracająca cannonYScreenPosition */
    public float getCannonYScreenPosition() {return Float.parseFloat(proper.getProperty("cannonYScreenPosition")); }
    /** Metoda zwracająca pathHighScores */
    public String getPathHighScores() {return proper.getProperty("pathHighScores"); }
    /** Metoda zwracająca colorCannon */
    public String getColorCannon() { return proper.getProperty("colorCannon"); }
    /** Metoda zwracająca cannonWidth */
    public float getCannonWidth() { return Float.parseFloat(proper.getProperty("cannonWidth"));}
    /** Metoda zwracająca cannonHeight */
    public float getCannonHeight() { return Float.parseFloat(proper.getProperty("cannonHeight"));}
    /** Metoda zwracająca cannonWidth */
    public float getEnemyWidth() { return Float.parseFloat(proper.getProperty("enemyWidth"));}
    /** Metoda zwracająca cannonHeight */
    public float getEnemyHeight() { return Float.parseFloat(proper.getProperty("enemyHeight")); }
    /** Metoda zwracająca bulletWidth */
    public float getBulletWidth() { return Float.parseFloat(proper.getProperty("bulletWidth"));}
    /** Metoda zwracająca bulletHeight */
    public float getBulletHeight() { return Float.parseFloat(proper.getProperty("bulletHeight")); }
    /** Metoda zwracająca preferredScreenWidth */
    public int getPreferredScreenWidth() { return Integer.parseInt(proper.getProperty("preferredScreenWidth")); }
    /** Metoda zwracająca preferredScreenHeight */
    public int getPreferredScreenHeight() { return Integer.parseInt(proper.getProperty("preferredScreenHeight")); }
    /** Metoda zwracająca backToMenuText */
    public String getBackToMenuText() { return proper.getProperty("backToMenuText"); }
    /** Metoda zwracająca infoText */
    public String getInfoText() { return proper.getProperty("infoText"); }
    /** Metoda zwracająca infoTitle */
    public String getInfoTitle() { return proper.getProperty("infoTitle"); }
    /** Metoda zwracająca highScoreTitle */
    public String getHighScoreTitle() { return proper.getProperty("highScoreTitle"); }
    /** Metoda zwracająca settingsTitle */
    public String getSettingsTitle() { return proper.getProperty("settingsTitle"); }
    /** Metoda zwracająca menuTitle */
    public String getMenuTitle() { return proper.getProperty("menuTitle"); }
    /** Metoda zwracająca gameOverTitle */
    public String getGameOverTitle() { return proper.getProperty("gameOverTitle"); }
    /** Metoda zwracająca gameWonTitle */
    public String getGameWonTitle() { return proper.getProperty("gameWonTitle"); }
    /** Metoda zwracająca pathLevel1*/
    public String getPathLevel1() { return proper.getProperty("pathLevel1"); }
    /** Metoda zwracająca pathLevel2*/
    public String getPathLevel2() { return proper.getProperty("pathLevel2"); }
    /** Metoda zwracająca pathLevel3*/
    public String getPathLevel3() { return proper.getProperty("pathLevel3"); }
    /** Metoda zwracająca loginTitle*/
    public String getLoginTitle() { return proper.getProperty("loginTitle"); }
    /** Metoda zwracająca buttonLogin*/
    public String getButtonLogin() { return proper.getProperty("buttonLogin"); }
    /** Metoda zwracająca labelLogin*/
    public String getLabelLogin() { return proper.getProperty("labelLogin"); }
    /** Metoda zwracająca defaultNick*/
    public String getDefaultNick() { return proper.getProperty("defaultNick"); }
    /** Metoda zwracająca labelLevel*/
    public String getLabelLevel() { return proper.getProperty("labelLevel"); }
    /** Metoda zwracająca exitFrameHeight */
    public int getExitFrameHeight() { return Integer.parseInt(proper.getProperty("exitFrameHeight")); }
    /** Metoda zwracająca exitFrameWidth */
    public int getExitFrameWidth() { return Integer.parseInt(proper.getProperty("exitFrameWidth")); }
    /** Metoda zwracająca finishedGameFrameHeight */
    public int getFinishedGameFrameHeight() { return Integer.parseInt(proper.getProperty("finishedGameFrameHeight")); }
    /** Metoda zwracająca finishedGameFrameWidth */
    public int getFinishedGameFrameWidth() { return Integer.parseInt(proper.getProperty("finishedGameFrameWidth")); }
    /** Metoda zwracająca limitEnemyColumns */
    public int getLimitEnemyColumns() { return Integer.parseInt(proper.getProperty("limitEnemyColumns")); }
    /** Metoda zwracajaca numberLevels */
    public int getNumberLevels() { return Integer.parseInt(proper.getProperty("numberLevels")); }
}
