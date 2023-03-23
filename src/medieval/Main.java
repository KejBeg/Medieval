
package medieval;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        // Introductory message
        System.out.println("Welcome to the game");
        
        // Creating a Weapon class weapon
        Weapon m4 = new Weapon("M4A4", 100, 32);

        // Creating a Character class character
        Character hero = new Character(100, 10, m4);

        // Letting the hero fight
        FightManager.fight(hero);

    }
}
