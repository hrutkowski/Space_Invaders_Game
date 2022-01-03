package configuration;

/** Klasa pomocnicza do zmian poziomu */
public class LevelHelper {
    /** Atrybut posiadajacy numer boecnego poziomu */
    int level;

    /** Konstruktor klasy LevelHelper */
    public LevelHelper() {
        level=0;
    }
    /** Metoda zwracajaca sciezke do poziomu */
    public String getLevelPath(Configer configer) {
        return switch (level) {
            case 2 -> configer.getPathLevel2();
            case 3 -> configer.getPathLevel3();
            default -> configer.getPathLevel1();
        };
    }
    /** Metoda zwracajaca numer obecnego poziomu */
    public int getLevel() { return level; }
    /** metoda zwiekszajaca numer pziomu */
    public void nextLevel() { level += 1; }
}
