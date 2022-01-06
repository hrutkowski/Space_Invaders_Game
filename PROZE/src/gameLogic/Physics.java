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
        this.player = game.getMenuFrame().getLoginFrame().getPlayer();
        this.leveler = game.getLeveler();
    }
    /** Metoda dotyczaca kolizji pocisku Cannona z Enemy*/
    public void collisionEnemy(GameObjectList gameEnemyList, GameObjectList gameCannonBulletList) {
        for (MovingObject enemy : gameEnemyList) {
            gameCannonBulletList.stream().filter(bullet -> bullet.getBounds().intersects(enemy.getBounds())).forEach(bullet -> {
                enemy.kill();
                player.setPoints(player.getPoints() + leveler.getEnemyPoints());
            });
            gameCannonBulletList.removeIf(bullet -> (bullet.getBounds().intersects(enemy.getBounds())));
        }
        gameEnemyList.removeIf(MovingObject::isKilled);
    }
    /** Metoda dotyczaca kolizji pocisku Enemy z Cannonem */
    public void collisionCannon(Cannon cannon, GameObjectList gameEnemyBulletList) {
        gameEnemyBulletList.stream().filter(bullet -> bullet.getBounds().intersects(cannon.getBounds())).forEach(bullet -> cannon.hit());
        gameEnemyBulletList.removeIf( bullet -> ( bullet.getBounds().intersects(cannon.getBounds())) );
    }
    /** Metoda dotyczaca kolizji Enemy z Cannonem */
    public void collisionEnemyHitCannon(Cannon cannon, GameObjectList gameEnemyList) {
        for (MovingObject enemy : gameEnemyList) {
            if (enemy.getBounds().intersects(cannon.getBounds())) {
                cannon.hit();
                enemy.kill();
            }
        }
        gameEnemyList.removeIf(MovingObject::isKilled);
    }
    /** Metoda dotyczaca dolecenia Enemy do dolu ekranu */
    public void downWallEnemy(Cannon cannon, GameObjectList gameEnemyList) {
        gameEnemyList.stream().filter(enemy -> enemy.getY() >= 0.95f).forEach(enemy -> {
            cannon.hit();
            enemy.kill();
        });
    }

}
