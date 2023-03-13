
package medieval;

import java.util.Random;

public class Enemy {
    Random rand = new Random();

    String[] nameList = new String[] {"Brock", "Heisenberg", "Jake", "John", "Robert", "Rudolf", "Emily", "Linus", "Walter", "Hank", "Marie", "Skyler", "Mike", "Mathew", "Greg", "Craig", "Jimmy", " Saul", ""};
    private String name;
    private int hp;
    private int strength;
    private Weapon prW;
    private boolean dead;

    /**
     * Enemy constructor if HP and Strength arguments are given
     * @param hp
     * @param strength
     */
    public Enemy(String name, int hp, int strength){
        this.setName(name);
        this.setHP(hp);
        this.setStrength(strength);
    }

    /**
     * Enemy constructor if no arguments are given
     */
    public Enemy(){
        int nameRand = rand.nextInt(nameList.length);
        //System.out.println(nameRand);
        this.setName(nameList[nameRand]);
        this.setHP(rand.nextInt(100)+1);
        this.setStrength(rand.nextInt(10)+1);
    }
    
    /**
     * Heals the enemy of given amount.
     * If value is negative, it becomes 0.
     * @param heal
     */
    public void heal(int heal){
        if (heal<0)heal=0;
        this.setHP(this.getHP()+heal);
    }

    /**
     * Attacks the given Character
     * Only if this Enemy is not dead
     * @param hero
     */
    public void attack(Character hero){
        if (this.getHP()!=0){
            hero.setHP(hero.getHP() - this.getStrength()); //this.getPrW().getDmg()+
            //getPrW().setDrb(getPrW().getDrb()-5);
            System.out.println(this.getName() + " has hit the hero for " + this.getStrength() + " damage");
        } else this.die();
        hero.die();
    }

    /**
     * If HP of this Enemy is 0, Enemy is deleted
     */
    public void die(){
        if (!this.isDead()){
            if(this.getHP()<=0){
                this.setDead(true);
                System.out.println(this.getName() + " was slain by the hero");
            }
        }

    }

    public String getName() {
        return name;
    }
    int getHP() {
        //this.die();
        return this.hp;
    }
    int getStrength(){
        return this.strength;
    }
    Weapon getPrW() {
        return prW;
    }
    public boolean isDead() {
        return dead;
    }

    void setHP(int hp){
        if (hp > 100){
            this.hp = 100;
        } else if(hp<0){
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }

    public void setName(String name) {
        this.name = name;
    }
    void setStrength(int strength){
        this.strength = strength;
    }
    void setPrW(Weapon prW) {
        this.prW = prW;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }

}
