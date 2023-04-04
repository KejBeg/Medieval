
package medieval;

import java.util.List;

public class Weapon {
    String name;
    private int durability;
    private int damage;
    private int hitChance;
    String[] ranges = {"melee", "short", "medium", "long"};
    String range;



    /**
     * Default constructor for Weapon class.
     * Does not require any arguments
     */
    public Weapon() {
        this.setName("Generic");
        this.setDamage(1);
        this.setHitChance(50);
    }

    /**
     * Weapon Constructor if name, drb and dmg arguments are provided
     * @param name the weapon's name
     * @param damage the amount of damage it adds
     * @param hitChance the chance of hitting a target
     */
    public Weapon(String name, int damage, int hitChance, int range){
        this.setName(name);
        this.setDamage(damage);
        this.setHitChance(hitChance);
        this.setRange(this.getRanges()[rangeRegulator(range)]);
    }

    public int rangeRegulator(int range){
        if (range>3){
            range=3;
        } else if (range<0) {
            range = 0;
        }

        return range;
    }

    int damageFormula(Character user){
        
    }

    
    public String getName(){
        return this.name;
    }
    
    public int getDurability(){
        return this.durability;
    }
    
    public int getDamage(){
        return this.damage;
    }
    public int getHitChance() {
        return hitChance;
    }

    public String[] getRanges() {
        return ranges;
    }
    public String getRange() {
        return range;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public void setHitChance(int hitChance) {
        this.hitChance = hitChance;
    }
    public void setRange(String range) {
        this.range = range;
    }
}
