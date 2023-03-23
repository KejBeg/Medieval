
package medieval;
import java.util.ArrayList;

public class FightManager {
    /**
     * Lets Enemy and Character fight
     * @param ch
     */
    public static void fight(Character ch){ // Static means I don't have to create an object
        for(Enemy e : ch.getCurrentLocation().getEnemies()){
            while(!ch.isDead() && !e.isDead()) {
                ch.attack(e);
                e.attack(ch);

            }
        }
    }
}
