
public class IDCard extends Card {

  private String idNumber;

  public IDCard(String n, String id){
    super(n);
    idNumber = id;
  }

  public String getName(){
    return super.getName();
  }

  @Override
  public String toString(){
    return super.toString() + "\nid: " + idNumber;
  }
}
