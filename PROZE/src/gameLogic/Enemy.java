package gameLogic;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import configuration.Configer;
import configuration.Leveler;

public class Enemy extends Character {

    /**
     * Zmienna opisujaca przeciwnika jako prostokat
     */
    private Rectangle enemyRect;
    /**
     * Zmienna okreslajaca typ klocka
     */
    private typeOfEnemy enemyType;
    /**
     * Znormalizowana szerokosc klocka
     */

    private double normalizedEnemyWidth;

    /**
     * Znormalizowana wysokosc klocka
     */

    private double normalizedEnemyHeight;

    /**
     * znormalizowana pozycja X klocka
     */

    private double normalizedXPosition;

    /**
     * Znormalizowana pozycja Y klocka
     */

    private double normalizedYPosition;

    /**
     * Wysokosc ekranu
     */

    private int screenHeight;

    /**
     * Szerokosc ekranu
     */

    private int screenWidth;

    private Color color;
    private int life;
    private int points;

    /**
     * Zmienna wyliczeniwa opisujaca mozliwe typy przeciwnikow
     */
    public enum typeOfEnemy {
        RED(Configer.getEnemyLifes(), Configer.getEnemyRedPoints(), Color.red),
        GREEN(Configer.getEnemyLifes(), Configer.getEnemyGreenPoints(), Color.green),
        BLUE(Configer.getEnemyLifes(), Configer.getEnemyBluePoints(), Color.blue),
        YELLOW(Configer.getEnemyLifes(), Configer.getEnemyYellowPoints(), Color.yellow),
        DEAD(Configer.getEnemyLifes(), Configer.getEnemyDeadPoints(), Color.white);

        private int life;
        private int points;
        private Color color;

        typeOfEnemy(int life, int points, Color color) {
            this.life = life;
            this.points = points;
            this.color = color;
        }
    }

    /**
     * Pobranie koloru przeciwnika
     * @return kolor przeciwnika
     */

    public Color getColor() {
        return color;
    }

    /**
     * Pobraniie puntktow za zbicie przeciwnika
     * @return punkty za przeciwnika
     */

    public int getPoints() {
        return points;
    }

    /**
     * Metoda sprawdzajaca czy przeciwnik ma jeszcze zycia
     *
     * @return Zwraca informacje czy przeciwnik zyje czy nie zyje
     */
    public boolean isDead() {
        if (enemyType != typeOfEnemy.DEAD)
            return false;
        else
            return true;
    }

    /**
     * Metoda zwracajaca prostokat opisujacy przeciwnika
     *
     * @return Zwraca prostokat reprezentujacy przeciwnika
     */
    public Rectangle getRect() {
        return enemyRect;
    }

    /**
     * Konstruktor klasy Enemy sluzacy do tworzenia obiektow
     *
     * @param x      polozenie przecwnika w plaszczyznie x
     * @param y      polozenie przecwnika w plaszczyznie y
     * @param width  szerokosc przeciwnika
     * @param height wysokosc przeciwnika
     * @param type   reprezentacja typu przecinwika w liczbach calkowitych
     * @param screenWidth szerokosc ekranu
     * @param screenHeight wysokosc ekranu
     */

    public Enemy(double x, double y, double width, double height, int type, int screenWidth, int screenHeight, int speed) {
        super(speed);
        speed=Configer.getEnemyMovementSpeed();
        this.screenHeight=screenHeight;
        this.screenWidth=screenWidth;
        normalizedXPosition = 1.0 * x;
        normalizedYPosition = 1.0 * y;
        normalizedEnemyWidth = 1.0 * width;
        normalizedEnemyHeight = 1.0 * height;
        enemyType = getTypeOfEnemy(type);
        enemyRect = new Rectangle((int) Math.round(normalizedXPosition * screenWidth), (int) Math.round(normalizedYPosition * screenHeight), (int) Math.round(normalizedEnemyWidth * screenWidth), (int) Math.round(normalizedEnemyHeight * screenHeight));
    }

    /**
     * Metoda zamieniajaca reprezentacje przeciwnika w typie int na typ wyliczeniowy
     *
     * @param number numer reprezentujacy typ przdeciwnika
     * @return Zwraca typ przeciwnika
     */
    public typeOfEnemy getTypeOfEnemy(int number) {
        switch (number) {
            case 4:
                return typeOfEnemy.RED;
            case 3:
                return typeOfEnemy.GREEN;
            case 2:
                return typeOfEnemy.BLUE;
            case 1:
                return typeOfEnemy.YELLOW;
            case 0:
                return typeOfEnemy.DEAD;
            default:
                return typeOfEnemy.DEAD;
        }
    }

    /**
     * Metoda zwracajaca typ przeciwnika
     *
     * @return Zwraca typ klocka
     */
    public typeOfEnemy getBrickType() {
        return enemyType;
    }

    /**
     * Metoda do zmiany rozmiaru klocka
     * @param screenWidth   szerokosc planszy
     * @param screenHeight  wysokosc planszy
     */

    public void resize(int screenWidth, int screenHeight) {
        this.screenWidth=screenWidth;
        this.screenHeight=screenHeight;
        enemyRect.setLocation((int) Math.round(normalizedXPosition * screenWidth), (int) Math.round(normalizedYPosition * screenHeight));
        enemyRect.setSize((int) Math.round(normalizedEnemyWidth * screenWidth), (int) Math.round(normalizedEnemyHeight * screenHeight));
    }

}
