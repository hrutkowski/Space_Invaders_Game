package gameLogic;

import gameLogic.Enemy;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/** Klasa obiektow do zarzadzania na plotnie */
public class GameObjectList extends ArrayList<Enemy> {
// tutaj trzymamy wrogow i bedziemy ich usuwali
    /** Konstruktor klasy GameObjectList */
    public GameObjectList(){}
    /** Metoda usuwająca obiekt z listy */
    public void removeObject(Iterator<Enemy> iter) //Ja pisałem, może być źle
    {
        remove(iter);
    }
}
