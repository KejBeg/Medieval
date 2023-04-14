
package medieval;

// Imports
import java.util.Random;

public class Enemy extends Character{
    Random rand = new Random();

    int distanceFromTarget;

    String[] nameList = new String[] {"Brock", "Heisenberg", "Jake", "John", "Robert", "Rudolf", "Emily", "Linus", "Walter", "Hank", "Marie", "Skyler", "Mike", "Mathew", "Greg", "Craig", "Jimmy", "Saul"};

    /**
     * Enemy constructor for all arguments
     * @param name String, using super
     * @param hp int, using super
     * @param strength int, using super
     * @param primaryWeapon Weapon
     * @param distanceFromTarget int
     */
    public Enemy(String name, int hp, int strength, Weapon primaryWeapon, int distanceFromTarget) {
        super(name, hp, strength);
        this.setPrimaryWeapon(primaryWeapon);
        this.setDistanceFromTarget(distanceFromTarget);
    }

    /**
     * Enemy constructor if no arguments are given.
     */
    public Enemy() {
        this.setName(nameList[rand.nextInt(nameList.length)]);
        this.setHP(100);
        this.setStrength(rand.nextInt(10));
        this.setPrimaryWeapon(new MeleeWeapon());
        this.setDistanceFromTarget(rand.nextInt(4));
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

        // Setting a damage value
        damage = this.getPrimaryWeapon().damageFormula(this);

        // Printing out info
        System.out.println("Enemy " + this.getName() + " has hit the brave " + target.getName() + " for " + damage + " damage");

        // Ensuring damage is
        //if (damage >= 100) damage = 100;

        // Modifying target values
        target.setHP(target.getHP() - damage);

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
        if (this.getHP()>0){
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

    // Setters
    public void setDistanceFromTarget(int distanceFromTarget) {
        this.distanceFromTarget = distanceFromTarget;
    }
}
