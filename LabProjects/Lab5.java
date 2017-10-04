
/*********************************************\
*
*  John Naylor and Baochau Tran
*  CMSCC 255 session 2
*  Lab 5
*  Guess random number
*
\*********************************************/

import java.util.Scanner;
import java.util.Random;

public class Iteration{

  public static void main(String[] argv){

    Scanner userInput = new Scanner(System.in);
    Random randNum = new Random();

    while(true){

      int target = randNum.nextInt(100) + 1;
      int attempts = 1;

      while(true){

        System.out.print("[+] Enter your guess between 1 - 100 (To exit enter a negative number): ");
        int guess = userInput.nextInt();

        if(guess < 0){
          break;
        }

        if(guess == target){
          System.out.println("[*] You're Right");
          System.out.println("[*] Attempts = " + attempts);
          break;
        }else if(guess > target){
          System.out.println("[!!!] Too High");
        }else if(guess < target){
          System.out.println("[!!!] Too Low");
        }else{
          System.out.println("[!!!] What even did you enter???");
        }

        attempts++;

      }

        System.out.println("[*] To play again with a new number enter \'y\'/\'n\'");
        char playAgain = userInput.next().charAt(0);

        if(playAgain != 'y'){
          break;
        }

    }
  }
}
