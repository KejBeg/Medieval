package medieval;

public class Armor {
    private String name;
    private int damageBlockingPercentage;
    private int durability;

    /**
     * Constructor for Armor if following parameters are given
     * @param name String
     * @param damageBlockingPercentage int
     * @param durability int
     */
    public Armor(String name, int damageBlockingPercentage, int durability) {
        this.setName(name);
        this.setDamageBlockingPercentage(damageBlockingPercentage);
        this.setDurability(durability);
    }

    /**
     * Default constructor for Armor
     */
    public Armor(){
        this.setName("Chainmail");
        this.setDurability(30);
        this.setDamageBlockingPercentage(10);
    }

    /**
     * Lowers the durability of Armor
     * @param damageToArmor int, amount of damage the armour takes
     */
    public void lowerDurability(int damageToArmor){
        this.setDurability(this.getDurability() - damageToArmor);
    }

    public void breakArmor(){
        if (this.getDurability() < 0){
            return;
        }
        Helpers.announce("Your " + this.getName() + " armor has been broken");

        // "Breaks" the armor
        this.setDurability(0);
        this.setDamageBlockingPercentage(0);
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getDamageBlockingPercentage() {
        return damageBlockingPercentage;
    }
    public int getDurability() {
        return durability;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDamageBlockingPercentage(int damageBlockingPercentage) {
        this.damageBlockingPercentage = damageBlockingPercentage;
    }
    public void setDurability(int durability) {
        this.durability = durability;
    }
}
