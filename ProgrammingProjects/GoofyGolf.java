
/*********************************************************************************
*
* John Naylor'
* CMSC255 Section 2
* Goofy Golf
* Project 6
*
* The program inputs a text file as a command line argument
* The file is parsed and formated in a way to display the player's
* score for each hole and whether they were above or below par
*
* The user must enter the input text file as a command line argument
***********************************************************************************/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

public class GoofyGolf{

  private static Scanner userInput = new Scanner(System.in);

  /*********************************************************************************
  * 2D array containing the value of par for each hole for each age range
  * The first row is 0-4,
  * second is 4-7,
  * third is 8-11,
  * fourth is 12-15,
  * and the last is 16 and higher
  *********************************************************************************/
  private static int[][] parVals = {{8, 8, 9, 7, 5, 7 ,8, 5, 8},
                                    {7, 7, 8, 6, 5, 6, 7, 5, 6},
                                    {6, 5, 6, 5, 4, 5, 5, 4, 5},
                                    {5, 4, 4, 4, 3, 4, 3, 3, 4},
                                    {4, 3, 3, 3, 2, 3, 2, 3, 3}};

  // Constant for the number of holes so the program didn't have random nines everywhere
  private static final int HOLES = 9;

  public static void main(String[] argv) throws FileNotFoundException{

    // Mandatory print header method
    printHeader();

    // Declaring the variable that will hole the data file
    File golfData;

    /*********************************************************************************************
    * First the program checks whether the user actually put a file in the command line arguments
    * if they failed to do that then the user is prompted to enter one
    *********************************************************************************************/
    if(argv.length > 0){
      golfData = new File(argv[0]);
    }else{
      System.out.print("Enter file:");
      golfData = new File(userInput.next());
    }

    /********************************************************************
    * The scrapeFile method is called on the data file.
    * The resulting ArrayList created contains all the of players
    * with their data being stored in a Player object
    ********************************************************************/
    ArrayList<Player> golfPlayers = scrapeFile(golfData);

    /*************************************************************************************
    * The ArrayList of players is printed in the terminal using the printPlayers method
    * The method is responsible for formatting them correctly
    **************************************************************************************/
    printPlayers(golfPlayers);
  }

  /******************************************************************************
  * printPlayers outputs the player objects for an ArrayList in the terminal
  * It leaves a newline between each player
  * @params ArrayList containing player objects
  *******************************************************************************/
  private static void printPlayers(ArrayList<Player> playerList){
    for(Player p : playerList){
      System.out.println(p);
      System.out.println();
    }
  }

  /*******************************************************************************
  * parChecker decided whether the player is above, below, or on par
  * @params The age of the player
  * @params The score the player got
  * @params The hole they got the score on
  * @returns A string staying whether they were above, below, or on par
  ******************************************************************************/
  private static String parChecker(int age, int score, int hole){
    int index = ageToRow(age);
    int parVal = parVals[index][hole];

    // index and hole are used to identify the correct value in the global 2D array

    if(score > parVal){
      return "over par";
    }else if(score == parVal){
      return "par";
    }else{
      return "under par";
    }

  }

  /**************************************************************************
  * ageToRow transforms a player's age into the appropriate
  * row in the global list of par values
  * @params The age of the player
  * @returns The row associated with that age
  ***************************************************************************/
  private static int ageToRow(int age){

    // check age range and return row for that range
    if(age <= 4){
      return 0;
    }else if(age <= 7){
      return 1;
    }else if(age <= 11){
      return 2;
    }else if(age <= 15){
      return 3;
    }else{
      return 4;
    }
  }

  /***********************************************************************
  * sumOfArray simply adds all of the elements in an array
  * @params An Array of integers
  * @returns The sum of the elements
  ************************************************************************/
  public static int sumOfArray(int[] values){
    int sum = 0;

    // Loop through every value and add it to a global variable
    for(int value : values){
      sum += value;
    }

    return sum;
  }

