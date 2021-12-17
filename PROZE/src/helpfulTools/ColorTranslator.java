package helpfulTools;

import java.awt.*;

public class ColorTranslator {

    public  ColorTranslator(){}

    public Color translateColor(String color)
    {
        return switch (color) {
            case "red" -> Color.red;
            case "blue" -> Color.blue;
            case "green" -> Color.green;
            case "pink" -> Color.pink;
            case "yellow" -> Color.yellow;
            case "black" -> Color.black;
            default -> null;
        };
    }


}
