
package medieval;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the game");
        
        
        Weapon m4 = new Weapon("M4A4", 100, 32);
        Character hero = new Character(100, 10, m4);

        FightManager.fight(hero);

        /*int deadEs = 0;
        Weapon m4 = new Weapon("M4A4", 50, 31);
            
        Character hero = new Character(100, 5);
        hero.setHP(100);
        hero.setStrength(100);
        hero.setPrW(m4);
        
        //Enemy[] enemies = new Enemy[5];
        ArrayList<Enemy> enemies = new ArrayList<Enemy>(); 
        for (int i = 0; i<10; i++){
            enemies.add(new Enemy());
            enemies.get(i).setPrW(m4);
        }
        
        
        for (Enemy e : enemies){
            if (hero.getHP()>0){
                System.out.println("Hero has won a fight against an enemy with " +  hero.getHP() + " hp remaining");
                FightManager.fight(hero, e);
                
                deadEs++;
            } else {
                System.out.println("Hero died and killed " + deadEs + " enemies");
                break;
            }
            //System.out.println(e.getHP());
        }

        hero.setPrW(m4);*/
        
    }
}
