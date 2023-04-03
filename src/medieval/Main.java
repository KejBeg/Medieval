
package medieval;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        // Introductory message
        System.out.println("Welcome to the game");
        
        // Creating a Weapon class weapon
        RangedWeapon m4 = new RangedWeapon("M4A4", 100, 32, 50);

        // Creating a Character class character
        Character hero = new Character("Hero", 100, 10, m4);
        
        // Creating Locations
        hero.createLocation("Spawn", 1, null, "You survived the first Level;");
        hero.createLocation("The Abbys", 2, null, null);
        hero.createLocation("The Nether", 3, null, null);
        hero.createLocation("The Goal", 4, null, "You have accomplished what is thought to be Impossible");


        // Setting first location
        hero.setCurrentLocation(hero.getLocationList().get(0));

        // Letting the hero fight
        FightManager.fight(hero);

    }
}
