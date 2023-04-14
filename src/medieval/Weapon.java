
package medieval;

// Import
import java.util.List;
import java.util.Random;

public class Weapon {
    Random rand = new Random();

    // Variable Init
    String name;
    private int durability;
    private int damage;
    private int hitChance;
    int range;



    /**
     * Default constructor for Weapon class.
     * Does not require any arguments
     */
    public Weapon() {
        this.setName("Generic");
        this.setDamage(1);
        this.setHitChance(50);
        this.setRange(rangeRegulator(rand.nextInt(4)));
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
        this.setRange(rangeRegulator(range));
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
    int damageFormula(Character user){
        return user.getPrimaryWeapon().getDamage();
    }

    // Getters
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
    public int getRange() {
        return range;
    }

    // Setters
    public void setName(String name){
        this.name = name;
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
