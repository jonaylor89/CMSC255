
/******************************************************************************
*
* John Naylor
* CMSC255 Section 2
* RocketTest
*
* This program tests RocketClass
*
* The program prompts the user to create different rocket
* and then tests the various methods in the created rocket objects
*
******************************************************************************/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class RocketTest {

  /***********************************
  * @param String array
  * @return void
  ***********************************/
  public static void main(String[] argv){

    Scanner userInput = new Scanner(System.in);

    // Required print header
    printHeader();

    // Initialize constants and declared all the rocket variables
    final double ALUM = 1.25;
    final double STEEL = 3.00;
    final double TITAN = 5.50;

    final double AMMONIUMNITRATE = 0.25;
    final double AMMONIUMPERCHLORATE = 0.45;

    int HeightCylinder;
    int RadiusCylinder;
    int HeightCone;
    int HeightFin;
    int BaseFin;
    String typeOfMaterial;
    double PriceOfMaterial;
    double PriceFuel;
    String typeOfFuel;

    /***************************************************************************
    * An arrayList object is created to store all of the RocketClass instances
    ***************************************************************************/
    ArrayList<Rocket> RocketList = new ArrayList<Rocket>();

    /***************************************************************************************************
    * To get user input a while loop is created allowing for the user to create multiple instances
    ***************************************************************************************************/
      while(true){

    /*****************************************************************************************************
    * First ask the user if they would like to just use the default rocket instance or create their own
    *****************************************************************************************************/
          System.out.print("Use default? (y/n): ");
          char de = userInput.next().charAt(0);

          if(de == 'y'){
              // Use default RocketClass constructor
              Rocket r = new Rocket();
              RocketList.add(r);
          }else{
              try{
          /*****************************************************************************
          *
          * If the user chose to create their own rocket instance
          * then the program prompts the user for the different rocket measurements
          *
          *****************************************************************************/
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

                  if(typeOfMaterial.equals("aluminum")){
                      PriceOfMaterial = ALUM;
                  }else if(typeOfMaterial.equals("steel")){
                      PriceOfMaterial = STEEL;
                  }else if(typeOfMaterial.equals("titanium")){
                      PriceOfMaterial = TITAN;
                  }else{
                      System.out.println("You must enter a valid material");
                      continue;
                  }

                  System.out.print("Enter the type of fuel (ammonium ____) ");
                  typeOfFuel = userInput.next();

                  if(typeOfFuel.equals("nitrate")){
                      PriceFuel = AMMONIUMNITRATE;
                  }else if(typeOfFuel.equals("perchlorate")){
                      PriceFuel = AMMONIUMPERCHLORATE;
                  }else{
                      System.out.println("You must enter a valid fuel");
                      continue;
                  }

                  try{
                    /****************************************************************************************************
                    * After the user enters the measurements a new rocket instance is made and added to the arrayList
                    *****************************************************************************************************/
                    Rocket r = new Rocket(HeightCylinder, RadiusCylinder, HeightCone, HeightFin, BaseFin, typeOfMaterial, PriceOfMaterial, PriceFuel, typeOfFuel);
                    RocketList.add(r);
                  }catch(IllegalArgumentException e1){
                    System.out.println("One of the arguments isn't in the correct format");
                    continue;
                  }

              }catch(InputMismatchException e0){
                  System.out.println("All values must be of proper datatype");
                  continue;
              }
          }

          /*****************************************************************************************
          * Before testing the rockets the user is asked if they'd like to create another rocket
          ******************************************************************************************/
          System.out.print("To enter another Rocket?, hit y: ");
          char response = userInput.next().charAt(0);

          if(response != 'y'){
              break;
          }
      }

      /**********************************************************
      * All of the rockets are printed out from the arrayList
      **********************************************************/
      for(Rocket rocket : RocketList){
          System.out.println("\n\n");
          System.out.println(rocket);
          System.out.println("\n\n");
      }

      /*******************************************************************************
      * One last rocket is created to test the individual getter and setter methods
      *******************************************************************************/
      Rocket testRocket = new Rocket();

      // Lots of new lines to make things look nicer
      System.out.println("\n\n\n");

      testRocket.setHeightCylinder(100);
      System.out.println(testRocket.getHeightCylinder());

      testRocket.setRadiusCylinder(5);
      System.out.println(testRocket.getRadiusCylinder());

      testRocket.setHeightCone(56);
      System.out.println(testRocket.getHeightCone());

      testRocket.setHeightFin(42);
      System.out.println(testRocket.getHeightFin());

      testRocket.setBaseFin(90);
      System.out.println(testRocket.getBaseFine());

      testRocket.setTypeOfMaterial("aluminum");
      System.out.println(testRocket.getTypeOfMaterial());

      testRocket.setPriceOfMaterial(10);
      System.out.println(testRocket.getPriceOfMaterial());

      testRocket.setPriceOfMaterial(10);
      System.out.println(testRocket.getPriceFuel());

      testRocket.setPriceFuel(10);
      System.out.println(testRocket.getPriceFuel());

      testRocket.setTypeOfFuel("perchlorate");
      System.out.println(testRocket.getTypeOfFuel());


  }

  private static void printHeader(){
    System.out.println("John Naylor");
    System.out.println("CMSC255 Section 2");
    System.out.println("DataAnalysis");
    System.out.println("Project5");
  }
}
