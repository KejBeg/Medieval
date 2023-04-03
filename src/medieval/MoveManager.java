package medieval;

import java.util.Scanner;
import java.util.ArrayList;

public class MoveManager {
    static boolean movedToGoal = false;

    public static void move(Character hero){

        Scanner scanner = new Scanner(System.in);

        int locationChoice;
        Location[] nextLocations = new Location[2];


        if (hero.getCurrentLocationNum()+2 <= hero.getLocationList().size()-1){
            nextLocations[0] = hero.getLocationList().get(hero.getCurrentLocationNum()+2);
            nextLocations[1] = hero.getLocationList().get(hero.getCurrentLocationNum()+3);
            System.out.println("----------------------------------------");
            System.out.println("Choose a location");
            System.out.println("You can select from:");
            System.out.println(nextLocations[0].getName() + "[1] or " + nextLocations[1].getName() + "[2]");
            locationChoice = scanner.nextInt();
            if (locationChoice == 1){
                hero.move(nextLocations[0], hero.getCurrentLocationNum()+2);
            } else if (locationChoice == 2) {
                hero.move(nextLocations[1], hero.getCurrentLocationNum()+3);
            }
            System.out.println("You have moved to " + hero.getCurrentLocation().getName());
            System.out.println("----------------------------------------");
            FightManager.fight(hero);
        } else {
            if (!movedToGoal){
                movedToGoal = true;
                hero.move(hero.getLocationList().get(hero.getLocationList().size()-1), hero.getLocationList().size()-1);
                System.out.println("You have moved to " + hero.getCurrentLocation().getName());
                FightManager.fight(hero);
            } else {
                Helpers.announce("You won");
            }

        }
    }
}
