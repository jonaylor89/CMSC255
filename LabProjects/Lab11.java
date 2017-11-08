import java.util.Scanner;
import java.util.InputMismatchException;

/*******************************************************************************
 *   DaysPerMonth
 * -----------------------------------------------------------------------------
 *   VCU - Computer Science Department
 *   A program that prompts the user for a month and year (both as integers)
 *   then displays the number of days in that month.
 ******************************************************************************/
 class Lab11 {

 public static void main(String[] args) {
  /*****************************************************
  * prompt the user to enter a month
  *****************************************************/

  int month;
  int year;


  try{
    month = Integer.parseInt(args[0]);
    year = Integer.parseInt(args[1]);
  }catch(NumberFormatException e0){
    while(true){
      System.out.print("\nEnter a month (1-12): ");
      Scanner userInput = new Scanner(System.in);
      try{
        month = userInput.nextInt();
      }catch(InputMismatchException e2){
        System.out.println("\nMonth must be between 1 and 12; try again");
        continue;
      }
      /*****************************************************************
      * terminate the program if the month is not between 1 and 12
      *****************************************************************/
      if(month < 1 || month > 12) {
       System.out.println("\nMonth must be between 1 and 12; try again");
       continue;
      }
      /*****************************************************************
      // prompt the user to enter a year
      *****************************************************************/
      System.out.print("Enter a year: ");
      try{
        year = userInput.nextInt();
      }catch(InputMismatchException e3){
        System.out.println("\nMonth must be between 1 and 12; try again");
        continue;
      }

      if(year < 0){
        System.out.println("\nYear cannot be negative; try again");
        continue;
      }

      break;
      }
  }catch(IndexOutOfBoundsException e1){
    while(true){
      System.out.print("\nEnter a month (1-12): ");
      Scanner userInput = new Scanner(System.in);
      try{
        month = userInput.nextInt();
      }catch(InputMismatchException e2){
        System.out.println("\nMonth must be between 1 and 12; try again");
        continue;
      }
      /*****************************************************************
      * terminate the program if the month is not between 1 and 12
      *****************************************************************/
      if(month < 1 || month > 12) {
       System.out.println("\nMonth must be between 1 and 12; try again");
       continue;
      }
      /*****************************************************************
      // prompt the user to enter a year
      *****************************************************************/
      System.out.print("Enter a year: ");
      try{
        year = userInput.nextInt();
      }catch(InputMismatchException e3){
        System.out.println("\nMonth must be between 1 and 12; try again");
        continue;
      }

      if(year < 0){
        System.out.println("\nYear cannot be negative; try again");
        continue;
      }

      break;
      }
    }
  /*****************************************************************
  // determine the number of days in the month
  *****************************************************************/
  int numDays = getDays(month, year);
  /*****************************************************************
  // display number of days in the month
  *****************************************************************/
  System.out.println("There are " + numDays + " days in this month.");
 } //end of main
/*******************************************************************************
 *   getDays
 * -----------------------------------------------------------------------------
 *   Function: Get number of days in a month
 *   Input:  month
 *           year
 *   Output: Number of days in the month
 ******************************************************************************/
 private static int getDays(int mon, int yr) {
  int numDays = 0;
  switch(mon) {
  case 2: // February
   numDays = 28;
   if(yr % 4 == 0) {
    numDays = 29;
    if(yr % 100 == 0 && yr % 400 != 0)
     numDays = 28;
   }
   break;
  case 4:   //April
  case 6:   // June
  case 9:   // September
  case 11:  // November
   numDays = 30;
   break;
  default: numDays = 31;  // all the rest
  }
  return numDays;
 }

}
