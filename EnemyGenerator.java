import java.util.Random;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
   /**
    EnemyGenerator.java, fills an arraylist with enemies from an enemies
    text file. The generateEnemy() method will create a random 
    enemy object which will be interacted with by the player, to be used in main.
  */
public class EnemyGenerator{
  private ArrayList <Enemy> enemylist  = new ArrayList<Enemy>();
    /**
    EnemyGenerator() - Constructs an array list to be populated
    with enemies from the enemies text file, makes sure a file is found
    with a try/catch block
    @param f - the local file to be filled by the contents of
    enemies.txt
    @param sc - scanner that takes in the contents of enemies.txt
    and will fill local file f
    @param line - string representing a single line of a file
    @param details - array of string (lines of enemies.txt), separating the names and HP values of the monsters in enemies.txt where there this a comma
    @param name - the name of the enemy in each line
    @param maxHp - the max hit points of the enemy in each line
    @param p - enemy object to be added to the enemylist array list 
  */
  public EnemyGenerator(){
    try{
    	File f = new File("Enemies.txt");
    	Scanner sc = new Scanner(f);
    	
    	while(sc.hasNextLine()){
    		String line = sc.nextLine();
    		String[] details = line.split(",");
    		String name = details[0];
    		int maxHp = Integer.parseInt(details[1]);
    		Enemy p = new Enemy (name, maxHp);
    		enemylist.add(p);
    	}
    	sc.close();
    }catch(FileNotFoundException e){
      System.out.println("File was not found.");

    }
   
  }
     /**
    generateEnemy() - Randomly determines which enemy from the list will
    be generated and randomly determines if that enemy is standard
    or magical
    @param randomEnemy - randomly selects which enemy from the list
    of enemies to be generated as an enemy object
    @param randomtype - randomly decides whether or not the generated 
    enemy object is standard or magical
  */
  public Enemy generateEnemy() {
	  Random rand = new Random();
	  int randomEnemy = rand.nextInt(enemylist.size()-1);
	  Enemy x = enemylist.get(randomEnemy);
	  
	  int randomtype = rand.nextInt(2)+1;
	  if(randomtype == 1) {
		  Enemy enemy = new MagicalEnemy("Magical " + x.getName(),x.getMaxHP());
		  return enemy;
		  
	  }
	  else{
		  Enemy enemy = new Enemy(x.getName(),x.getMaxHP());
		  return enemy;
	  }
	 
	  
	  
	  
	  
  }
   
  

}