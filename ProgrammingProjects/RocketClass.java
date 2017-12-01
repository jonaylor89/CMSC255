
class Rocket{

  // Initialize all the constants and declare all the variables
  private static final double ALUM = 1.25;
  private static final double STEEL = 3.00;
  private static final double TITAN = 5.50;

  private static final double AMMONIUMNITRATE = 0.25;
  private static final double AMMONIUMPERCHLORATE = 0.45;

  private int HeightCylinder;
  private int RadiusCylinder;
  private int HeightCone;
  private int HeightFin;
  private int BaseFin;
  private String typeOfMaterial;
  private double PriceOfMaterial;
  private double PriceFuel;
  private String typeOfFuel;
  private double CylinderSurfArea;
  private double ConeSurfArea;
  private double FinSurfArea;
  private double TotalSurfArea;
  private double CostToBuild;
  private double AmountOfFuel;
  private double CostOfFuel;

  /********************************************************************
  *
  * Default constructor adds Initializes variable with random values
  *
  * @param void
  * @return void
  *
  *******************************************************************/
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

    //calculate the rest of the variables
    CylinderSurfArea = surfAreaOfCylinder(RadiusCylinder, HeightCylinder);
    ConeSurfArea = surfAreaOfCone(RadiusCylinder, HeightCone);
    FinSurfArea = areaOfParallel(BaseFin, HeightFin);
    TotalSurfArea = CylinderSurfArea + ConeSurfArea + FinSurfArea;
    CostToBuild = TotalSurfArea * PriceOfMaterial;
    AmountOfFuel = volumeOfCylinder(RadiusCylinder, HeightCylinder);
    CostOfFuel = AmountOfFuel * PriceFuel;

  }

  /****************************************************************
  *
  * Initializes a rocket with measurements provided by the user
  *
  * @param Rocket Measurements
  * @return void
  *
  ***************************************************************/
  Rocket( int HeightCylinder,
          int RadiusCylinder,
          int HeightCone,
          int HeightFin,
          int BaseFin,
          String typeOfMaterial,
          double PriceOfMaterial,
          double PriceFuel,
          String typeOfFuel ){

    setHeightCylinder(HeightCylinder);
    setRadiusCylinder(RadiusCylinder);
    setHeightCone(HeightCone);
    setHeightFin(HeightFin);
    setBaseFin(BaseFin);
    setTypeOfMaterial(typeOfMaterial);
    setPriceOfMaterial(PriceOfMaterial);
    setTypeOfFuel(typeOfFuel);
    setPriceFuel(PriceFuel);

    // calculate the rest of the variables
    CylinderSurfArea = surfAreaOfCylinder(RadiusCylinder, HeightCylinder);
    ConeSurfArea = surfAreaOfCone(RadiusCylinder, HeightCone);
    FinSurfArea = areaOfParallel(BaseFin, HeightFin);
    TotalSurfArea = CylinderSurfArea + ConeSurfArea + FinSurfArea;
    CostToBuild = TotalSurfArea * PriceOfMaterial;
    AmountOfFuel = volumeOfCylinder(RadiusCylinder, HeightCylinder);
    CostOfFuel = AmountOfFuel * PriceFuel;

  }

  /**************************************************
  * @param void
  * @return The height the rocket cylinder
  **************************************************/
  public int getHeightCylinder(){
    return HeightCylinder;
  }

  /**************************************************
  * @param The desired cylinder height
  * @return void
  **************************************************/
  public void setHeightCylinder(int heightCylinder) {
    HeightCylinder = heightCylinder;
  }

  /**************************************************
  * @param void
  * @return The radius of the rocket cylinder
  **************************************************/
  public int getRadiusCylinder(){
    return RadiusCylinder;
  }

  /**************************************************
  * @param The desired cylinder radius
  * @return void
  **************************************************/
  public void setRadiusCylinder(int radiusCylinder) {
    RadiusCylinder = radiusCylinder;
  }

  /**************************************************
  * @param void
  * @return The height of the rocket cone
  **************************************************/
  public int getHeightCone(){
    return HeightCone;
  }

  /**************************************************
  * @param The desired height of the cone
  * @return void
  **************************************************/
  public void setHeightCone(int heightCone) {
    HeightCone = heightCone;
  }

  /**************************************************
  * @param void
  * @return The height the rocket fin
  **************************************************/
  public int getHeightFin(){
    return HeightFin;
  }

  /**************************************************
  * @param The deisre fin height
  * @return void
  **************************************************/
  public void setHeightFin(int heightFin) {
    HeightFin = heightFin;
  }

  /**************************************************
  * @param void
  * @return The length of the base of the fin
  **************************************************/
  public int getBaseFine(){
    return BaseFin;
  }

  /**************************************************
  * @param The desire length of the fin base
  * @return void
  **************************************************/
  public void setBaseFin(int baseFin) {
    BaseFin = baseFin;
  }

  /*******************************************************
  * @param void
  * @return The htype of material the rocket is made of
  ********************************************************/
  public String getTypeOfMaterial(){
    return typeOfMaterial;
  }

  /**************************************************
  * @param The desired material
  * @return void
  **************************************************/
  public void setTypeOfMaterial(String typeOfMaterial) {
    this.typeOfMaterial = typeOfMaterial;
  }

  /**************************************************
  * @param void
  * @return The price of the rocket material
  **************************************************/
  public double getPriceOfMaterial(){
    return PriceOfMaterial;
  }

  /**************************************************
  * @param The new price of the material
  * @return void
  **************************************************/
  public void setPriceOfMaterial(double priceOfMaterial) {
    PriceOfMaterial = priceOfMaterial;
  }

  /**************************************************
  * @param void
  * @return The price of the rocket fuel
  **************************************************/
  public double getPriceFuel(){
    return PriceFuel;
  }

  /**************************************************
  * @param The new price of the rocket fuel
  * @return void
  **************************************************/
  public void setPriceFuel(double priceFuel) {
    PriceFuel = priceFuel;
  }

  /**************************************************
  * @param void
  * @return The type of rocket fuel
  **************************************************/
  public String getTypeOfFuel(){
    return typeOfFuel;
  }

  /**************************************************
  * @param The new fuel type
  * @return void
  **************************************************/
  public void setTypeOfFuel(String typeOfFuel) {
    this.typeOfFuel = typeOfFuel;
  }

  /*************************************************************************
  *
  * Static method to calculate the volume of a cylinder
  *
  * @param Cylinder radius
  * @param Cylinder height
  * @return Volume of the cylinder
  *
  ***************************************************************************/
  public static double volumeOfCylinder(int radius, int height){
        return Math.PI * radius * radius * height;
    }

    /*************************************************************************
    *
    * Static method to calculate the surface area of a cylinder
    *
    * @param Cylinder radius
    * @param Cylinder height
    * @return Surface area of the cylinder
    *
    ***************************************************************************/
  public static double surfAreaOfCylinder(int radius, int height){
        return 2 * Math.PI * radius * height + 2 * Math.PI * radius * radius;
    }

    /*************************************************************************
    *
    * Static method to calculate the surface area of a cone
    *
    * @param Cone radius
    * @param Cone height
    * @return Surface area of the cone
    *
    ***************************************************************************/
  public static double surfAreaOfCone(int height, int radius){
        return Math.PI * radius * Math.sqrt((double)(height * height + radius * radius));
    }

    /*************************************************************************
    *
    * Static method to calculate the a parallelagram
    *
    * @param Parallelagram length
    * @param Parallelagram height
    * @return Parallelagram area
    *
    ***************************************************************************/
  public static int areaOfParallel(int base, int height){
        return base * height;
    }

  /*********************************************************************
  *
  * Rockets toString method to format the output of the rocket
  *
  * @param void
  * @return Formatted String of the Rocket
  *
  ********************************************************************/
  @Override
  public String toString(){
    return "The rocket measurements are:\n" +
      String.format("\t Cylinder Surface Area: %.2f(cm^2)\n", CylinderSurfArea) +
      String.format("\t Cone Surface Area: %.2f(cm^2)\n", ConeSurfArea) +
      String.format("\t Fin Surface Area: %.2f x 3 = %.2f(cm^2)\n", FinSurfArea, FinSurfArea * 3) +
      String.format("\t Total Surface Area: %.2f(cm^2)\n", TotalSurfArea) +

      String.format("Cost of the Material using %s at $%.2f per cm^2: $%.2f\n", typeOfMaterial, PriceOfMaterial, CostToBuild) +
      String.format("The Rocket Uses: %.2f(mL)\n", AmountOfFuel) +
      String.format("The Total Cost of Fuel using %s at %.2f per mL: $%.2f\n", typeOfFuel, PriceFuel, CostOfFuel) +
      String.format("The grand cost of the rocket is: %.2f\n", CostToBuild + CostOfFuel);
  }

}
