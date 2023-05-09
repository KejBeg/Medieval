package medieval.items;

import medieval.characters.Character;
import medieval.items.Item;

public class Effect extends Item {
    int damageFull;
    int hitRepeatCount;
    int damageDealt;

    public void damageOverTime(Character target){
        int damage;

        if (target.isDead()){
            return;
        }

        damage = this.getDamageFull() - this.getHitRepeatCount();

        target.damageThis(damage);
    }

    // Getters
    public int getDamageFull() {
        return damageFull;
    }
    public int getHitRepeatCount() {
        return hitRepeatCount;
    }

    // Setters
    public void setDamageFull(int damageFull) {
        this.damageFull = damageFull;

    }
    public void setHitRepeatCount(int hitRepeatCount) {
        this.hitRepeatCount = hitRepeatCount;
    }
}
