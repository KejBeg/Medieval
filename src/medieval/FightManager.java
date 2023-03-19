
package medieval;
import java.util.ArrayList;

public class FightManager {
    /**
     * Lets Enemy and Character fight
     * @param ch
     */
    public static void fight(Character ch){ //Static means I don't have to create an object
        for(Enemy e : ch.getCurrentLocation().getEnemies()){
            while(!ch.isDead() && !e.isDead()) {
                ch.attack(e);
                e.attack(ch);

            }
        }

        System.out.println("end but why ?!??!");
        if (ch.isDead()) System.out.println("Hero died");

        
        /*ch.setHP(ch.getHP() - (e.getPrW().getDmg()+e.getStrength()));
        ch.getPrW().setDrb(ch.getPrW().getDrb()-5);
        e.setHP(e.getHP() - (ch.getPrW().getDmg()+ch.getStrength()));
        e.getPrW().setDrb(e.getPrW().getDrb()-5);*/
    }
}
