package configuration;

import gameLogic.Player;

import java.io.*;
import java.util.Properties;
import java.util.SortedSet;
import java.util.TreeSet;


public class Saver {


    private Properties properties = new Properties();
    SortedSet<Player> highScoreTable = new TreeSet<>();

    Saver(String pathToBestResultFile) {
        try (FileReader fr = new FileReader(pathToBestResultFile)) {
            properties.load(fr);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("properties=[" + properties + "]");
        String tmp = properties.getProperty("liczba_nickow");

        int N = Integer.parseInt(tmp);
        for (int i = 1; i <= N; i++) {
            String nick = properties.getProperty("nick_" + i);
            int points = Integer.parseInt(properties.getProperty("wynik_" + i));
            highScoreTable.add(new Player(nick, points));
        }
        System.out.println(highScoreTable);
    }

    private static String pathPlayer = "./Hello/src/Players.txt";

    public static void main(String... args) {
        Saver s = new Saver(pathPlayer);
        System.out.println(s);
    }

    public String toString() {
        return "[props=" + properties + System.lineSeparator() +
                "highScoreTable=" + highScoreTable + "]";
    }

    public void savePlayer(Player plr) throws IOException {
        highScoreTable.add(plr);
        if (highScoreTable.size() > )

        Properties playersProperties = new Properties();

        playersProperties.setProperty(plr.giveNick(), Double.toString(plr.givePoints()));

        File outPathPlayer = new File(pathPlayer);
        OutputStream os = new FileOutputStream(outPathPlayer);

        playersProperties.store(os, null);
    }
}