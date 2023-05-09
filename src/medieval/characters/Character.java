
package medieval.characters;

import medieval.*;
import medieval.items.Armor;
import medieval.items.Item;
import medieval.managers.MoveManager;
import medieval.weapons.Weapon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Character { //public abstract class Character = means that constructor can't be called independently, ONLY by a child class (using "extend")
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    private String name;
    private int hp;
    private int defense;
    private int effectiveHp;
    private int strength;
    private int meleeWeaponSkill;
    private int rangedWeaponSkill;
    private int magicWeaponSkill;
    private Weapon primaryWeapon;
    private Weapon secondaryWeapon;
    private Item primaryItem;
    private Item secondaryItem;
    private Armor equippedArmor;
    private boolean dead = false;




    
    //Location stuff
    private Location currentLocation;
    private int currentLocationNum = 0;


    
    ArrayList<Location> locationList = new ArrayList<Location>();
    Location[] nextLocations = new Location[2];

    /**
     * Character Constructor if hp, strength and prW arguments are given
     * @param name name, String
     * @param hp health, int
     * @param strength affects damage, int
     * @param primaryWeapon weapon, Weapon custom class
     * @param secondaryWeapon weapon, Weapon custom class
     */
    public Character(String name, int hp, int strength, Weapon primaryWeapon, Weapon secondaryWeapon, Armor equippedArmor){
        this.setName(name);
        this.setHP(hp);
        this.setStrength(strength);
        this.setPrimaryWeapon(primaryWeapon);
        this.setSecondaryWeapon(secondaryWeapon);
        this.setEquippedArmor(equippedArmor);
    }

    public Character() {
    }

    /**
     * Creates a location
     * @param name, String, name of the Location
     * @param numOfEnemies int, number of enemies in the Location
     * @param welcomeMessage String, Message than prints upon going to the location
     * @param exitMessage String, Message than prints upon leaving the location
     * @param itemDrop Item, the item that drops after defeating the location
     */
    public void createLocation(String name, int numOfEnemies, String welcomeMessage, String exitMessage, Item itemDrop){
        this.locationList.add(new Location(name, numOfEnemies, welcomeMessage, exitMessage, itemDrop));
    }

    /**
     * Sets the next locations
     * @param nextLocation1
     * @param nextLocation2
     */
    public void nextLocations(Location nextLocation1, Location nextLocation2){
        this.nextLocations[0] = nextLocation1;
        this.nextLocations[1] = nextLocation2;
    }

    public int effectiveHpFormula(int hp, int defense){
        return hp + defense;
    }

    /**
     * Heals the Character
     * if value is negative, value becomes 0
     * @param heal int value of how much Character is healed
     */
    public void heal(int heal){
        if (heal<0)heal=0;
        this.setHP(this.getHp()+heal);
    }

    /**
     * @param damage int, damages this by given amount
     */
    public void damageThis(int damage){
        this.setHP((this.getEffectiveHp() - damage)/ (1 + this.getDefense() / 100));
    }

    /**
     * Lets Character attack a target.
     * Has a counter on remaining enemies.
     * If there are no enemies, Character moves on to another location.
     * @param target target of Character or children of Character class.
     */
    public void attack(Enemy target, Weapon usedWeapon){
        int damage;

        int hitChanceRoll = rand.nextInt(101);
        int modifiedHitchance = usedWeapon.getHitChance();

        if (usedWeapon.getClass().getSimpleName().equals("MeleeWeapon")){
            modifiedHitchance += meleeWeaponSkill;
        } else if (usedWeapon.getClass().getSimpleName().equals("RangedWeapon")){
            modifiedHitchance += rangedWeaponSkill;
        } else if (usedWeapon.getClass().getSimpleName().equals("MagicWeapon")){
            modifiedHitchance += magicWeaponSkill;
        }


        // Makes sure Character is not dead
        if (this.isDead()){
            return;
        }

        // Makes sure target is in range
        if (usedWeapon.getRange() < target.getDistanceFromTarget()){
            System.out.println("Your " + usedWeapon.getName() + " could not reach enemy " + target.getName());
            target.moveCloser();
            return;
        }

        // Makes sure Character hit target
        if (!(hitChanceRoll <= modifiedHitchance)){
            System.out.println("You have missed the enemy (" + modifiedHitchance + "%)");
            return;
        }

        // Setting the damage
        damage = usedWeapon.damageFormula(this);

        // Damaging armor
        target.getEquippedArmor().lowerDurability(usedWeapon.getArmorBreakingCapability());

        System.out.println("The " + this.getName() + " has hit " + target.getName() + " for " + damage + " damage");

        // Ensuring damage is not over 100
        if (damage >= 100) damage = 100;

        // Adjusts health of enemy according to damage
        target.damageThis(damage);
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
        if(this.getHp()<=0){
            this.setDead(true);
            Helpers.announce("The brave " + this.getName() + " has died");
        }
    }


    // Getters
    public String getName() {
        return name;
    }
    public int getHp(){
        return this.hp;
    }
    public int getDefense() {
        return defense;
    }
    public int getEffectiveHp() {
        return effectiveHp;
    }
    public int getStrength(){
        return this.strength;
    }
    public Weapon getPrimaryWeapon() {
        return primaryWeapon;
    }
    public Weapon getSecondaryWeapon() {
        return secondaryWeapon;
    }
    public Item getPrimaryItem() {
        return primaryItem;
    }
    public Item getSecondaryItem() {
        return secondaryItem;
    }
    public Armor getEquippedArmor() {
        return this.equippedArmor;
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
    public int getMeleeWeaponHandling() {
        return meleeWeaponSkill;
    }
    public int getRangedWeaponHandling() {
        return rangedWeaponSkill;
    }
    public int getMagicWeaponHandling() {
        return magicWeaponSkill;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setHP(int hp){
        if (hp > 100){
            this.hp = 100;
        } else if(hp<0){
            this.hp = 0;
        } else {
            this.hp = hp;
        }

        // Setting the EHP
        this.setEffectiveHp(this.getHp() * (1 + (this.getDefense() / 100)));
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public void setEffectiveHp(int effectiveHp) {
        this.effectiveHp = effectiveHp;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public void setPrimaryWeapon(Weapon primaryWeapon) {
        this.primaryWeapon = primaryWeapon;
    }
    public void setSecondaryWeapon(Weapon secondaryWeapon) {
        this.secondaryWeapon = secondaryWeapon;
    }
    public void setPrimaryItem(Item primaryItem) {
        this.primaryItem = primaryItem;
    }
    public void setSecondaryItem(Item secondaryItem) {
        this.secondaryItem = secondaryItem;
    }
    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
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
    public void setMeleeWeaponHandling(int meleeWeaponHandling) {
        this.meleeWeaponSkill = meleeWeaponHandling;
    }
    public void setRangedWeaponHandling(int rangedWeaponHandling) {
        this.rangedWeaponSkill = rangedWeaponHandling;
    }
    public void setMagicWeaponHandling(int magicWeaponHandling) {
        this.magicWeaponSkill = magicWeaponHandling;
    }
}
