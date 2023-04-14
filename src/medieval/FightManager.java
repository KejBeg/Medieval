
package medieval;

// Imports
import java.util.ArrayList;
import java.util.Scanner;

public class FightManager {

    /**
     * Starts the process of selecting a weapon to attack
     * @param character needs to retrieve the info to operate
     * @param enemy required to print out Enemy's info
     */
    public static Weapon weaponSelection(Character character, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);

        // Variable init
        int weaponChoice;

        // Do-while loop used to ask again if user input is wrong
        do {
            Helpers.line();
            Helpers.enemyInfo(enemy, 0);

            System.out.println();
            System.out.println("You can use either: ");

            // Printing out the selectable weapons
            Helpers.weaponInfo(character.getPrimaryWeapon(), 1);
            System.out.println("OR");
            Helpers.weaponInfo(character.getSecondaryWeapon(), 2);

            System.out.println();

            //Asking for the user input
            weaponChoice = scanner.nextInt();

            // Setting the chosen weapon
            if (weaponChoice == 1) {
                System.out.println("You chose to use " + character.getPrimaryWeapon().getName());
                Helpers.line();

                return character.getPrimaryWeapon();
            } else if (weaponChoice == 2) {
                System.out.println("You chose to use " + character.getSecondaryWeapon().getName());
                Helpers.line();

                return character.getSecondaryWeapon();
            } else {
                System.out.println("Please select either: " + character.getPrimaryWeapon().getName() + "[1] or " + character.getSecondaryWeapon().getName() + "[2]");
            }

        } while (weaponChoice != 1 && weaponChoice != 2);

        return null;
    }
    /**
     * Lets Enemy and Character fight
     * @param character character
     */
    public static void fight(Character character){
        for(Enemy enemy : character.getCurrentLocation().getEnemies()){
            while(!character.isDead() && !enemy.isDead()) {
                character.attack(enemy, weaponSelection(character, enemy));
                enemy.attack(character);
            }
        }
    }
}
