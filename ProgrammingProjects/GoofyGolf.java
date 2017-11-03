
/*********************************************************************************
*
* John Naylor'
* CMSC255 Section 2
* Goofy Golf
* Project 6
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

  private static int[][] parVals = {{8, 8, 9, 7, 5, 7 ,8, 5, 8},
                                    {7, 7, 8, 6, 5, 6, 7, 5, 6},
                                    {6, 5, 6, 5, 4, 5, 5, 4, 5},
                                    {5, 4, 4, 4, 3, 4, 3, 3, 4},
                                    {4, 3, 3, 3, 2, 3, 2, 3, 3}};

  private static final int HOLES = 9;

  public static void main(String[] argv) throws FileNotFoundException{

    printHeader();

    File golfData;

    if(argv.length > 0){
      golfData = new File(argv[0]);
    }else{
      System.out.print("Enter file:");
      golfData = new File(userInput.next());
    }

    ArrayList<Player> golfPlayers = scrapeFile(golfData);

    printPlayers(golfPlayers);
  }

  private static void printPlayers(ArrayList<Player> playerList){
    for(Player p : playerList){
      System.out.println(p);
      System.out.println();
    }
  }

  private static String parChecker(int age, int score, int hole){
    int index = ageToRow(age);
    int parVal = parVals[index][hole];

    if(score > parVal){
      return "over par";
    }else if(score == parVal){
      return "par";
    }else{
      return "under par";
    }

  }

  private static int ageToRow(int age){
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

  public static int sumOfArray(int[] values){
    int sum = 0;

    for(int value : values){
      sum += value;
    }

    return sum;
  }

  private static ArrayList<Player> scrapeFile(File dataFile) throws FileNotFoundException{

      Scanner fileReader = new Scanner(dataFile);
      ArrayList<Player> players = new ArrayList<Player>();
      int lineCounter = 1;

      String playerName;
      int playerAge;
      int[] playerScores = new int[HOLES];
      String[] playerParStatus = new String[HOLES];
      int[] playerTotalPar = new int[HOLES];

      while(fileReader.hasNext()){

        playerScores = new int[HOLES];
        playerParStatus = new String[HOLES];
        playerTotalPar = new int[HOLES];

        try{

          playerName = fileReader.next();

          playerAge = fileReader.nextInt();

          for(int i = 0; i < HOLES; i++){
            playerScores[i] = fileReader.nextInt();
            playerParStatus[i] = parChecker(playerAge, playerScores[i], i);;
          }

          playerTotalPar = parVals[ageToRow(playerAge)];

          Player player = new Player(playerName, playerAge, playerScores, playerParStatus, playerTotalPar);

          players.add(player);


        }catch(InputMismatchException e){
          System.out.println("[!!!] Some of the data isn't in the correct format! Line " + lineCounter + " skipped");
          String dump = fileReader.nextLine();
        }

        lineCounter++;
      }


      fileReader.close();
      return players;

  }

  private static void printHeader(){
    System.out.println("John Naylor");
    System.out.println("CMSC255 Section 2");
    System.out.println("Goofy Golf");
    System.out.println("Project 6");
    System.out.println();
  }
}

class Player{

  public String name;
  public int age;
  public int[] scores;
  public String[] parStatus;
  public int totalPar;

  public Player(String name, int age, int[] scores, String[] parStatus, int[] totalPar){
    this.name = name;
    this.age = age;
    this.scores = scores;
    this.parStatus = parStatus;
    this.totalPar = sumOfArray(totalPar);
  }

  public static int sumOfArray(int[] values){
    int sum = 0;

    for(int value : values){
      sum += value;
    }

    return sum;
  }

  public String totalParChecker(){
    if(totalPar > sumOfArray(scores)){
      return (totalPar - sumOfArray(scores)) + "point(s) under par";
    }else if(totalPar == sumOfArray(scores)){
      return "Equal to par";
    }else{
      return (sumOfArray(scores) - totalPar) + " point(s) over par";
    }
  }

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
