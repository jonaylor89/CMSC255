
public class DriversLicense extends IDCard{

  private int expirationYear;

  public DriversLicense(String n, String id, int exYear){
    super(n, id);
    expirationYear = exYear;
  }

  @Override
  public String toString(){
    return super.toString() + "\nExpiration: " + expirationYear;
  }
}
