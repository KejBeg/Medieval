package medieval.items;

public abstract class Item {
    private String name;
    private int durability;


    // Getters
    public int getDurability() {
        return this.durability;
    }
    public String getName() {
        return this.name;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDurability(int durability) {
        this.durability = durability;
    }
}
