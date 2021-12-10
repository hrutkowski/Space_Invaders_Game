package configuration;

import gameLogic.Player;

import java.io.*;
import java.util.*;

/** Klasa odpowiadająca za zarządzaniem tablicą wyników */
public class HighScoreManager {

    private String outputPath;
    private Properties properties = new Properties();
    List<Player> highScoreTable = new Vector<>();
/** Konstruktor tworzący listę obiektów typu Player na podstawie pliku HighScore.txt */
    HighScoreManager(String pathHighScores) {
        try (FileReader fr = new FileReader(pathHighScores)) {
            properties.load(fr);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

         for (int i = 0; i < Integer.parseInt(properties.getProperty("liczba_nickow")); i++) {
            String nick = properties.getProperty("nick_" + i);
            int points = Integer.parseInt(properties.getProperty("wynik_" + i));
            highScoreTable.add(new Player(nick, points));
        }
         System.out.println(highScoreTable);
         Collections.sort(highScoreTable);
         System.out.println(highScoreTable);
    }
/** Metoda dodająca obiekt Player do listy wewnątrz Managera */
    private void addPlayer(Player plr) {
        highScoreTable.add(plr);
    }
/** Metoda zapisujaca biezaca liste mistrzow w pliku txt */
     private void saveScores() throws IOException {

        Properties playersProperties = new Properties();
        String filename = "./src/HighScores.txt";

        Collections.sort(highScoreTable);
        playersProperties.setProperty("liczba_nickow", properties.getProperty("liczba_nickow"));
        for(int i=0; i<Integer.parseInt(properties.getProperty("liczba_nickow")); i++)
        {
            playersProperties.setProperty("nick_" + i, highScoreTable.get(i).getNick());
            String temp_points = Integer.toString(highScoreTable.get(i).getPoints());
            playersProperties.setProperty("wynik_" + i, temp_points);
        }
        playersProperties.store(new FileOutputStream(filename), null);
    }
/** Metoda testujaca dzialanie klasy */
    public static void main(String... args) throws IOException {
        HighScoreManager Manager1 = new HighScoreManager("./src/HighScores.txt");
        Player a = new Player("tobiasz",800); // tu można sobie dodawać i się bawić
        Manager1.addPlayer(a);
        Manager1.saveScores();
    }

}