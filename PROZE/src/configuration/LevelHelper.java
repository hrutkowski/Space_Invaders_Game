package configuration;

public class LevelHelper {

    int level;

    public LevelHelper() {
        level=0;
    }

    public String getLevelPath(Configer configer) {
        return switch (level) {
            case 2 -> configer.getPathLevel2();
            case 3 -> configer.getPathLevel3();
            default -> configer.getPathLevel1();
        };
    }
    public int getLevel() { return level; }
    public void nextLevel() { level += 1; }
}
