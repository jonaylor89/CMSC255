
public class Card
{
  private String name;
  
  public Card()
  {
    name = "";
  }
  public Card(String n)
  {
    name = n;
  }
  public String getName()
  {
    return name;
  }
  public boolean isExpired()
  {
    return false;
  }
  @Override
  public String toString()
  {
    return "Card holder: " + name;
  }
}
