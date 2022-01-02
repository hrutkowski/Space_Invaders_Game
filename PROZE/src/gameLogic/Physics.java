package gameLogic;

import configuration.Leveler;
import spaceInvaders.Game;

public class Physics {

    private final Player player;
    private final Leveler leveler;

    public Physics(Game game){
        this.player = game.getPlayer();
        this.leveler = game.getLeveler();
    }
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
