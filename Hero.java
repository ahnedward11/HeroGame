import java.util.Random;
import java.awt.Point;
 /**
    Hero.java - class with a hero constructor and attack methods,
    movement methods, level up methods, etc.
  */
public class Hero extends Entity implements Magical{
  //Hero's map,
  private Map map;
  //hero's current location
  private Point position;
  //the level that the hero is on
  private int level;

/**
    Hero constuctor, starting off the hero with a name, 25 max hit points,
    level 1, a new map and a location at the start of map 1.
  */
  public Hero(String n) {
    super(n, 25); 
    level = 1;
    map = new Map();
    map.loadMap(level);
    position = new Point(map.findStart());
  }
/**
    toString() - Method that returns a string containing the 
    hero's name, current level, and map with revealed rooms and current position of the Hero Object
  */
  @Override
  public String toString() {
    return super.toString() + "\nLevel: " + level + "\n" + map.mapToString(position); 
  }
/**
    attack(Entity e) - Regular/physical attack method that rolls a random 
    integer damage between one and three, reducing an enemy object's 
    current HP by said damage.
    @param damage - initialized at 0 and then randomly generates damage
    between one and three
    @return - a string with the name of the hero, the enemy that they hit
    and the damage done to said target
  */
  @Override
  public String attack(Entity e){
    int damage = 0;
    damage = (int) (Math.random() * (3) + 1);
    e.takeDamage(damage);
    return getName() + " hits " + e.getName() + " for " + damage + " damage. ";
  }
  /**
    levelUP() - Increases the hero's level at the finish of each map,
    and will loop through the three maps, starting at the finish of the 
    previous map depending on the remainder of the level modulo 3.
  */
  public void levelUp(){
    level++;
    if (level%3 ==1){ 
      map.loadMap((1));
      position = map.findStart();
    }
    if (level%3 ==2){ 
      map.loadMap((2));
      position = map.findStart();
    }
    if (level%3 ==0){ 
      map.loadMap((3));
      position = map.findStart();
    }
  }
  /**
  goNorth() - Removes the character at the location that the Hero 
  has already visited, replacing it with a null/n value. 
  Moves the character up one space in the Y direction, and checks if 
  the Hero moves out of bound, prompting the user that they can not
  move that way. If they do go out of bounds, the movement is reversed, 
  and they are placed where they were previously. This method also 
  reveals the spot that the hero moves to. Returns the character at
  that location.
  */
  public char goNorth(){
    map.removeCharAtLoc(position);
    position.translate(-1, 0); // up 1
    if (position.getX() < 0){ // check if out of map
      System.out.println("You are out of bounds");
      position.translate(1, 0);
    }
    map.reveal(position);
    return map.getCharAtLoc(position);
  }
   /**
  goSouth() - Removes the character at the location that the Hero 
  has already visited, replacing it with a null/n value. 
  Moves the character down one space in the Y direction, and checks if 
  the Hero moves out of bounds, prompting the user that they can not
  move that way. If they do go out of bounds, the movement is reversed, 
  and they are placed where they were previously. This method also 
  reveals the spot that the hero moves to. Returns the character at
  that location.
  */
  public char goSouth(){
    map.removeCharAtLoc(position);
    position.translate(1, 0); // down 1
    if (position.getX() > 4){
      System.out.println("You are out of bounds");
    position.translate(-1, 0);
    }
    map.reveal(position);
    return map.getCharAtLoc(position);
  }
    /**
  goWest() - Removes the character at the location that the Hero 
  has already visited, replacing it with a null/n value. 
  Moves the character left one space in the X direction, and checks if 
  the Hero moves out of bounds, prompting the user that they can not
  move that way. If they do go out of bounds, the movement is reversed, 
  and they are placed where they were previously. This method also 
  reveals the spot that the hero moves to. Returns the character at
  that location.
  */
  public char goWest(){
    map.removeCharAtLoc(position);
    position.translate(0, -1); // left 1
    if (position.getY() < 0){
      System.out.println("You are out of bounds");
      position.translate(0, 1);
    }
    map.reveal(position);
    return map.getCharAtLoc(position);
  }
     /**
  goEast() - Removes the character at the location that the Hero 
  has already visited, replacing it with a null/n value. 
  Moves the character right one space in the X direction, and checks if 
  the Hero moves out of bounds, prompting the user that they can not
  move that way. If they do go out of bounds, the movement is reversed, 
  and they are placed where they were previously. This method also 
  reveals the spot that the hero moves to. Returns the character at
  that location.
  */
  public char goEast(){
    map.removeCharAtLoc(position);
    position.translate(0, 1); // right 1
    if (position.getY() > 4){
      System.out.println("You are out of bounds");
      position.translate(0, -1);
    }
    map.reveal(position);
    return map.getCharAtLoc(position);
  }
  /**
    magicMissile(Entity e) - Magical missle attack method that rolls a random 
    integer damage between one and three, reducing an enemy object's 
    current HP by said damage.
    @param randomDamage -  randomly generated damage
    between one and three
    @return - a string with the name of the hero, the enemy that they hit
    and the damage done to said target, with the magic missile
  */

  @Override
  public String magicMissile(Entity e)
  {
    Random rand = new Random();
    int randomDamage = rand.nextInt(3)+1; 
    e.takeDamage(randomDamage);
    return getName() + " hits " + e.getName() + " with a Magical Missile for " + randomDamage + ".";
  }
   /**
    fireball(Entity e) - Magical fireball attack method that rolls a random 
    integer damage between one and three, reducing an enemy object's 
    current HP by said damage.
    @param randomDamage -  randomly generated damage
    between one and three
    @return - a string with the name of the hero, the enemy that they hit
    and the damage done to said target, with the fireball
  */

  @Override
  public String fireball(Entity e)
  {
    Random rand = new Random();
    int randomDamage = rand.nextInt(3)+1;
    e.takeDamage(randomDamage);
    return getName() + " hits " + e.getName() + " with a fireball for " + randomDamage + ".";
  }
 /**
    thunderclap(Entity e) - Thunderclap attack method that rolls a random 
    integer damage between one and six, reducing an enemy object's 
    current HP by said damage.
    @param randomDamage -  randomly generated damage
    between one and six
    @return - a string with the name of the hero, the enemy that they hit
    and the damage done to said target, with the thunderclap
  */
  @Override
  public String thunderclap(Entity e)
  {
    Random rand = new Random();
    int randomDamage = rand.nextInt(6)+1; 
    e.takeDamage(randomDamage);
    return getName() + " hits " + e.getName() + " with thunderclap for " + randomDamage + ".";
  }
}