package configuration;

import gameLogic.Player;

import java.io.*;
import java.util.*;

/** Klasa odpowiadająca za zarządzaniem tablicą wyników */
public class HighScoreManager {

    /** Atrybut klasy properties */
    final private Properties properties = new Properties();
    /** Atrybut listy graczy */
    List<Player> highScoreTable = new Vector<>();
    /** Atrybut typu String przechowujący ścieżkę do pliku txt */
    final private String path;

    /** Konstruktor tworzący listę obiektów typu Player na podstawie pliku HighScore.txt */
    public HighScoreManager(String pathHighScores) {
        path = pathHighScores;
        try (FileReader fr = new FileReader(path)) { properties.load(fr); }
        catch (IOException ioe) { ioe.printStackTrace(); }
        for (int i = 0; i < Integer.parseInt(properties.getProperty("liczba_nickow")); i++) {
            String nick = properties.getProperty("nick_" + i);
            int points = Integer.parseInt(properties.getProperty("wynik_" + i));
            highScoreTable.add(new Player(nick, points));
        }
         Collections.sort(highScoreTable);
    }
    /** Metoda dodająca obiekt Player do listy wewnątrz Managera */
    public void addPlayer(Player plr) { highScoreTable.add(plr); }
    /** Metoda zapisujaca biezaca liste mistrzow w pliku txt */
    public void saveScores() throws IOException {
        Properties playersProperties = new Properties();
        Collections.sort(highScoreTable);
        playersProperties.setProperty("liczba_nickow", properties.getProperty("liczba_nickow"));
        for(int i=0; i<Integer.parseInt(properties.getProperty("liczba_nickow")); i++) {
            playersProperties.setProperty("nick_" + i, highScoreTable.get(i).getNick());
            String temp_points = Integer.toString(highScoreTable.get(i).getPoints());
            playersProperties.setProperty("wynik_" + i, temp_points);
        }
        playersProperties.store(new FileOutputStream(path), null);
    }
    /** Metoda odpowiadajaca za przekazywanie rankingu do wyświetlenia */
    public String showHighScore() {
        String textHighScore="";
        for (int i = 0; i < Integer.parseInt(properties.getProperty("liczba_nickow")); i++) {
        textHighScore += i+1 + ". " + highScoreTable.get(i).getNick() + " = " + highScoreTable.get(i).getPoints() + " points" +"\n";
        }
        return textHighScore;
    }
}