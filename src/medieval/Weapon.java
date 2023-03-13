
package medieval;

public class Weapon {
    String name;
    private int drb;
    private int dmg;
    
    public Weapon(String name, int drb, int dmg){
        this.setName(name);
        this.setDrb(drb);
        this.setDmg(dmg);
    }
    
    
    
    public String getName(){
        return this.name;
    }
    
    public int getDrb(){
        return this.drb;
    }
    
    public int getDmg(){
        return this.dmg;
    }
    
    
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setDrb(int drb){
        this.drb = drb;
    }
    
    public void setDmg(int dmg){
        this.dmg = dmg;
    }
    
}
