
class Rocket{

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

    CylinderSurfArea = surfAreaOfCylinder(RadiusCylinder, HeightCylinder);
    ConeSurfArea = surfAreaOfCone(RadiusCylinder, HeightCone);
    FinSurfArea = areaOfParallel(BaseFin, HeightFin);
    TotalSurfArea = CylinderSurfArea + ConeSurfArea + FinSurfArea;
    CostToBuild = TotalSurfArea * PriceOfMaterial;
    AmountOfFuel = volumeOfCylinder(RadiusCylinder, HeightCylinder);
    CostOfFuel = AmountOfFuel * PriceFuel;

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

    setHeightCylinder(HeightCylinder);
    setRadiusCylinder(RadiusCylinder);
    setHeightCone(HeightCone);
    setHeightFin(HeightFin);
    setBaseFin(BaseFin);
    setTypeOfMaterial(typeOfMaterial);
    setPriceOfMaterial(PriceOfMaterial);
    setTypeOfFuel(typeOfFuel);
    setPriceFuel(PriceFuel);

    CylinderSurfArea = surfAreaOfCylinder(RadiusCylinder, HeightCylinder);
    ConeSurfArea = surfAreaOfCone(RadiusCylinder, HeightCone);
    FinSurfArea = areaOfParallel(BaseFin, HeightFin);
    TotalSurfArea = CylinderSurfArea + ConeSurfArea + FinSurfArea;
    CostToBuild = TotalSurfArea * PriceOfMaterial;
    AmountOfFuel = volumeOfCylinder(RadiusCylinder, HeightCylinder);
    CostOfFuel = AmountOfFuel * PriceFuel;

  }

  public int getHeightCylinder(){
    return HeightCylinder;
  }

  public void setHeightCylinder(int heightCylinder) {
    HeightCylinder = heightCylinder;
  }

  public int getRadiusCylinder(){
    return RadiusCylinder;
  }

  public void setRadiusCylinder(int radiusCylinder) {
    RadiusCylinder = radiusCylinder;
  }

  public int getHeightCone(){
    return HeightCone;
  }

  public void setHeightCone(int heightCone) {
    HeightCone = heightCone;
  }

  public int getHeightFin(){
    return HeightFin;
  }

  public void setHeightFin(int heightFin) {
    HeightFin = heightFin;
  }

  public int getBaseFine(){
    return BaseFin;
  }

  public void setBaseFin(int baseFin) {
    BaseFin = baseFin;
  }

  public String getTypeOfMaterial(){
    return typeOfMaterial;
  }

  public void setTypeOfMaterial(String typeOfMaterial) {
    this.typeOfMaterial = typeOfMaterial;
  }

  public double getPriceOfMaterial(){
    return PriceOfMaterial;
  }

  public void setPriceOfMaterial(double priceOfMaterial) {
    PriceOfMaterial = priceOfMaterial;
  }

  public double getPriceFuel(){
    return PriceFuel;
  }

  public void setPriceFuel(double priceFuel) {
    PriceFuel = priceFuel;
  }

  public String getTypeOfFuel(){
    return typeOfFuel;
  }

  public void setTypeOfFuel(String typeOfFuel) {
    this.typeOfFuel = typeOfFuel;
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
