package gameLogic;

import java.util.Objects;


public class Player implements Comparable<Player> {

    private String nick;
    private int points;

    public Player(String nick, int points) {
        this.nick = nick;
        this.points = points;
    }

    public String getNick() {
        return nick;
    }

    public int getPoints() {
        return points;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return points == player.points && Objects.equals(nick, player.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, points);
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + ":" + nick + ":" + points + "]";
    }

    @Override
    public int compareTo(Player o) {
        return o.points - points;
    }
}
