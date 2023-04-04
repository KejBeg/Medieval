package medieval;

public class MeleeWeapon extends Weapon{


    int damageFormula =


    public MeleeWeapon(String name, int damage, int hitChance, int range) {
        super(name, damage, hitChance, range);
    }

    public MeleeWeapon() {
        super("fists", 10, 50 ,0);
    }


}
