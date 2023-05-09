package medieval.weapons;

public class RangedWeapon extends Weapon {

    /**
     * RangedWeapon constructor for following arguments
     * @param name String
     * @param damage iny
     * @param hitChance int
     * @param range int
     */
    public RangedWeapon(String name, int damage, int armorBreakingCapability, int durability, int hitChance, int range) {
        super(name, damage, armorBreakingCapability, durability, hitChance, range);
    }
}
