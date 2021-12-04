package gameLogic;

import java.util.Objects;

/** Klasa reprezentująca gracza */
public class Player implements Comparable<Player> {
    /** Nick gracza */
    private String nick;
    /** Ilośc punktów gracza */
    private int points;

    /** Konstruktor klasy Gracz z wstępną inicjalizacją nicku i ilości punktów */
    public Player(String nick, int points) {
        this.nick = nick;
        this.points = points;
    }
    /** Metoda zwracająca nick */
    public String getNick() {
        return nick;
    }
    /** Metoda zwracająca points */
    public int getPoints() {
        return points;
    }
    /** Metoda ustawiająca points */
    public void setPoints(int points) {
        this.points = points;
    }

   /**  Nadpisana metoda equals */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return points == player.points && Objects.equals(nick, player.nick);
    }
    /** Metoda hashująca */
    @Override
    public int hashCode() {
        return Objects.hash(nick, points);
    }
    /** Metoda ułatwiająca wyświeltenie atrybutów gracza */
    public String toString() {
        return "[" + getClass().getSimpleName() + ":" + nick + ":" + points + "]";
    }
    /** Metoda porównująca ilości punktów */
    @Override
    public int compareTo(Player o) {
        return o.points - points;
    }
}
