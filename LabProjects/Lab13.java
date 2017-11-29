
public class Lab13{
  public static void main(String[] argv){

    Card c = new Card("Lequan");
    DebitCard dc = new DebitCard("Timithy", 123456789, 789);
    DriversLicense dl = new DriversLicense("Helga", "Another id", 3005);
    IDCard idc = new IDCard("Jim", "This is an id");

    System.out.println(c + "\n");
    System.out.println(idc + "\n");
    System.out.println(dc + "\n");
    System.out.println(dl + "\n");

  }
}
