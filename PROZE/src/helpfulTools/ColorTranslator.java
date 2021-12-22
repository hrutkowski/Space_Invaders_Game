package helpfulTools;

import java.awt.*;

/** Klasa pomocnicza do zamiany nazwy koloru na obiekt klasy Color */
public class ColorTranslator {

    /** Konstruktor klasy ColorTranslator */
    public  ColorTranslator(){}
    /** Metoda do zamiany nazwy koloru na obiekty klasy Color */
    public Color translateColor(String color)
    {
        return switch (color) {
            case "red" -> Color.red;
            case "blue" -> Color.blue;
            case "green" -> Color.green;
            case "pink" -> Color.pink;
            case "yellow" -> Color.yellow;
            case "gray" -> Color.gray;
            default -> Color.black;
        };
    }
}
