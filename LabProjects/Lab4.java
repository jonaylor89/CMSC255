
/*********************************************\
*
*  John Naylor and Baochau Tran
*  CMSCC 255 session 2
*  Lab 4
*  Convert letter to number
*
\*********************************************/

import java.util.Scanner;

public class Lab4{

  public static void main(String[] argv){

    char digit;
    int number = 0;

    Scanner userInput = new Scanner(System.in);

    System.out.print("Enter a single letter, and I will tell you what the corresponding digit is on the telephone:");
    digit = userInput.nextLine().charAt(0);

    System.out.println("User enters an " + digit);

    do{
      if((digit == 'A') || (digit == 'B') || (digit == 'C')){
        number = 2;
      }
      else if((digit == 'D') || (digit == 'E') || (digit == 'F')){
        number = 3;
      }
      else if((digit == 'G') || (digit == 'H') || (digit == 'I')){
        number = 4;
      }
      else if((digit == 'J') || (digit == 'K') || (digit == 'L')){
        number = 5;
      }
      else if((digit == 'M') || (digit == 'N') || (digit == 'O')){
        number = 6;
      }
      else if((digit == 'P') || (digit == 'Q') || (digit == 'R') || (digit == 'S')){
        number = 7;
      }
      else if((digit == 'T') || (digit == 'U') || (digit == 'V') || (digit == 'W')){
        number = 8;
      }
      else if((digit == 'X') || (digit == 'Y') || (digit == 'Z')){
        number = 9;
      }
      else{
        System.out.println("Please enter a valid number");
      }
    }while(number == 0)

    System.out.printf("The letter %s corresponds to the number %d", digit, number);

  }
}
