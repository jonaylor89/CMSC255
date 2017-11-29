
public class DebitCard extends Card{

  private int cardNumber;
  private int PIN;

  public DebitCard(String n, int cardNum, int pin){
    super(n);
    cardNumber = cardNum;
    PIN = pin;
  }

  @Override
  public String toString(){
    return super.toString() + "\nCard Number: " + cardNumber + "\nPIN Number: " + PIN;
  }
}
