package medieval;

import medieval.characters.Character;
import medieval.characters.Enemy;
import medieval.weapons.Weapon;

public class Helpers{

    /**
     * Prints out the weapon's stats
     * @param weapon required for the stats
     * @param slotNum used for selecting the weapon, value can be 0 to have no number assigned
     */
    public static void weaponInfo(Weapon weapon, int slotNum) {
        if (slotNum == 0){
            System.out.println(weapon.getName() + " - Damage: " +  weapon.getDamage() + ", Hit chance: " +
                    weapon.getHitChance() + ", Durability: " + weapon.getDurability() + ", Range: " + weapon.getRange());
        }   else {
            System.out.println(weapon.getName() + "[" + slotNum +  "] - Damage: " +  weapon.getDamage() + ", Hit chance: " +
                    weapon.getHitChance() + ", Durability: " + weapon.getDurability() + ", Range: " + weapon.getRange());
        }

    }

    public static void playerInfo(Character character){
        System.out.println("Yours Health:" + character.getHp() + ", Defense: " + character.getDefense() + ", Effective HP: " + character.getEffectiveHp());
        System.out.println("Yours Stats:" + character.getStrength());
        System.out.println("Your Skills: ");
    }

    /**
     * Prints out the enemy's stats
     * @param enemy required for the stats
     * @param enemyNum used for selecting the enemy, value can be 0 to have no number assigned
     */
    public static void enemyInfo(Enemy enemy, int enemyNum) {
        if (enemyNum == 0 ){
            System.out.println("Choose what weapon you want to use against Enemy " + enemy.getName() + " - Health: " + enemy.getHp() + ", Strength: " + enemy.getStrength() + ", Weapon: " + enemy.getPrimaryWeapon().getName() + ", Distance: " + enemy.getDistanceFromTarget());
        } else {
            System.out.println("Choose what weapon you want to use against Enemy[" + enemyNum + "] " + enemy.getName() + " - Health: " + enemy.getHp() + ", Strength: " + enemy.getStrength() + ", Weapon: " + enemy.getPrimaryWeapon().getName() + ", Distance: " + enemy.getDistanceFromTarget());

        }
    }

    /**
     * Prints out a nice line
     */
    public static void line(){
        int amountOfLines = 40;
        for (int i = 0; i<40; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Prints out a beautiful style message.
     * If message is larger than the inner amountOfLines, then amountOfLines equals message+1
     * @param message String type message
     */
    public static void announce(String message){

        int amountOfLines = 40;
        if (message.length()>=amountOfLines){
            amountOfLines=message.length()+1;
        }

        System.out.println();
        for (int i = 0; i<=amountOfLines; i++){
            System.out.print("-");
        }

        System.out.println();

        System.out.print("|");
        for (int i = 0; i<=amountOfLines-2; i++){
            System.out.print(" ");
        }
        System.out.print("|");

        System.out.println();

        System.out.print("|");

        for (int i = 0; i<amountOfLines/2-message.length()/2-1; i++){
            System.out.print(" ");
        }
        System.out.print(message);
        for (int i = 0; i<amountOfLines/2-message.length()/2-1; i++){
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();

        System.out.print("|");
        for (int i = 0; i<=amountOfLines-2; i++){
            System.out.print(" ");
        }
        System.out.print("|");

        System.out.println();
        for (int i = 0; i<=amountOfLines; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}