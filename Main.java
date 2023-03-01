/**
	 * Edward Ahn, Steven Nguyen, Donovan Saenz
	 * CECS 277
	 * Project 1
   * Group #15
	 * 3/11/21
	 */
import java.util.Scanner;
import java.util.Random;
import java.awt.Point;
/**
	 * Main class
	 * Gets the input from the user for name, movement, fight/run, etc.
   * Runs until hero has no more hp
	 */
class Main {
  public static void main(String[] args){
    System.out.print("What is your name, traveler? ");
    String name = CheckInput.getString();
    Hero h1 = new Hero(name);
    System.out.print(h1);
    /**
    * Checks to see if user health is greater than zero
    */
    while (h1.getHP()>0){
      System.out.println("1. Go North");
      System.out.println("2. Go South");
      System.out.println("3. Go East");
      System.out.println("4. Go West");
      System.out.println("5. Quit");
      int choice = CheckInput.getIntRange(1,5);
      /**
      * Checks to see if user input is between 0 and 6
      */
      if (choice>0 && choice<6){
        /**
        * if choice 1, go north, choice 2 is south, choice 3 is east and choice 4 is west, choice 5 will exit the game
        * if char at this point is 'i' we heal the hero
        * if it is 'm', we will generate a monster and transfer into monsterRoom
        * if it is 'f', we found the exit and will finish the level
        * if it is 'n', there is nothing there
        * if it is 's', we are at the start
        */
        if (choice ==1){
          char north = h1.goNorth();
          if(north == 'i'){
            h1.heal(25);
            System.out.print("You found a Health Potion! You drink it to restore your health.");
            System.out.println(" ");
          }
          else if(north == 'm')
          {
            EnemyGenerator enemy = new EnemyGenerator();
            Enemy monster = enemy.generateEnemy();
            monsterRoom(h1, monster);
          }
          else if (north == 'f'){
            h1.levelUp();
            System.out.println("You found the exit. Proceeding to the next level. ");
            System.out.println(h1);
          }
          else if (north == 'n'){
            System.out.println("There's nothing here. ");
          }
          else if (north == 's'){
            System.out.println("You're back at the start ");
          }

          System.out.println(h1);
        }
        else if (choice == 2){
          char south = h1.goSouth();
          if(south == 'i'){
            h1.heal(25);
            System.out.print("You found a Health Potion! You drink it to restore your health.");
            System.out.println(" ");
          }
           else if(south == 'm')
           {
             EnemyGenerator enemy = new EnemyGenerator();
             Enemy monster = enemy.generateEnemy();
             monsterRoom(h1, monster);
          }
          else if (south == 'f'){
            h1.levelUp();
            System.out.println("You found the exit. Proceeding to the next level. ");
            System.out.println(h1);
            
          }
          else if (south == 'n'){
            System.out.println("There's nothing here. ");
          }
          else if (south == 's'){
            System.out.println("You're back at the start ");
          }

          System.out.println(h1);
        }
        else if (choice == 3){
          char east = h1.goEast();
          if(east == 'i'){
            h1.heal(25);
            System.out.print("You found a Health Potion! You drink it to restore your health.");
            System.out.println(" ");
          }
          else if(east == 'm')
          {
            EnemyGenerator enemy = new EnemyGenerator();
            Enemy monster = enemy.generateEnemy();
            monsterRoom(h1, monster);
          }
          else if (east == 'f'){
            h1.levelUp();
            System.out.println("You found the exit. Proceeding to the next level. ");
            System.out.println(h1);
          }
          else if (east == 'n'){
            System.out.println("There's nothing here. ");
          }
          else if (east == 's'){
            System.out.println("You're back at the start ");
          }

          System.out.println(h1);
        }
        else if (choice ==4){
          char west = h1.goWest();
          if(west== 'i'){
            h1.heal(25);
            System.out.print("You found a Health Potion! You drink it to restore your health.");
            System.out.println(" ");
          }
          else if(west == 'm')
          {
            EnemyGenerator enemy = new EnemyGenerator();
            Enemy monster = enemy.generateEnemy();
            monsterRoom(h1, monster);
          }
          else if (west == 'f'){
            h1.levelUp();
            System.out.println("You found the exit. Proceeding to the next level. ");
            System.out.println(h1);
          }
          else if (west == 'n'){
            System.out.println("There's nothing here. ");
          }
          else if (west == 's'){
            System.out.println("You're back at the start ");
          }

          System.out.println(h1);
        
        }
        else{
          System.out.println("You have quit.");
          break;
        }
      
        }
     
      }
    }
    /**
    * We have entered the monsterRoom which displays what monster we encountered and gives us an option to either fight or run away
    * If we choose to fight it takes us to the fight method
    * If we choose to run, there will be a random number generated which will determine our random position
    * @param Hero h - the hero we created
    * @param Enemy e - the enemy we generated
    * @return static boolean
    */
      public static boolean monsterRoom(Hero h, Enemy e)
   { 
     System.out.println("You have encountered a " +e);
     System.out.println("Fight, or run away?");
     System.out.println("1. Fight");
     System.out.println("2. Run Away");
    int fightOrFlight = CheckInput.getIntRange(1,2);
      if(fightOrFlight == 1){
        fight(h, e);
        if(h.getHP() <=0){
        return false;}
      }
      else if(fightOrFlight == 2){
        System.out.println("You have chosen to escape");
        Random rand = new Random();
            int randomDirection = rand.nextInt(4)+1;
             if (randomDirection == 1){     
              char north = h.goNorth();
              if (north == 'f') {
                h.levelUp();
                System.out.println("You found the exit. Proceeding to the next level. ");
              }
             }
             else if (randomDirection == 2){    
               char south = h.goSouth();
               if (south == 'f'){
                 h.levelUp();
                 System.out.println("You found the exit. Proceeding to the next level. ");
               }    
             }        
             else if (randomDirection == 3){     
              char east = h.goEast();
              if (east == 'f') {
                h.levelUp();
                System.out.println("You found the exit. Proceeding to the next level. ");
              }
             }
             else if (randomDirection == 4){    
              char west = h.goWest();
              if (west == 'f'){
                h.levelUp();
                System.out.println("You found the exit. Proceeding to the next level. ");
              }
             }

      }
      return true;
   }

