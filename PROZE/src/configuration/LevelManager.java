package configuration;

/** Klasa pomocnicza do zmian poziomu */
public class LevelManager {
    /** Atrybut posiadajacy numer aktualnego poziomu */
    int level;

    /** Konstruktor klasy LevelManager */
    public LevelManager() {
        level = 1;
    }
    /** Metoda zwracajaca sciezke do poziomu */
    public String getLevelPath(Configer configer) {
        System.out.println(level);
        return switch (level) {
            case 2 -> configer.getPathLevel2();
            case 3 -> configer.getPathLevel3();
            default -> configer.getPathLevel1();
        };
    }
    /** Metoda zwracajaca numer obecnego poziomu */
    public int getLevel() { return level; }
    /** Metoda zwiekszajaca numer poziomu */
    public void nextLevel() { level += 1; }
    /** Metoda zeruje poziom */
    public void resetLevel() { level = 1; }
}
