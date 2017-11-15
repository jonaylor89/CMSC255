
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SimpleDateTester{
  public static void main(String[] argv){

    ArrayList<SimpleDate> DateList = new ArrayList<SimpleDate>();
    Scanner userInput = new Scanner(System.in);

    int testMonth;
    int testDay;
    int testYear;

    while(true){

      System.out.print("Use default? (y/n): ");
      char de = userInput.next().charAt(0);

      if(de == 'y'){
        SimpleDate sd = new SimpleDate();
        DateList.add(sd);
      }else{
        try{
          System.out.print("Enter test month: ");
          testMonth = userInput.nextInt();

          System.out.print("Enter test day: ");
          testDay = userInput.nextInt();

          System.out.print("Enter test year: ");
          testYear = userInput.nextInt();

          try{
            SimpleDate sd = new SimpleDate(testMonth, testDay, testYear);
            DateList.add(sd);
          }catch(IllegalArgumentException e1){
            System.out.println("[!!!] SImpleDate Exception caught");
          }

        }catch(InputMismatchException e0){
          System.out.println("All values must be integers");
          continue;
        }
      }

      System.out.print("To enter another date, hit y: ");
      char response = userInput.next().charAt(0);

      if(response != 'y'){
        break;
      }


    }

    for(SimpleDate sd : DateList){
      System.out.println(sd);
    }


    SimpleDate mysd = new SimpleDate(9, 16, 1999);

    mysd.setYear(1492);

    mysd.setDay(mysd.getDay() + 4);

    System.out.println(mysd);

  }
}