   /**
	 * the first thing we do when we enter the fight is to check if hero's hp is greater than zero
	 * There is an option for physical or magical attack(magic missile, fireball and thunderclap)
	 * If we choose to run, we are put in a random spot again
   * We also check the enemy's health in order to keep fighting or end
	 * @param Hero h - the hero we created
   * @param Enemy e - the enemy we generated
	 * @return static boolean
	 */
   public static boolean fight(Hero h, Enemy e){ 
     boolean proceed = true;
    do{
       if (h.getHP() > 0)
       {
         System.out.println(h.toString());
        System.out.println(e.toString());
        System.out.println("You have chosen to fight, how will you attack?");//extra
        System.out.println("1. Physical Attack");
        System.out.println("2. Magical Attack");
        int attackChoice = CheckInput.getIntRange(1,2);
   
      if(attackChoice == 1){
         System.out.println(h.attack(e));
      
        if(e.getHP() > 0 &&e instanceof MagicalEnemy){
              MagicalEnemy enemy = (MagicalEnemy) e;
              System.out.println(enemy.attack(h));
              System.out.println(h);
              System.out.println(enemy);
              System.out.println("1. Fight");
              System.out.println("2. Run Away");
              int fightOrRun = CheckInput.getIntRange(1,2);
              if(fightOrRun ==1){
                proceed = true;
              }
              else{
                Random rand = new Random();
                int randomDirection = rand.nextInt(4)+1;
                if(randomDirection == 1){     
                  char north = h.goNorth();
                  if (north == 'f') {
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                  
                }
                else if (randomDirection == 2){     
                  char south = h.goSouth(); 
                  if(south == 'f'){
                     h.levelUp();
                     System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                }
                else if (randomDirection == 3){     
                 char east = h.goEast();
                 if( east == 'f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                else if (randomDirection == 4){     
                 char west = h.goWest();
                 if(west =='f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                proceed = false;
              }
        }
        else if(e.getHP() > 0){
             System.out.println(e.attack(h));
             System.out.println(h);
             System.out.println(e);
             System.out.println("1. Fight");
             System.out.println("2. Run Away");
             int fightOrRun = CheckInput.getIntRange(1,2);
            if(fightOrRun ==1){
              proceed = true;
            }
            else{
                Random rand = new Random();
                int randomDirection = rand.nextInt(4)+1;
                if(randomDirection == 1){     
                  char north = h.goNorth();
                  if (north == 'f') {
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                  
                }
                else if (randomDirection == 2){     
                  char south = h.goSouth(); 
                  if(south == 'f'){
                     h.levelUp();
                     System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                }
                else if (randomDirection == 3){     
                 char east = h.goEast();
                 if( east == 'f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                else if (randomDirection == 4){     
                 char west = h.goWest();
                 if(west =='f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                proceed = false;
              }
           }          
      }
      /**
      * Here we choose the magical attack we would like to use
      * We will keep going until enemy hp < 0, there will be option to run or fight each round
      */
      else if(attackChoice ==2) {
        System.out.println(Magical.MAGIC_MENU);
        System.out.println("Which attack will you use?");
        int magicChoice = CheckInput.getIntRange(1,3);

        if(magicChoice == 1)
        {
          System.out.println(h.magicMissile(e));
          if(e.getHP() > 0 && e instanceof MagicalEnemy)
          {
            MagicalEnemy enemy = (MagicalEnemy) e;
            System.out.println(enemy.attack(h));
            System.out.println(h);
            System.out.println(enemy);
            System.out.println("1. Fight");
            System.out.println("2. Run Away");
            int fightOrRun = CheckInput.getIntRange(1,2);
            if(fightOrRun ==1){
              proceed = true;
              }
            else{
                Random rand = new Random();
                int randomDirection = rand.nextInt(4)+1;
                if(randomDirection == 1){     
                  char north = h.goNorth();
                  if (north == 'f') {
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                  
                }
                else if (randomDirection == 2){     
                  char south = h.goSouth(); 
                  if(south == 'f'){
                     h.levelUp();
                     System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                }
                else if (randomDirection == 3){     
                 char east = h.goEast();
                 if( east == 'f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                else if (randomDirection == 4){     
                 char west = h.goWest();
                 if(west =='f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                proceed = false;
              }
          }
          else if(e.getHP() > 0)
          {
            System.out.println(e.attack(h));
            System.out.println(h);
            System.out.println(e);
            System.out.println("1. Fight");
            System.out.println("2. Run Away");
            int fightOrRun = CheckInput.getIntRange(1,2);
            if(fightOrRun ==1){
              proceed = true;
              }
            else{
                Random rand = new Random();
                int randomDirection = rand.nextInt(4)+1;
                if(randomDirection == 1){     
                  char north = h.goNorth();
                  if (north == 'f') {
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                  
                }
                else if (randomDirection == 2){     
                  char south = h.goSouth(); 
                  if(south == 'f'){
                     h.levelUp();
                     System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                }
                else if (randomDirection == 3){     
                 char east = h.goEast();
                 if( east == 'f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                else if (randomDirection == 4){     
                 char west = h.goWest();
                 if(west =='f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                proceed = false;
              }
          }
        }

        if(magicChoice == 2)
        {
          System.out.println(h.fireball(e));
          if(e.getHP() > 0 && e instanceof MagicalEnemy)
          {
            MagicalEnemy enemy = (MagicalEnemy) e;
            System.out.println(enemy.attack(h));
            System.out.println(h);
            System.out.println(enemy);
            System.out.println("1. Fight");
            System.out.println("2. Run Away");
            int fightOrRun = CheckInput.getIntRange(1,2);
            if(fightOrRun ==1){
              proceed = true;
              }
            else{
                Random rand = new Random();
                int randomDirection = rand.nextInt(4)+1;
                if(randomDirection == 1){     
                  char north = h.goNorth();
                  if (north == 'f') {
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                  
                }
                else if (randomDirection == 2){     
                  char south = h.goSouth(); 
                  if(south == 'f'){
                     h.levelUp();
                     System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                }
                else if (randomDirection == 3){     
                 char east = h.goEast();
                 if( east == 'f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                else if (randomDirection == 4){     
                 char west = h.goWest();
                 if(west =='f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                proceed = false;
              }
          }
          else if(e.getHP() > 0)
          {
            System.out.println(e.attack(h));
            System.out.println(h);
            System.out.println(e);
            System.out.println("1. Fight");
            System.out.println("2. Run Away");
            int fightOrRun = CheckInput.getIntRange(1,2);
            if(fightOrRun ==1){
              proceed = true;
              }
            else{
                Random rand = new Random();
                int randomDirection = rand.nextInt(4)+1;
                if(randomDirection == 1){     
                  char north = h.goNorth();
                  if (north == 'f') {
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                  
                }
                else if (randomDirection == 2){     
                  char south = h.goSouth(); 
                  if(south == 'f'){
                     h.levelUp();
                     System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                }
                else if (randomDirection == 3){     
                 char east = h.goEast();
                 if( east == 'f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                else if (randomDirection == 4){     
                 char west = h.goWest();
                 if(west =='f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                proceed = false;
              }
          }
        }

        if(magicChoice == 3)
        {
          System.out.println(h.thunderclap(e));
          if(e.getHP() > 0 && e instanceof MagicalEnemy)
          {
            MagicalEnemy enemy = (MagicalEnemy) e;
            System.out.println(enemy.attack(h));
            System.out.println(h);
            System.out.println(enemy);
            System.out.println("1. Fight");
            System.out.println("2. Run Away");
            int fightOrRun = CheckInput.getIntRange(1,2);
            if(fightOrRun ==1){
              proceed = true;
              }
            else{
                Random rand = new Random();
                int randomDirection = rand.nextInt(4)+1;
                if(randomDirection == 1){     
                  char north = h.goNorth();
                  if (north == 'f') {
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                  
                }
                else if (randomDirection == 2){     
                  char south = h.goSouth(); 
                  if(south == 'f'){
                     h.levelUp();
                     System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                }
                else if (randomDirection == 3){     
                 char east = h.goEast();
                 if( east == 'f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                else if (randomDirection == 4){     
                 char west = h.goWest();
                 if(west =='f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                proceed = false;
              }
          }
          else if(e.getHP() > 0)
          {
            System.out.println(e.attack(h));
            System.out.println(h);
            System.out.println(e);
            System.out.println("1. Fight");
            System.out.println("2. Run Away");
            int fightOrRun = CheckInput.getIntRange(1,2);
            if(fightOrRun ==1){
              proceed = true;
              }
            else{
                Random rand = new Random();
                int randomDirection = rand.nextInt(4)+1;
                if(randomDirection == 1){     
                  char north = h.goNorth();
                  if (north == 'f') {
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                  
                }
                else if (randomDirection == 2){     
                  char south = h.goSouth(); 
                  if(south == 'f'){
                     h.levelUp();
                     System.out.println("You found the exit. Proceeding to the next level. ");
                  }
                }
                else if (randomDirection == 3){     
                 char east = h.goEast();
                 if( east == 'f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                else if (randomDirection == 4){     
                 char west = h.goWest();
                 if(west =='f'){
                    h.levelUp();
                    System.out.println("You found the exit. Proceeding to the next level. ");
                 }
                }
                proceed = false;
              }
          }
        }
      }
       }
       if (h.getHP() == 0) {
         System.out.println("Hero " + h.getName() + " has no more hp. Game Over");
         break;
       }
      
     }
     while(e.getHP() > 0 && h.getHP() > 0 && proceed == true);
     if (e.getHP() == 0) {
       System.out.println("You have slain " + e.getName());
     }
      return true;
   }
}

   