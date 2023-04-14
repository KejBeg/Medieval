package medieval;

public class RangedWeapon extends Weapon{

    /**
     * RangedWeapon constructor for following arguments
     * @param name String
     * @param damage iny
     * @param hitChance int
     * @param range int
     */
    public RangedWeapon(String name, int damage, int hitChance, int range) {
        super(name, damage, hitChance, range);
    }
}
