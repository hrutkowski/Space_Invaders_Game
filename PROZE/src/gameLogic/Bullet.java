package gameLogic;

import java.awt.*;

public class Bullet extends MovingObject{ // Jeszcze nie wiem co będzie go różniło od Character
    private final Color color;

    public Bullet(float x, float y, float width, float height, Color color){
        super(x, y, width, height, color);
        this.color = color;
    }
}
