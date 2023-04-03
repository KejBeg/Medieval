
package medieval;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Character { //public abstract class Character = means that constructor can't be called independently, ONLY by a child class (using "extend")
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    private String name;
    private int hp;
    private int strength;
    private Weapon primaryWeapon;
    private boolean dead = false;

    
    //Location stuff
    private Location currentLocation;
    private int currentLocationNum = 0;


    
    ArrayList<Location> locationList = new ArrayList<Location>();
    Location[] nextLocations = new Location[2];

    /**
     * Character Constructor if hp, strength and prW arguments are given
     * @param hp health, int
     * @param strength affects damage, int
     * @param primaryWeapon weapon, Weapon custom class
     */
    public Character(String name, int hp, int strength, Weapon primaryWeapon){
        this.setName(name);
        this.setHP(hp);
        this.setStrength(strength);
        this.setPrimaryWeapon(primaryWeapon);
    }

    /**
     * Character constructor if no arguments are given
     */
    public Character(){
        MeleeWeapon fists = new MeleeWeapon();

        this.setHP(100);
        this.setStrength(rand.nextInt(10)+1);
        this.setPrimaryWeapon(fists);
    }
    
    public void createLocation(String name, int numOfEnemies, String welcomeMessage, String exitMessage){
        this.locationList.add(new Location(name, numOfEnemies, welcomeMessage, exitMessage));
    }
    
    public void nextLocations(Location nextLocation1, Location nextLocation2){
        this.nextLocations[0] = nextLocation1;
        this.nextLocations[1] = nextLocation2;
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
     * Lets Character attack a target.
     * Has a counter on remaining enemies.
     * If there are no enemies, Character moves on to another location.
     * @param target target of Character or children of Character class.
     */
    public void attack(Character target){
        if (this.isDead()){
            return;
        }

        int damage = this.getPrimaryWeapon().getDamage()+this.getStrength();
        System.out.println("The " + this.getName() + " has hit " + target.getName() + " for " + damage + " damage");

        // Ensuring damage is
        if (damage >= 100) damage = 100;

        // Adjusts health of enemy according to damage
        target.setHP(target.getHP() - damage);
        //getPrW().setDrb(getPrW().getDrb()-5);


        target.die();

        // Adjusts numOfEnemies
        if (target.isDead()){
            this.getCurrentLocation().setNumOfEnemies(this.getCurrentLocation().getNumOfEnemies()-1);
        }

        // Calls MoveManager if there are no enemies remaining
        if (this.getCurrentLocation().getNumOfEnemies()<=0){
            MoveManager.move(this);
        }
    }

    /**
     * Moves the Character to a specified location
     * @param newLocation Location class new Location
     */
    public void move(Location newLocation, int currentLocationNum){
        this.setCurrentLocation(newLocation);
        this.setCurrentLocationNum(currentLocationNum);
    }

    /**
     * If hp is less than 0, the Character dies
     */
    public void die(){
        if (this.isDead()){
            return;
        }
        if(this.getHP()<=0){
            this.setDead(true);
            Helpers.announce("The brave " + this.getName() + " has died");
        }
    }

    public String getName() {
        return name;
    }
    int getHP(){
        return this.hp;
    }
    int getStrength(){
        return this.strength;
    }
    Weapon getPrimaryWeapon() {
        return primaryWeapon;
    }
    public boolean isDead() {
        return dead;
    }
    public Location getCurrentLocation() {
        return currentLocation;
    }

    public int getCurrentLocationNum() {
        return currentLocationNum;
    }

    public ArrayList<Location> getLocationList() {
        return locationList;
    }


    public void setName(String name) {
        this.name = name;
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
    void setPrimaryWeapon(Weapon primaryWeapon) {
        this.primaryWeapon = primaryWeapon;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
    public void setCurrentLocationNum(int currentLocationNum) {
        this.currentLocationNum = currentLocationNum;
    }
}
