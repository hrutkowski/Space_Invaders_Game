package gameLogic;

import configuration.Leveler;
import spaceInvaders.Game;

/** Klasa odpowiedzialna za fizykę gry */
public class Physics {
    /** Atrybut klasy Player */
    private final Player player;
    /** Atrybut klasy Leveler */
    private final Leveler leveler;

    /** Konstruktor klasy Physics */
    public Physics(Game game){
        this.player = game.getPlayer();
        this.leveler = game.getLeveler();
    }
    /** Metoda dotyczaca kolizji */
    public void collision(GameObjectList gameEnemyList, GameObjectList gameBulletList){
        for(MovingObject enemy : gameEnemyList) {
            for (MovingObject bullet : gameBulletList) {
                if (bullet.getBounds().intersects(enemy.getBounds())) {
                    enemy.kill();
                    player.setPoints(player.getPoints() + leveler.getEnemyPoints());
                }
            }
            gameBulletList.removeIf( bullet -> ( bullet.getBounds().intersects(enemy.getBounds())) );
        }
        gameEnemyList.removeIf(MovingObject::isKilled);
    }
}
