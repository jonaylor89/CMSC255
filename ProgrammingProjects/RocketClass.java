
public class RocketClass {
  public static void main(String[] argv){

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

    while(true){
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

      }catch(InputMismatchException e){
        System.out.println("Must enter valid datatypes");
        continue;
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

  private static void printHeader(){
    System.out.println("John Naylor");
    System.out.println("CMSC255 Section 2");
    System.out.println("DataAnalysis");
    System.out.println("Project5");
  }
}

class Rocket{

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

  Rocket(){
    HeightCylinder = 1;
    RadiusCylinder = 1;
    HeightCone = 1;
    HeightFin = 1;
    BaseFin = 1;
    typeOfMaterial = "steel";
    PriceOfMaterial = STEEL;
    typeOfFuel = "nitrate";
    PriceFuel = AMMONIUMNITRATE;
  }

  Rocket( int HeightCylinder,
          int RadiusCylinder,
          int HeightCone,
          int HeightFin,
          int BaseFin,
          String typeOfMaterial,
          double PriceOfMaterial,
          double PriceFuel,
          String typeOfFuel ){

    this.HeightCylinder = HeightCylinder;
    this.RadiusCylinder = RadiusCylinder;
    this.HeightCone = HeightCone;
    this.HeightFin = HeightFin;
    this.BaseFin = BaseFin;
    this.typeOfMaterial = typeOfMaterial;
    this.PriceOfMaterial = PriceOfMaterial;
    this.typeOfFuel = typeOfFuel;
    this.PriceFuel = PriceFuel;

  }

  public void toString(){
    return "The rocket measurements are:" +
      String.format("\t Cylinder Surface Area: %.2f(cm^2)\n", CylinderSurfArea) +
      String.format("\t Cone Surface Area: %.2f(cm^2)\n", ConeSurfArea) +
      String.format("\t Fin Surface Area: %.2f x 3 = %.2f(cm^2)\n", FinSurfArea, FinSurfArea * 3) +
      String.format("\t Total Surface Area: %.2f(cm^2)\n", TotalSurfArea) +

      String.format("Cost of the Material using %s at $%.2f per cm^2: $%.2f\n", typeOfMaterial, PriceOfMaterial, CostToBuild) +
      String.format("The Rocket Uses: %.2f(mL)\n", AmountOfFuel) +
      String.format("The Total Cost of Fuel using %s at %.2f per mL: $%.2f\n", typeOfFuel, PriceFuel, CostOfFuel) +
      String.format("The cost to build the rocket is %.2f\n", BUILD) +
      String.format("The grand cost of the rocket is: %.2f\n", CostToBuild + CostOfFuel);
  }

}
