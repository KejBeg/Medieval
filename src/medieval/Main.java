
package medieval;

import medieval.characters.Character;
import medieval.items.Armor;
import medieval.items.Item;
import medieval.managers.FightManager;
import medieval.weapons.MeleeWeapon;
import medieval.weapons.RangedWeapon;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // Creating an ArrayList of all items
        ArrayList<Item> itemList = new ArrayList<Item>();

        // Creating an ArrayList of all player owned items
        ArrayList<Item> playerInventory = new ArrayList<Item>();



        // Introductory message
        System.out.println("Welcome to the game");
        
        // Creating Weapons
        RangedWeapon m4 = new RangedWeapon("M4A4", 20, 3, 32, 35, 2);
        RangedWeapon ak47 = new RangedWeapon("AK-47", 25, 5, 80, 2, 3);
        RangedWeapon awp = new RangedWeapon("AWP", 75, 20, 95, 3, 4);
        MeleeWeapon axe = new MeleeWeapon("axe", 15, 40, 4);
        MeleeWeapon knife = new MeleeWeapon("M9 knife", 10, 65, 2);

        // Creating armors



        // Creating a Character
        Character hero = new Character("Hero", 100, 100, new MeleeWeapon(), ak47, new Armor());
        
        // Creating Locations
        hero.createLocation("Spawn", 1, null, "You survived the first Level :D", m4);
        hero.createLocation("The Abbys", 1, null, null, axe);
        hero.createLocation("The Nether", 1, null, null, ak47);
        hero.createLocation("The Goal", 1, null, "You have accomplished what is thought to be Impossible", knife);


        // Setting first location
        hero.setCurrentLocation(hero.getLocationList().get(0));

        // Letting the hero fight
        FightManager.fight(hero);

    }
}
