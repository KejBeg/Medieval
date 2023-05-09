
package medieval.weapons;

// Import
import medieval.items.Item;
import medieval.characters.Character;

import java.util.Random;

public abstract class Weapon extends Item {
    Random rand = new Random();

    // Variable Init
    private int damage;
    private int armorBreakingCapability;
    private int hitChance;
    int range;


    /**
     * Weapon Constructor if following arguments are provided
     * @param name the weapon's name
     * @param durability int, after how long this weapon will break
     * @param armorBreakingCapability int, the damage it deals to the armor
     * @param damage the amount of damage it adds
     * @param hitChance the chance of hitting a target
     */
    public Weapon(String name, int durability, int damage, int armorBreakingCapability, int hitChance, int range) {
        this.setName(name);
        this.setDurability(durability);
        this.setDamage(damage);
        this.setArmorBreakingCapability(armorBreakingCapability);
        this.setHitChance(hitChance);
        this.setRange(range);
    }

    /**
     * Makes sure that range is not outside the allowed range
     * @param range int
     * @return returns the allowed range
     */
    public int rangeRegulator(int range){
        if (range>3){
            range=3;
        } else if (range<0) {
            range = 0;
        }

        return range;
    }

    /**
     * returns the damage that should be given
     * @param user needs to get some variables
     * @return returns the damage that should be given
     */
    public int damageFormula(Character user){
        return user.getPrimaryWeapon().getDamage();
    }

    /**
     * Damages the weapon
     * @param damage int, amount of damage dealt
     */
    public void damageWeapon(int damage){
        // Ensures the weapon is not repaired
        if (damage < 0){
            return;
        }

        // Damages the weapon
        this.setDurability(this.getDurability() + damage);
    }

    /**
     * Breaks the weapon if durability is less than 0
     */
    public void breakWeapon(){
        if (this.getDurability() > 0){
            return;
        }

        System.out.println("Your " + this.getName() + " has broken");

        this.setName("Broken" + this.getName());
        this.setDamage(0);
        this.setArmorBreakingCapability(0);


    }

    // Getters

    public int getArmorBreakingCapability() {
        return armorBreakingCapability;
    }
    public int getDamage(){
        return this.damage;
    }
    public int getHitChance() {
        return hitChance;
    }
    public int getRange() {
        return range;
    }

    // Setters
    public void setArmorBreakingCapability(int armorBreakingCapability) {
        this.armorBreakingCapability = armorBreakingCapability;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public void setHitChance(int hitChance) {
        this.hitChance = hitChance;
    }
    public void setRange(int range) {
        this.range = range;
    }
}
