package medieval.items;

import medieval.characters.Character;
import medieval.items.Item;

public class HealItem extends Item {
    private int healAmount;
    private boolean broken;


    /**
     * HealItem constructor if following arguments are given
     * @param name String
     * @param healAmount int, how much this item heals its user
     */
    public HealItem(String name, int healAmount){
        this.setName(name);
        this.setHealAmount(healAmount);
    }

    /**
     * Breaks the item
     */
    public void breakHealItem(){
        this.setName("Empty " + this.getName());
        this.setHealAmount(0);
    }

    /**
     * Heals a given character
     * @param character Character, needed for function's calls
     */
    public void heal(Character character){
        // Makes sure you cannot use the item if its already broken
        if (this.isBroken()){
            System.out.println("This item is empty and you cannot use it");
            return;
        }

        // Heals the user
        character.heal(healAmount);

        // Tells the user that he has been healed
        System.out.println("You have been healed for " + this.getHealAmount());

        // Breaks the item
        this.breakHealItem();
    }

    // Getters
    public int getHealAmount() {
        return this.healAmount;
    }
    public boolean isBroken() {
        return broken;
    }

    // Setters
    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }
    public void setBroken(boolean broken) {
        this.broken = broken;
    }
}
