
package medieval;

public class Weapon {
    String name;
    private int durability;
    private int damage;
    private int hitChance;


    /**
     * Default constructor for Weapon class.
     * Does not require any arguments
     */
    public Weapon() {
        this.setName("Generic");
        this.setDurability(1);
        this.setDamage(1);
        this.setHitChance(50);
    }

    /**
     * Weapon Constructor if name, drb and dmg arguments are provided
     * @param name
     * @param durability
     * @param damage
     */
    public Weapon(String name, int durability, int damage, int hitChance){
        this.setName(name);
        this.setDurability(durability);
        this.setDamage(damage);
        this.setHitChance(hitChance);
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

    public void setName(String name){
        this.name = name;
    }
    
    public void setDurability(int durability){
        this.durability = durability;
    }
    
    public void setDamage(int damage){
        this.damage = damage;
    }
    public void setHitChance(int hitChance) {
        this.hitChance = hitChance;
    }
}
