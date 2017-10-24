
/*****************************************************
* John Naylor'
* CMSC255 Section 2
* DataAnalysis
* Project 5
*****************************************************/

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DataAnalysis{

  public static void main(String[] argv) throws FileNotFoundException{

    printHeader();


    File weatherData;

    try{
      weatherData = new File(argv[0]);
    }catch(IndexOutOfBoundsException e){
      weatherData = null;
      System.out.println("Must enter the input file as a command line arguement");
      System.exit(1);
    }

    File outputFile = new File("dataOutput.txt");

    Scanner fileReader = new Scanner(weatherData);
    PrintWriter output = new PrintWriter(outputFile);

    int[] days = {};
    int[] highs = {};
    int[] lows = {};
    double[] rain = {};

    int avgHigh;
    int avgLow;
    double totalRain;

    int year = fileReader.nextInt();
    String month = fileReader.next();
    String city = fileReader.next();

    while(fileReader.hasNextLine() && fileReader.hasNextInt()){

      days = Arrays.copyOf(days, days.length+1);
      highs = Arrays.copyOf(highs, highs.length+1);
      lows = Arrays.copyOf(lows, lows.length+1);
      rain = Arrays.copyOf(rain, rain.length+1);

      days[days.length-1] = fileReader.nextInt();
      highs[highs.length-1] = fileReader.nextInt();
      lows[lows.length-1] = fileReader.nextInt();
      rain[rain.length-1] = fileReader.nextDouble();

    }

    avgHigh = calculateAverage(highs);
    avgLow = calculateAverage(lows);
    totalRain = calculateSum(rain);

    output.printf("For the month of %s %d in %s\n", month, year, city);
    output.printf("The average high temperature was %d degrees\n", avgHigh);
    output.printf("The average low temperature was %d degrees\n", avgLow);
    output.printf("The total rainfall was %.2f inches\n", totalRain);

    for(int i = 0; i < highs.length; i++){
      output.printf("%d %s %s %s\n", days[i], stringify(highs[i], avgHigh), stringify(lows[i], avgLow), stringify(rain[i]));
    }

    fileReader.close();
    output.close();

  }

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

  private static String stringify(double num){

    String numStr = Double.toString(num);

    if(num != 0.00){
      return numStr + "*";
    }else{
      return numStr;
    }
  }

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
