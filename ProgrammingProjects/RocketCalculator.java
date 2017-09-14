
/**
 * John Naylor
 * CMSC 255, 2
 * Programming 2, Rocket Calculator
 *
 * This program calculates
 * the cost of building a Rocket
 * including Fuel Cost
 *
 * The user must enter the dimensions
 * of the rocket and the price of the fuel
 *
 *
 *
 * Pseudocode:
 * [+] Print header
 * [+] User inputs the cylinder height, cylinder radius, cone height, fin height, and price of fuel
 * [+] Calculation of cylinder surface area
 * [+] Calculation of cone surface area
 * [+] Calculation of the fine surface area
 * [+] Total surface area i calculated by the three previous calcutions added together
 * [+] Calcution of the cost to build the rocket
 * [+] Calcution of the amount of fuel
 * [+] Calcution of the total cost for fuel
 * [+] Output the results of the previous calculations
 * [+] If the user entered the wrong data type anywhere and the program had a error print NaN and restart the program
 *
 */


 import java.util.*;
 import java.lang.Math;

 public class RocketCalculator{

   public static void main(String[] argv){

     // Create a new scanner that will be used to scan from user input
     Scanner userInput = new Scanner(System.in);

     //Header Documentation
     System.out.println("John Naylor");
     System.out.println("CMSC255, Section 2");
     System.out.println("Rocket Calculator");
     System.out.println("Programming project 2");

     //Declare the needed variables
     int HeightCylinder;
     int RadiusCylinder;
     int HeightCone;
     int HeightFin;
     int BaseFin;
     double PriceFuel;

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

       System.out.print("Enter the price of the fuel for the rocket($/L)  ");
       PriceFuel = userInput.nextDouble();


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

   }

   /*

     The following are the collection
     of math formulas used to calculate
     the output.

   */

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
