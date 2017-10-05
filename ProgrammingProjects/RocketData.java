
/***********************************************************
* John Naylor
* CMSC255
* Project4 RocketData
* Input rocket data from txt file and output the thrust-to-weight ratio
*
* User most add an input file in the command arguements
*
***********************************************************/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RocketData{

  // Making the force of gravity a global constant for every method
  private static final double GRAVITY = 0.009807;

  public static void main(String[] argv) throws FileNotFoundException{

    /*********************************************************************************
    *
    * Grab the filename from the command line and convert it into a File object
    * The File object will be scanned in with the Scanner object
    *
    *******************************************************************************/
    File rocketData = new File(argv[0]);

    Scanner fileReader = new Scanner(rocketData);

    //Declaring needed variables
    String name;
    double thrust;
    double mass;
    double ratio;
    String typeOfRocket;
    /*********************************************************************************
    *
    * Loop throught the scanned file until the file runs out of words
    *
    *******************************************************************************/
    while(fileReader.hasNext()){

      /*********************************************************************************
      *
      * Values are whitespace delimited and are in the order 'String', 'Double', 'Double'.
      * The scanner will extract the values in that order
      *
      *******************************************************************************/
      name = fileReader.next();
      mass = fileReader.nextDouble();
      thrust = fileReader.nextDouble();

      // Calculation of the thrust-to-weight ratio
      ratio = thrustToWeight(thrust, mass);

      /*********************************************************************************
      *
      * Check if the rocket is a rocket engine or a jet engine.
      * If the thrust-to-weight is equal to twenty then then egine could be either
      *
      *******************************************************************************/
      if(ratio > 20.0){
        typeOfRocket = "Rocket Engine";
      }else if(ratio < 20.0){
        typeOfRocket = "Jet Engine";
      }else{
        typeOfRocket = "Jet or Rocket Engine";
      }

      // Output appropriate values in the specific format
     System.out.printf("%s %.4f %s\n", name, ratio, typeOfRocket);

    }

    // Always close the file
    fileReader.close();

  }

  /*************************************************************************************
  *
  * Helper method used to calculate the thrust-to-weight ratio of every rocket entry.
  *
  ************************************************************************************/
  public static double thrustToWeight(double thrust, double mass){
    return thrust / (mass * GRAVITY);
  }
}
