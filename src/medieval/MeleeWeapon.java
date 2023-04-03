package medieval;

public class MeleeWeapon extends Weapon{
    public MeleeWeapon(String name, int durability, int damage, int hitChance) {
        super(name, durability, damage, hitChance);
    }

    public MeleeWeapon() {
        super("Fists", 100, 10, 75);
    }
}
