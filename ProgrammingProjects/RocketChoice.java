
import java.util.*;

public class RocketChoice{
  public static void main(String[] argv){

    Scanner userInput = new Scanner(System.in);

    //Declare the needed variables and constants

    final double ALUM = 1.25;
    final double STEEL = 3.00;
    final double TITAN = 5.50;

    final double AMMONIUMNITRATE = 0.25;
    final double AMMONIUMPERCHLORATE = 0.45;
    final double BUILD = 59.95;

    int HeightCylinder;
    int RadiusCylinder;
    int HeightCone;
    int HeightFin;
    int BaseFin;
    String typeOfMaterial;
    double PriceOfMaterial;
    double PriceFuel;
    String typeOfFuel;
    char killSwitch;

    while(true){

      try{

        // Retreive all of the needed parameters from the user.
        System.out.print("Enter the height of the cylinder of the rocket(cm)  ");
        HeightCylinder = userInput.nextInt();

        System.out.print("Enter the radius of the cylinder of the rocket(cm)  ");
        RadiusCylinder = userInput.nextInt();

        System.out.print("Enter the height of the cone of the rocket(cm)  ");
        HeightCone = userInput.nextInt();

        System.out.print("Enter the height of the fin of the rocket(cm)  ");
        HeightFin = userInput.nextInt();

        System.out.print("Enter the base of the fin of the rocket(cm)  ");
        BaseFin = userInput.nextInt();

        System.out.print("Enter the type of material  ");
        typeOfMaterial = userInput.next();

        System.out.print("Enter the type of fuel (ammonium ____) ");
        typeOfFuel = userInput.next();

        System.out.println(typeOfFuel);

        if(typeOfFuel.equals("nitrate")){
          PriceFuel = AMMONIUMNITRATE;
        }else if(typeOfFuel.equals("perchlorate")){
          PriceFuel = AMMONIUMPERCHLORATE;
        }else{
          System.out.println("You must enter a valid fuel");
          break;
        }

        if(typeOfMaterial.equals("aluminum")){
          PriceOfMaterial = ALUM;
        }else if(typeOfMaterial.equals("steel")){
          PriceOfMaterial = STEEL;
        }else if(typeOfMaterial.equals("titanium")){
          PriceOfMaterial = TITAN;
        }else{
          System.out.println("You must enter a valid material");
          break;
        }

        //Keeping all of the output variables as doubles for maximum percision.
        double CylinderSurfArea = surfAreaOfCylinder(RadiusCylinder, HeightCylinder);
        double ConeSurfArea = surfAreaOfCone(RadiusCylinder, HeightCone);
        double FinSurfArea = areaOfParallel(BaseFin, HeightFin);
        double TotalSurfArea = CylinderSurfArea + ConeSurfArea + FinSurfArea;
        double CostToBuild = TotalSurfArea * 1.75;
        double AmountOfFuel = volumeOfCylinder(RadiusCylinder, HeightCylinder);
        double CostOfFuel = AmountOfFuel * PriceFuel;


        // Print all of the output to the console with the appropriate decimal percision
        System.out.println("The rocket measurements are:");
        System.out.printf("\t Cylinder Surface Area: %.2f(cm^2)\n", CylinderSurfArea);
        System.out.printf("\t Cone Surface Area: %.2f(cm^2)\n", ConeSurfArea);
        System.out.printf("\t Fin Surface Area: %.2f x 3 = %.2f(cm^2)\n", FinSurfArea, FinSurfArea * 3);
        System.out.printf("\t Total Surface Area: %.2f(cm^2)\n", TotalSurfArea);

        System.out.printf("Cost of the Material: $%.2f\n", CostToBuild);
        System.out.printf("The Rocket Uses: %.2f(L)\n", AmountOfFuel);
        System.out.printf("The Total Cost of Fuel: $%.2f\n", CostOfFuel);

        // If the user puts in an incompatable data type, the program tells the user and quits.
      }catch(InputMismatchException e){
        System.out.println("Not appropriate datatype, restart program");
      }

      // Allows the user to get out of the program
      System.out.println("\n\n\n[+] Press \'q\' to exit");
      killSwitch = userInput.next().charAt(0);

      if(killSwitch == 'q'){
          break;
      }
    }
  }

  public static double volumeOfCylinder(int radius, int height){
    return Math.PI * radius * radius * height;
  }

  public static double surfAreaOfCylinder(int radius, int height){
    return 2 * Math.PI * radius * height + 2 * Math.PI * radius * radius;
  }

  public static double surfAreaOfCone(int height, int radius){
    return Math.PI * radius * Math.sqrt((double)(height * height + radius * radius));
  }

  public static int areaOfParallel(int base, int height){
    return base * height;
  }
}
