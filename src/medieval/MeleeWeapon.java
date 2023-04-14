package medieval;

public class MeleeWeapon extends Weapon{


    /**
     * MeleeWeapon constructor if all arguments are given
     * @param name String
     * @param damage int
     * @param hitChance int
     */
    public MeleeWeapon(String name, int damage, int hitChance) {
        super(name, damage, hitChance, 0);
    }

    /**
     * MeleeWeapon constructor if no arguments are given.
     * Creates a fist-like weapon
     */
    public MeleeWeapon() {
        super("fists", 5, 50 ,0);
    }

    /**
     * returns the damage that should be given
     * @param user needs to get some variables
     * @return returns the damage that should be given
     */
    int damageFormula(Character user){
        return user.getPrimaryWeapon().getDamage()+user.getStrength();
    }

}