  /******************************************************************************************
  * scrapeFile parses the file containing player data
  * The player data is wrapped into a Player object and added to an ArrayList
  * @params The file containing the data with all of the player data in the correct format
  * @returns An ArrayList of Players
  *******************************************************************************************/
  private static ArrayList<Player> scrapeFile(File dataFile) throws FileNotFoundException{


      Scanner fileReader = new Scanner(dataFile);
      ArrayList<Player> players = new ArrayList<Player>();
      int lineCounter = 1;

      String playerName;
      int playerAge;
      int[] playerScores = new int[HOLES];
      String[] playerParStatus = new String[HOLES];
      int[] playerTotalPar = new int[HOLES];

      // Main loop for giong through every token in the file
      while(fileReader.hasNext()){

        // All of the array have to be initialized as new arrays to avoid any aliasing problems
        playerScores = new int[HOLES];
        playerParStatus = new String[HOLES];
        playerTotalPar = new int[HOLES];

        //Beginning of the main scraping block
        try{

          // Data should be in the form Name  Age Hole1-10 Scores

          playerName = fileReader.next();

          playerAge = fileReader.nextInt();

          for(int i = 0; i < HOLES; i++){
            playerScores[i] = fileReader.nextInt();
            playerParStatus[i] = parChecker(playerAge, playerScores[i], i);;
          }

          playerTotalPar = parVals[ageToRow(playerAge)];

          // New Player object created with the newly scraped data
          Player player = new Player(playerName, playerAge, playerScores, playerParStatus, playerTotalPar);

          // Player is added to the ArrayList
          players.add(player);


          // If some of the data isn't in the correct format this error is caught
        }catch(InputMismatchException e){
          System.out.println("[!!!] Some of the data isn't in the correct format! Line " + lineCounter + " skipped");
          // dump collects all of the data after the error in the line
          String dump = fileReader.nextLine();
        }

        lineCounter++;
      }

      //Finally close the file and return the players ArrayList
      fileReader.close();
      return players;

  }

  /*******************************************************
  * Prints the header for the class
  ********************************************************/
  private static void printHeader(){
    System.out.println("John Naylor");
    System.out.println("CMSC255 Section 2");
    System.out.println("Goofy Golf");
    System.out.println("Project 6");
    System.out.println();
  }
}

/*******************************************************************
* Player class is used mainly as a container for the golf data
* Sort of like a C struct
******************************************************************/
class Player{

  public String name;
  public int age;
  public int[] scores;
  public String[] parStatus;
  public int totalPar;

  /**************************************************************************
  * Constructor assigns all of the input values to the internal variables
  **************************************************************************/
  public Player(String name, int age, int[] scores, String[] parStatus, int[] totalPar){
    this.name = name;
    this.age = age;
    this.scores = scores;
    this.parStatus = parStatus;
    this.totalPar = sumOfArray(totalPar);
  }

  /**********************************************************************
  * This method is the same as the one in the GoofyGolf class
  * I had trouble looking for an elegant way to implement this
  * but gave up and just wrote the same method in two classes
  * @params Array of integers
  * @returns Sum of the elements in the array
  **********************************************************************/
  public static int sumOfArray(int[] values){
    int sum = 0;

    for(int value : values){
      sum += value;
    }

    return sum;
  }

  /******************************************************************************
  * Similar to parChecker in the GoofyGolf class
  * Instead of finding par for individual values
  * the method compares the total score to the sum of the row
  * @returns A string saying whether in player is above, below, or equal to par
  *******************************************************************************/
  public String totalParChecker(){
    if(totalPar > sumOfArray(scores)){
      return (totalPar - sumOfArray(scores)) + "point(s) under par";
    }else if(totalPar == sumOfArray(scores)){
      return "Equal to par";
    }else{
      return (sumOfArray(scores) - totalPar) + " point(s) over par";
    }
  }

  // Formatting who the player gets displayed 
  @Override
  public String toString(){

    return name + ":\n" +
            "Hole 1 - " + scores[0] + " " + parStatus[0] + "\n" +
            "Hole 2 - " + scores[1] + " " +  parStatus[1] + "\n" +
            "Hole 3 - " + scores[2] + " " +  parStatus[2] + "\n" +
            "Hole 4 - " + scores[3] + " " +  parStatus[3] + "\n" +
            "Hole 5 - " + scores[4] + " " +  parStatus[4] + "\n" +
            "Hole 6 - " + scores[5] + " " +  parStatus[5] + "\n" +
            "Hole 7 - " + scores[6] + " " +  parStatus[6] + "\n" +
            "Hole 8 - " + scores[7] + " " +  parStatus[7] + "\n" +
            "Hole 9 - " + scores[8] + " " +  parStatus[8] + "\n" +
            "Total score: " + sumOfArray(scores) + "(" + totalParChecker() + ")";

  }

}
