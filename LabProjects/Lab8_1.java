import java.util.*;

public class Lab8_1{
  public static void main(String[] argv){

    ArrayList<String> customerNames = new ArrayList<String>();

    customerNames.add("Chris");
    customerNames.add("Lois");
    customerNames.add("Meg");
    customerNames.add("Peter");
    customerNames.add("Stewie");

    for(String customer : customerNames){
      System.out.println(customer);
    }

    System.out.println();

    customerNames.add(2, "Brian");
    customerNames.add(2, "Meg");

    for(String customer : customerNames){
      System.out.println(customer);
    }

    System.out.println();

    for(int i = 0; i < customerNames.size(); i++){
      if(customerNames.get(i).equals("Meg")){
        customerNames.remove(i);
      }
    }

    for(String customer : customerNames){
      System.out.println(customer);
    }

  }

}
