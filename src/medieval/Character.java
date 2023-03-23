
package medieval;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Character {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    
    private int hp;
    private int strength;
    private Weapon prW;
    private boolean dead = false;

    private int numOfEnemies;
    private Location currentLocation;
    private int currentLocationNum;

    private int locationChoice;
    private Location goal;
    
    ArrayList<Location> locationList = new ArrayList<Location>();
    Location[] nextLocations = new Location[2];

    /**
     * Character Constructor if hp, strength and prW arguments are given
     * @param hp health, int
     * @param strength affects damage, int
     * @param prW weapon, Weapon custom class
     */
    public Character(int hp, int strength, Weapon prW){
        this.setHP(hp);
        this.setStrength(strength);
        this.setPrW(prW);

        // Creating Locations
        //Always create odd amount of Locations
        this.locationList.add(new Location("Spawn", 1));
        this.locationList.add(new Location("The Forest", 2));
        this.locationList.add(new Location("The Shroomland", 3));
        this.locationList.add(new Location("The Abyss", 4));
        this.locationList.add(new Location("The Nether", 5));
        this.locationList.add(new Location("The End", 6));

        this.currentLocationNum = 0;
        this.currentLocation = locationList.get(this.currentLocationNum);
        this.goal = this.locationList.get(this.locationList.size()-1);

        //Setting next locations
        this.nextLocations[0] = this.locationList.get(1);
        this.nextLocations[1] = this.locationList.get(2);

    }

    /**
     * Character constructor if no arguments are given
     * Please do not use currently, many things are missing
     */
    public Character(){
        this.setHP(rand.nextInt(100)+1);
        this.setStrength(rand.nextInt(10)+1);
    }
    
    
    /**
     * Heals the Character
     * if value is negative, value becomes 0
     * @param heal int value of how much Character is healed
     */
    public void heal(int heal){
        if (heal<0)heal=0;
        this.setHP(this.getHP()+heal);
    }

    /**
     * Lets Character attack an Enemy
     * Also has a counter on how many enemies were slain
     * If there are no enemies, Character moves on to another location
     * @param en enemy, Enemy custom class
     */
    public void attack(Enemy en){
        if (!this.isDead()){
            int damage = this.getPrW().getDmg()+this.getStrength();
            System.out.println("The hero has hit " + en.getName() + " for " + damage + " damage");
            if (damage >= 100) damage = 100;
            en.setHP(en.getHP() - damage);
            //getPrW().setDrb(getPrW().getDrb()-5);
        }
        en.die();
        if (en.isDead()){
            currentLocation.numOfEnemies--;
        }
        //System.out.println(this.numOfEnemies);
        if (currentLocation.numOfEnemies<=0){
            this.move();
        }
    }
    
    public void move(){
        if (!this.isDead()) {
            if (this.currentLocationNum + 3 <= this.locationList.size()) {
                System.out.println("Select the location you want to go into\n");
                System.out.println("You can choose from: \n");
                System.out.println(this.locationList.get(currentLocationNum + 1).getName() + "[1] or " + this.locationList.get(currentLocationNum + 2).getName() + "[2]");
                locationChoice = scanner.nextInt();

                if (locationChoice == 1) { //this.locationList.get(currentLocationNum+1).getName()
                    this.currentLocation = this.locationList.get(currentLocationNum + 1);
                    this.currentLocationNum = this.currentLocationNum + 2;
                } else if (locationChoice == 2) { // this.locationList.get(currentLocationNum+2).getName()
                    this.currentLocation = this.locationList.get(currentLocationNum + 2);
                    this.currentLocationNum = this.currentLocationNum + 3;
                }

                //this.currentLocation = this.locationList.get(this.currentLocationNum);
                System.out.println("The hero moved to " + this.currentLocation.getName());
                FightManager.fight(this);

            } else {
                this.currentLocation = this.goal;
                System.out.println("The hero  moved to " + this.goal.getName());
                System.out.println(this.currentLocation.getNumOfEnemies());
                FightManager.fight(this);
            }
        }
    }

    /**
     * If hp is less than 0, the Character dies
     */
    public void die(){
        if (!this.isDead()){
            if(this.getHP()<=0){
                this.setDead(true);
                System.out.println("The brave hero has died");
            }
        }

    }
    
    int getHP(){
        //this.die();
        return this.hp;
    }
    int getStrength(){
        return this.strength;
    }
    Weapon getPrW() {
        return prW;
    }
    public boolean isDead() {
        return dead;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    
    
    void setHP(int hp){
        if (hp > 100){
            this.hp = 100;
        } else if(hp<0){
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }
    void setStrength(int strength){
        this.strength = strength;
    }
    void setPrW(Weapon prW) {
        this.prW = prW;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
