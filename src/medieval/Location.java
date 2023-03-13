
package medieval;

import java.util.ArrayList;

public class Location {
    String name;
    int numOfEnemies;
    
    int numOfLocations;
    int currentLocation;
    
    
    ArrayList<Location> nextLocation = new ArrayList();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    
    public Location(String name, int numOfEnemies){        
        this.setName(name);
        this.setNumOfEnemies(numOfEnemies);
        
        for(int i = 0; i<numOfEnemies; i++){
            enemies.add(new Enemy());
        }
        
    }

    public String getName() {
        return name;
    }
    public int getNumOfEnemies() {
        return numOfEnemies;
    }
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    

    public void setName(String name) {
        this.name = name;
    }
    public void setNumOfEnemies(int numOfEnemies) {
        this.numOfEnemies = numOfEnemies;
    }
    
    
}
