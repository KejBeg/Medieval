package medieval.managers;

import medieval.Helpers;
import medieval.Location;
import medieval.weapons.Weapon;
import medieval.characters.Character;

import java.util.Scanner;

public class MoveManager {
    static boolean movedToGoal = false;

    /**
     * Asks the user in which slot he wants a weapon to go
     * @param character needs it for function's calls
     */
    public static void weaponSlotSelection(Character character) {
        Scanner scanner = new Scanner(System.in);

        // Variable Init
        int slotChoice;

        /* Prompts the user to enter a value.
        * If value is not 1 or 2, it prompts the user again
        */
        do {
            System.out.print("Do you want to change it with your: ");
            Helpers.weaponInfo(character.getPrimaryWeapon(), 1);
            System.out.println("OR");
            Helpers.weaponInfo(character.getSecondaryWeapon(), 2);
            slotChoice = scanner.nextInt();
            if (slotChoice == 1){
                character.setPrimaryWeapon((Weapon) character.getCurrentLocation().getItemDrop());
            } else if (slotChoice == 2) {
                character.setSecondaryWeapon((Weapon) character.getCurrentLocation().getItemDrop());
            } else {
                System.out.println("You cannot choose that");
                Helpers.line();
            }
        } while (slotChoice != 1 && slotChoice != 2);
    }

    /**
     *  Asks if user wants to switch to a dropped weapon from a defeated Location.
     * @param character needs it for function's calls
     */
    public static void itemLooter(Character character){
        Scanner scanner = new Scanner(System.in);

        // Variable init
        int weaponChoice;
        int slotChoice;

        // If there is no weaponDrop then this function is useless
        if (character.getCurrentLocation().getItemDrop()==null){
            System.out.println("You found no weapons in " + character.getCurrentLocation().getName());
            return;
        }

        Helpers.line();

        // Switch case just for grammatical correctness
        switch (character.getCurrentLocation().getItemDrop().getName().indexOf(0)){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'y':
                System.out.print("You have searched " + character.getCurrentLocation().getName() + " and found an ");
                break;
            default:
                System.out.print("You have searched " + character.getCurrentLocation().getName() + " and found a ");
                break;
        }


        Helpers.weaponInfo((Weapon) character.getCurrentLocation().getItemDrop(), 0);
        System.out.println("Do you want to change it with your current " + character.getPrimaryWeapon().getName() + " and " + character.getSecondaryWeapon().getName() +  " ?");
        System.out.println("Yes[1] or No[2]");

        // Do-while loop used to ask again if user input is wrong
        do{

            // Asking for the user input
            weaponChoice = scanner.nextInt();

            if (weaponChoice == 1) {
                System.out.println("You picked up the " + character.getCurrentLocation().getItemDrop().getName());
                weaponSlotSelection(character);
            } else if (weaponChoice == 2){
                System.out.println("You chose not to pick the weapon up");
            } else {
                System.out.println("Please, Pick either Yes[1] or No[2]");
            }
        }while(weaponChoice != 1 && weaponChoice != 2);

        Helpers.line();

    }

    /**
     *  Asks the user to choose between two Locations.
     * @param hero needs it for function's calls
     */
    public static void move(Character hero){

        MoveManager.itemLooter(hero);

        Scanner scanner = new Scanner(System.in);

        int locationChoice;
        Location[] nextLocations = new Location[2];


        if (hero.getCurrentLocationNum()+2 <= hero.getLocationList().size()-1){
            nextLocations[0] = hero.getLocationList().get(hero.getCurrentLocationNum()+2);
            nextLocations[1] = hero.getLocationList().get(hero.getCurrentLocationNum()+3);
            Helpers.line();
            System.out.println("Choose a location");
            System.out.println("You can select from:");
            System.out.println(nextLocations[0].getName() + "[1] or " + nextLocations[1].getName() + "[2]");
            do {
                locationChoice = scanner.nextInt();
                if (locationChoice == 1){
                    hero.move(nextLocations[0], hero.getCurrentLocationNum()+2);
                } else if (locationChoice == 2) {
                    hero.move(nextLocations[1], hero.getCurrentLocationNum()+3);
                } else {
                    System.out.println("Please choose between: " + nextLocations[0].getName() + "[1] or " + nextLocations[1].getName() + "[2]");
                }
            }while (locationChoice != 1 && locationChoice != 2);

            System.out.println("You have moved to " + hero.getCurrentLocation().getName());
            Helpers.line();
            FightManager.fight(hero);
        } else {
            if (!movedToGoal){
                movedToGoal = true;
                hero.move(hero.getLocationList().get(hero.getLocationList().size()-1), hero.getLocationList().size()-1);
                Helpers.announce("The " + hero.getName()+ " has moved to the final location" + hero.getCurrentLocation().getName());
                FightManager.fight(hero);
            } else {
                Helpers.announce("You won");
            }

        }
    }
}
