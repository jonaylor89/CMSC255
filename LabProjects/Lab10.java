
import java.util.Scanner;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab10{

  private static Scanner userInput = new Scanner(System.in);

  public static void main(String[] argv) throws FileNotFoundException{

    String inputFileName;
    String outputFileName;

    if(argv.length == 0){
      System.out.println("Enter an input file");
      inputFileName = userInput.next();
      System.out.println("Enter an output file");
      outputFileName = userInput.next();
    }else{
      inputFileName = argv[0];
      outputFileName = argv[1];
    }

    File inputFile = new File(inputFileName);
    Scanner in = new Scanner(inputFile);
    PrintWriter out = new PrintWriter(outputFileName);

    String[] inputStrings = {};

    while(in.hasNextLine() && in.hasNext()){
      inputStrings = Arrays.copyOf(inputStrings, inputStrings.length+1);

      inputStrings[inputStrings.length-1] = in.nextLine().trim();
    }

    String s1 = inputStrings[0].substring(0, 5);

    String s2 = String.valueOf(inputStrings[0].charAt(5));

    String s3 = String.valueOf(inputStrings[0].charAt(0));

    String s4 = inputStrings[1].substring(1);

    String s5 = inputStrings[2].substring(2);

    String s6 = inputStrings[3].substring(1);

    String s7 = String.valueOf(inputStrings[4].charAt(inputStrings[4].length()-1));

    String s8 = String.valueOf(inputStrings[7].charAt(0));

    String s9 = inputStrings[8].substring(0, 6);

    String s10 = inputStrings[5].substring(7, 11);

    String s11 = inputStrings[5].substring(3, 6);

    String s12 = inputStrings[6].substring(0, 3);

    String s13 = inputStrings[6].substring(5, 7);

    String s14 = String.valueOf(inputStrings[1].charAt(0));

    String s15 = String.valueOf(inputStrings[7].charAt(5));

    String s16 = inputStrings[8].substring(17, 19);

    int i17 = inputStrings[0].indexOf('H');

    int i18 = inputStrings[1].indexOf('a');


    int stopVar = 50;

    while(stopVar > 0){
      out.print(i17);
      stopVar--;
    }

    out.println("\n\n\n");

    out.println(s1 + s2 + s3 + s4 + s5 + s6 + s7);

    out.print("   " + s8 + s2 + s10 + s2 + s11);

    out.print("   " + s9 + s2 + s12);

    out.println("     " + s14 + s13 + s15 + s16);

    out.print("\n\n\n");

    stopVar = 50;

    while(stopVar > 0){
      out.print(i18);
      stopVar--;
    }

    in.close();
    out.close();

  }
}
