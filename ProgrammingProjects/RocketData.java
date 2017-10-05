
/***********************************************************
* John Naylor
* CMSC255
* Project4 RocketData
* Input rocket data from txt file and output the thrust-to-weight ratio
*
***********************************************************/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RocketData{

  private static final double GRAVITY = 0.009807;

  public static void main(String[] argv) throws FileNotFoundException{

    File rocketData = new File(argv[0]);

    Scanner fileReader = new Scanner(rocketData);

    String name;
    double thrust;
    double mass;
    double ratio;
    String typeOfRocket;

    while(fileReader.hasNext()){

      name = fileReader.next();
      thrust = fileReader.nextDouble();
      mass = fileReader.nextDouble();

      ratio = thrustToWeight(thrust, mass);

      if(ratio > 20.0){
        typeOfRocket = "Rocket Engine";
      }else if(ratio < 20.0){
        typeOfRocket = "Jet Engine";
      }else{
        typeOfRocket = "Jet or Rocket Engine";
      }

      System.out.printf("%s %.4f %s\n", name, ratio, typeOfRocket);

    }
  }

  public static double thrustToWeight(double thrust, double mass){
    return thrust / (mass * GRAVITY);
  }
}
