/*
*
* 10/11/17
* John Naylor
* CMSC255 Section 2
* Lab7
* Methods
*
*/

import java.io.*;
import java.util.Scanner;

public class Lab7 {

   public static void main(String[] argv) {
     // variable declarations for part 1
     String date;
     String partner1Name;
     String partner2Name;
     Scanner in = new Scanner(System.in);
     // prompt for input for part 1
     System.out.print("Enter a date:");
     date = in.nextLine();
     System.out.print("Enter the partner one's first and last name:");
     partner1Name = in.nextLine();
     System.out.print("Enter the partner two's first and last name:");
     partner2Name = in.nextLine();
     // write the call the method in Part 1

     greetings(partner1Name, partner2Name, date);

     // variable declarations for part 2
     int num1;
     int num2;
     int num3;
     int num4;
     int num5;

     // user prompts for part 2
     System.out.print("Enter first number:");
     num1 = in.nextInt();
     System.out.print("Enter second number:");
     num2 = in.nextInt();
     System.out.print("Enter third number:");
     num3 = in.nextInt();
     System.out.print("Enter fourth number:");
     num4 = in.nextInt();
     System.out.print("Enter fifth number:");
     num5 = in.nextInt();

     // call the methods for part 2 inside the println statement

     System.out.println(max(num1, num2));
     System.out.println(abs(num1, num2, num3, num4, num5));

   }// end main

   public static void greetings(String name1, String name2, String date){

     System.out.println("Today is: " + date);
     System.out.printf("We are %s and %s\n", name1, name2);

   }

   public static int max(int a, int b){
     if(a > b){
       return a;
     }else{
       return b;
     }
   }

   public static int abs(int a, int b, int c, int d, int e){

     int sum = 0;

     int[] nums = {a, b, c, d, e};

     for(int i = 0; i < nums.length; i++){
       if(nums[i] < 0){
         sum -= nums[i];
       }else{
         sum += nums[i];
       }
     }

     return sum;


   }
}
