
/*****************************************************
* John Naylor'
* CMSC255 Section 2
* DataAnalysis
* Project 5
*****************************************************/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DataAnalysis{

  private static Scanner userInput = new Scanner(System.in);

  public static void main(String[] argv) throws FileNotFoundException{

    printHeader();







  }

  private static int numDaysInYears(String month, int year){

  }

  private static int calculateAverage(int[] temp){
    int runningSum = 0;

    for(int element : temp){
      runningSum += element;
    }

    return (runningSum / temp.length);
  }

  private static double calculateSum(double[] rainfall){

    double sum = 0;

    for(double element : rainfall){
      sum += element;
    }

    return sum;
  }

  private static void printHeader(){
    System.out.println("John Naylor");
    System.out.println("CMSC255 Section 2");
    System.out.println("DataAnalysis");
    System.out.println("Project5");
  }
}
