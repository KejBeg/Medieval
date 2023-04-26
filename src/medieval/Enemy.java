
package medieval;

// Imports
import java.util.Random;

public class Enemy extends Character{
    Random rand = new Random();

    int distanceFromTarget;
    int xpReward;

    String[] nameList = new String[] {"Brock", "Heisenberg", "Jake", "John", "Robert", "Rudolf", "Emily", "Linus", "Walter", "Hank", "Marie", "Skyler", "Mike", "Mathew", "Greg", "Craig", "Jimmy", "Saul"};

    /**
     * Enemy constructor if no arguments are given.
     */
    public Enemy() {
        this.setName(nameList[rand.nextInt(nameList.length)]);
        this.setHP(100);
        this.setStrength(rand.nextInt(10));
        this.setPrimaryWeapon(new MeleeWeapon());
        this.setDistanceFromTarget(rand.nextInt(4));
        this.setEquippedArmor(new Armor());
        this.setXpReward(rand.nextInt(20));
    }

    /**
     * Lets Enemy attack Character
     * @param target Character, for modifying and getting values
     */
    public void attack(Character target){
        // Variable Init
        int damage;

        int hitChanceRoll = rand.nextInt(101);

        // Making sure that Enemy is not dead
        if (this.isDead()){
            return;
        }

        // Making sure that Enemy actually hit target
        if (!(hitChanceRoll <= this.getPrimaryWeapon().getHitChance())){
            System.out.println("Enemy " + this.getName() + " has missed the hero (" + hitChanceRoll + "%)");
            return;
        }

        // Makes sure Enemy can reach target
        if (this.getPrimaryWeapon().getRange() < this.getDistanceFromTarget()){
            System.out.println("Your " + this.getPrimaryWeapon().getName() + " could not reach enemy " + target.getName());
            this.moveCloser();
            return;
        }

        // Setting the damage
        damage = this.getPrimaryWeapon().damageFormula(this)  + target.getEquippedArmor().getDamageBlockingPercentage() / 100;

        // Damaging armor
        target.getEquippedArmor().lowerDurability(this.getPrimaryWeapon().getArmorBreakingCapability());


        // Printing out info
        System.out.println("Enemy " + this.getName() + " has hit the brave " + target.getName() + " for " + damage + " damage");

        // Ensuring damage is
        //if (damage >= 100) damage = 100;

        // Modifying target values
        target.setEffectiveHp(target.getHp() - damage);

        // If target's health is 0, the target dies
        target.die();
    }

    /**
     * If Enemy health is 0, Enemy dies
     */
    public void die(){
        // Making sure Enemy is not already dead
        if (this.isDead()){
            return;

        }

        // Makes sure if health is 0
        if (this.getHp()>0){
            return;
        }


        this.setDead(true);

        // Prints out info
        System.out.println("Enemy " + this.getName() + "  Has died");
    }

    /**
     * Moves Enemy closer.
     * If distanceFromTarget is already 0, function is returned
     */
    public void moveCloser(){
        if (this.getDistanceFromTarget() == 0){
            return;
        }
        // Moves Enemy closer
        this.setDistanceFromTarget(this.getDistanceFromTarget() - 1);
    }

    // Getters
    public int getDistanceFromTarget() {
        return distanceFromTarget;
    }
    public int getXpReward() {
        return xpReward;
    }

    // Setters
    public void setDistanceFromTarget(int distanceFromTarget) {
        this.distanceFromTarget = distanceFromTarget;
    }
    public void setXpReward(int xpReward) {
        this.xpReward = xpReward;
    }
}
