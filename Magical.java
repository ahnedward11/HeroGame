 /**
    Magical.java - magic menu and implements interface
    * MagicalEnemy and Hero both use Magical
    * Each method takes in entity e and returns a string
    * All three are overriden in other classes
  */
public interface Magical{
  public static final String MAGIC_MENU = "1. Magic Missile\n2. Fireball\n3. Thunderclap";
  
  public String magicMissile(Entity e);
  
  public String fireball(Entity e);

  public String thunderclap(Entity e);

}