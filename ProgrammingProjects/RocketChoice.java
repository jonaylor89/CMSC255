
import java.util.Scanner;

public class RocketChoice{
  public static void main(String[] argv){

    Scanner userInput = new Scanner(System.in);

    while(true){

      

      System.out.println("[+] Press \'q\' to exit");
      char killSwitch = userInput.next().charAt(0);

      if(killSwitch == 'q'){
          break;
      }
    }
  }
}
