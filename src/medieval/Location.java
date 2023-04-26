
package medieval;

import java.util.ArrayList;

public class Location {
    // Variable Init
    String name;
    int numOfEnemies;
    String welcomeMessage;
    String exitMessage;
    Item itemDrop;


    ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    /**
     * Location constructor if all arguments are given
     * @param name String
     * @param numOfEnemies int
     * @param welcomeMessage String
     * @param exitMessage String
     * @param itemDrop Item, the item dropped after completing Location, can be armor or weapon
     */
    public Location(String name, int numOfEnemies, String welcomeMessage, String exitMessage, Item itemDrop){
        this.setName(name);
        this.setNumOfEnemies(numOfEnemies);
        this.setWelcomeMessage(welcomeMessage);
        this.setExitMessage(exitMessage);
        this.setItemDrop(itemDrop);

        // Adding enemies
        for(int i = 0; i<numOfEnemies; i++){
            enemies.add(new Enemy());
        }
    }

    // Getters
    public String getName() {
        return this.name;
    }
    public int getNumOfEnemies() {
        return this.numOfEnemies;
    }
    public String getWelcomeMessage() {
        return welcomeMessage;
    }
    public String getExitMessage() {
        return exitMessage;
    }
    public Item getItemDrop() {
        return itemDrop;
    }
    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setNumOfEnemies(int numOfEnemies) {
        this.numOfEnemies = numOfEnemies;
    }
    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }
    public void setExitMessage(String exitMessage) {
        this.exitMessage = exitMessage;
    }
    public void setItemDrop(Item itemDrop) {
        this.itemDrop = itemDrop;
    }
}
