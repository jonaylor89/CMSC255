
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class RocketTest {

  public static void main(String[] argv){

    Scanner userInput = new Scanner(System.in);

    printHeader();

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

    ArrayList<Rocket> RocketList = new ArrayList<Rocket>();

      while(true){

          System.out.print("Use default? (y/n): ");
          char de = userInput.next().charAt(0);

          if(de == 'y'){
              Rocket r = new Rocket();
              RocketList.add(r);
          }else{
              try{

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

          System.out.print("To enter another Rocket?, hit y: ");
          char response = userInput.next().charAt(0);

          if(response != 'y'){
              break;
          }

      }

      for(Rocket rocket : RocketList){
          System.out.println("\n\n");
          System.out.println(rocket);
          System.out.println("\n\n");
      }

  }

  private static void printHeader(){
    System.out.println("John Naylor");
    System.out.println("CMSC255 Section 2");
    System.out.println("DataAnalysis");
    System.out.println("Project5");
  }
}
