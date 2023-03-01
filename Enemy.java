 /**
    Enemy.java ,  subclass extended from Entity, with an enemy constructor
    and attack method
  */
import java.util.Random;
public class Enemy extends Entity{
   /**
    Constructs an enemy object with a name, n and max HP, m HP,
    referencing the variables by the same name in Entity.java
     @param n - name of the enemy
    @param mHp - Maximum hit points
  */
  public Enemy(String n,int mhp){
    super(n,mhp);
  }
  @Override
   /**
    attack(Entity e) Enemy's attack method returning a string with the enemy's name,
    and the random damage done when they attack
     @param random damge generates a whole number
     for damage, between 1 and 11
  */
  public String attack(Entity e){
    Random rand = new Random();
    int randomDamage = rand.nextInt(11)+1; 
    e.takeDamage(randomDamage);
    return getName() + " hits " + e.getName() + " for " + randomDamage + " damage ";

  }
  
}
  
 