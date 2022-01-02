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
    public void collisionEnemy(GameObjectList gameEnemyList, GameObjectList gameCannonBulletList){
        for(MovingObject enemy : gameEnemyList) {
            for (MovingObject bullet : gameCannonBulletList) {
                if (bullet.getBounds().intersects(enemy.getBounds())) {
                    enemy.kill();
                    player.setPoints(player.getPoints() + leveler.getEnemyPoints());
                }
            }
            gameCannonBulletList.removeIf( bullet -> ( bullet.getBounds().intersects(enemy.getBounds())) );
        }
        gameEnemyList.removeIf(MovingObject::isKilled);
    }
    public void collisionCannon(Cannon cannon, GameObjectList gameEnemyBulletList){
        for (MovingObject bullet : gameEnemyBulletList) {
            if (bullet.getBounds().intersects(cannon.getBounds())) {
                cannon.hit();
            }
        }
        gameEnemyBulletList.removeIf( bullet -> ( bullet.getBounds().intersects(cannon.getBounds())) );
    }
}
