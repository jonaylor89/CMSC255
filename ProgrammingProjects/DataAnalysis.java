
/*********************************************************************************
*
* John Naylor'
* CMSC255 Section 2
* DataAnalysis
* Project 5
*
* This program takes in Weather data in the for of Day  High  Low  Rainfall
* It output the the average high and low temperature and the total rain fall
* into a file called dataOutput.txt
*
* The user must enter the input text file as a command line argument
***********************************************************************************/

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DataAnalysis{

  //Scanner for prompting user
  private static Scanner userInput = new Scanner(System.in);

/**********************************************************
*
* The main method inputs a txt file from the terminal
* It outputs a new file called dataOutput.txt with the averages and total
*
************************************************************/
  public static void main(String[] argv) throws FileNotFoundException{

    // Print required header
    printHeader();

    // Declare the file who's value will be given through the terminal
    File weatherData;

/**************************************************************************
*
* Try/Catch to retrieve the command line argument with the input data file
* If no file is given the program prompts the user
*
***************************************************************************/
    try{
      weatherData = new File(argv[0]);
    }catch(IndexOutOfBoundsException e){
      System.out.print("Enter file:");
      weatherData = new File(userInput.next());
    }

    //dataOutput.txt is the name of the output file in the rubric
    File outputFile = new File("dataOutput.txt");

    Scanner fileReader = new Scanner(weatherData);
    PrintWriter output = new PrintWriter(outputFile);

    while(true){

  /**********************************************************************************
  * Initialized the arrays that will store all of the different values
  * Also declare all the variables that will be used for the statistical calculations
  ***********************************************************************************/
      int[] days = {};
      int[] highs = {};
      int[] lows = {};
      double[] rain = {};

      int avgHigh;
      int avgLow;
      double totalRain;

      //The first three values will be the column header which will be parsed first
      int year = fileReader.nextInt();
      String month = fileReader.next();
      String city = fileReader.next();

      // while loop as long as there is another line in the file and the line has an integer (In case the line is empty)
      while(fileReader.hasNextLine() && fileReader.hasNextInt()){

        /************************************************************************
        * If the file has another line the arrays will need to be lengthened by 1
        * This is done by making a new array with a length of +1 of the old one
        * and copying the data fro the old array onto the new one
        *************************************************************************/
        days = Arrays.copyOf(days, days.length+1);
        highs = Arrays.copyOf(highs, highs.length+1);
        lows = Arrays.copyOf(lows, lows.length+1);
        rain = Arrays.copyOf(rain, rain.length+1);

        // The actual parsing takes place with the file scanner adding the value from the line in the file to the arrays
        days[days.length-1] = fileReader.nextInt();
        highs[highs.length-1] = fileReader.nextInt();
        lows[lows.length-1] = fileReader.nextInt();
        rain[rain.length-1] = fileReader.nextDouble();

      }

      // Necessary statistical calculations from the output file
      avgHigh = calculateAverage(highs);
      avgLow = calculateAverage(lows);
      totalRain = calculateSum(rain);

      // Print the result of the statistical tests into the output file
      output.printf("For the month of %s %d in %s\n", month, year, city);
      output.printf("The average high temperature was %d degrees\n", avgHigh);
      output.printf("The average low temperature was %d degrees\n", avgLow);
      output.printf("The total rainfall was %.2f inches\n", totalRain);

      // Print the edited data to the output file
      for(int i = 0; i < highs.length; i++){
        output.printf("%d %s %s %s\n", days[i], stringify(highs[i], avgHigh), stringify(lows[i], avgLow), stringify(rain[i]));
      }

      // Close current file reader in order to potentially make a new one
      fileReader.close();

/**************************************************************************************
* Prompting the user if they would like to enter another file for scraping
* If the user asks to enter another file, another prompt asks them for the file name
* A new file reader is made for that file and the process starts again
*****************************************************************************************/
      System.out.print("Would you like to enter a file? (y/n)");

      char response = userInput.next().charAt(0);

      if(response == 'y'){

        System.out.print("Enter file:");
        File newFile = new File(userInput.next());

        fileReader = new Scanner(newFile);
      }else{
        break;
      }
    }
    // ALWAYS close the files
    output.close();
  }

/********************************************************************************
*
* Inputs: Integer from a data set and the average of that data set
* Outputs: The toString() version of the integer with a + or - next the number
* whether it is above or below the mean
*
********************************************************************************/
  private static String stringify(int num, int avg){

    String numStr = Integer.toString(num);

    if(num > avg){
      return numStr + "+";
    }else if(num < avg){
      return numStr + "-";
    }else{
      return numStr;
    }
  }

/*******************************************************************************
*
* Inputs: Double from the data set
* Outputs: the toString version of the double and a * if the double is not zero
* (Yes I overloaded the method cause I'm extra)
*
*******************************************************************************/
  private static String stringify(double num){

    String numStr = Double.toString(num);

    if(num != 0.00){
      return numStr + "*";
    }else{
      return numStr;
    }
  }

/***********************************************************************************************
*
* Inputs: The month and year of the data set
* Outputs: The number of days in the month
* I actually have no idea what this function is for because the output file never uses this.
* I also don't know why I put in the effort of adding leap years
*
************************************************************************************************/
  private static int numDaysInMonth(String month, int year){

    int numOfDays;

    month = month.toLowerCase();

    if(month.equals("february")){

        if((year % 4 == 0) && !(year % 100 == 0 && year % 400 != 0)){
          numOfDays = 29;
        }else{
          numOfDays = 28;
        }
      }else if(month.equals("january") ||
              month.equals("march") ||
              month.equals("may") ||
              month.equals("july") ||
              month.equals("august") ||
              month.equals("october") ||
              month.equals("december")){

        numOfDays = 31;

      }else if(month.equals("april") ||
              month.equals("june") ||
              month.equals("september") ||
              month.equals("november")){

        numOfDays = 30;
      }else{
        numOfDays = 0;
      }

    return numOfDays;
  }

/*****************************************************************
*
* Inputs: Array of Integers
* Outputs: Mean of all of the elements in the array
*
******************************************************************/
  private static int calculateAverage(int[] temp){
    int runningSum = 0;

    for(int element : temp){
      runningSum += element;
    }

    return (runningSum / temp.length);
  }

/****************************************************************************
*
* Inputs: The double array with rainfall data
* Outputs: The sum of all the elements in the array
*
*****************************************************************************/
  private static double calculateSum(double[] rainfall){

    double sum = 0;

    for(double element : rainfall){
      sum += element;
    }

    return sum;
  }

/*******************************************************************************
*
* Inputs: void
* Outputs: void
* This method just prints the appropriate headers for the project
*
********************************************************************************/
  private static void printHeader(){
    System.out.println("John Naylor");
    System.out.println("CMSC255 Section 2");
    System.out.println("DataAnalysis");
    System.out.println("Project5");
  }
}
