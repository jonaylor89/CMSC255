
/************************************************************
* John Naylor
* CMSC255 Section 2
* Lab 2
* SoccorScores
*****************************************************************/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab6{


  public static void main(String[] argv) throws FileNotFoundException{

// Promper user to enter the filename
    Scanner userInput = new Scanner(System.in);

    System.out.println("Enter file to parse");
    String fileString = userInput.next();

// Turn the filename into a file object
    File userFile = new File(fileString);
    Scanner fileReader = new Scanner(userFile);

// declare and initialize proper variables
    double max = 0;
    String maxTeam = "";
    double min = 100;
    String minTeam = "";
    double avg = 0;
    String prevToken = "";
    double numOfTeams = 0;
    String digits = "[0-9]+";

// Loop through every work and number in the file
    while(fileReader.hasNext()){

        String token = fileReader.next();

// If the token is a number and has a number after it than it is a goal and should be checked whether it's a minimum of maximum
        if(token.matches(digits) && fileReader.hasNextDouble()){
          double goal = Double.parseDouble(token);

// max check
          if(goal > max){
            max = goal;
            maxTeam = prevToken;
          }

// min check
          if(goal < min){
            min = goal;
            minTeam = prevToken;
          }

// Also add the goal to the average to be divided later
          avg += fileReader.nextDouble();
          numOfTeams++;

      }

      prevToken = token;
    }

// print out values for min, max, and average
    System.out.println("Max Team: " + maxTeam + " " + max);
    System.out.println("Min Team: " + minTeam + " " +min);
    System.out.printf("Average: %.3f\n", avg/numOfTeams);

//always close the file after using it
    fileReader.close();

  }
}
