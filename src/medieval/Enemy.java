
package medieval;

import java.util.Random;

public class Enemy extends Character{
    Random rand = new Random();

    String[] nameList = new String[] {"Brock", "Heisenberg", "Jake", "John", "Robert", "Rudolf", "Emily", "Linus", "Walter", "Hank", "Marie", "Skyler", "Mike", "Mathew", "Greg", "Craig", "Jimmy", "Saul"};

    public Enemy(String name, int hp, int strength, Weapon primaryWeapon) {
        super(name, hp, strength, primaryWeapon);
    }

    public Enemy() {
        MeleeWeapon fists = new MeleeWeapon();

        this.setName(nameList[rand.nextInt(nameList.length)]);
        this.setHP(100);
        this.setStrength(rand.nextInt(10));
        this.setPrimaryWeapon(fists);
    }

    public void attack(Character target){
        if (this.isDead()){
            return;
        }

        int damage = this.getPrimaryWeapon().getDamage()+this.getStrength();
        System.out.println("Enemy " + this.getName() + " has hit the brave " + target.getName() + " for " + damage + " damage");

        // Ensuring damage is
        //if (damage >= 100) damage = 100;

        // Adjusts health of enemy according to damage
        target.setHP(target.getHP() - damage);
        //getPrW().setDrb(getPrW().getDrb()-5);


        target.die();

    }

    public void die(){
        if (this.isDead()){
            return;
        }
        if(this.getHP()<=0){
            this.setDead(true);
            Helpers.announce("Enemy " + this.getName() + " has died");
        }
    }
}
