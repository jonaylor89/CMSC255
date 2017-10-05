
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

    while(fileReader.hasNext()){
      System.out.println(fileReader.next());
    }

  }

  public static double thrustToWeight(double thrust, double mass){
    return thrust / (mass * GRAVITY);
  }
}
