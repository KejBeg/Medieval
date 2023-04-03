
package medieval;

import java.util.ArrayList;

public class Location {
    String name;
    int numOfEnemies;
    String welcomeMessage;
    String exitMessage;


    ArrayList<Enemy> enemies = new ArrayList<Enemy>();


    public Location(String name, int numOfEnemies, String welcomeMessage, String exitMessage){
        this.setName(name);
        this.setNumOfEnemies(numOfEnemies);
        this.setWelcomeMessage(welcomeMessage);
        this.setExitMessage(exitMessage);

        for(int i = 0; i<numOfEnemies; i++){
            enemies.add(new Enemy());
        }
    }


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
    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }
    

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
}
