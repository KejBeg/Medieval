
package medieval;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        // Introductory message
        System.out.println("Welcome to the game");
        
        // Creating Weapons
        RangedWeapon m4 = new RangedWeapon("M4A4", 20, 3, 32, 35, 2);
        RangedWeapon ak47 = new RangedWeapon("AK-47", 25, 5, 80, 2, 3);
        RangedWeapon awp = new RangedWeapon("AWP", 75, 20, 95, 3, 4);
        MeleeWeapon axe = new MeleeWeapon("axe", 15, 40, 4);
        MeleeWeapon knife = new MeleeWeapon("M9 knife", 10, 65, 2);

        // Creating armors
        Armor chainmailArmor = new Armor("Chainmail", 10, 20);



        // Creating a Character
        Character hero = new Character("Hero", 100, 100, new MeleeWeapon(), new MeleeWeapon(), chainmailArmor);
        
        // Creating Locations
        hero.createLocation("Spawn", 1, null, "You survived the first Level :D", m4);
        hero.createLocation("The Abbys", 2, null, null, axe);
        hero.createLocation("The Nether", 3, null, null, ak47);
        hero.createLocation("The Goal", 4, null, "You have accomplished what is thought to be Impossible", knife);


        // Setting first location
        hero.setCurrentLocation(hero.getLocationList().get(0));

        // Letting the hero fight
        FightManager.fight(hero);

    }
}
