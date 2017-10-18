
public class Lab8 {
  public static void main(String[] argv){

    String[] customerNames = new String[7];

    customerNames[0] = "Chris";
    customerNames[1] = "Lois";
    customerNames[2] = "Meg";
    customerNames[3] = "Pete";
    customerNames[4] = "Stewie";

    for(String customer : customerNames){
      System.out.println(customer);
    }

    System.out.println();

    customerNames[5] = customerNames[3];
    customerNames[6] = customerNames[4];

    customerNames[3] = "Meg";
    customerNames[4] = "Brian";

    for(String customer : customerNames){
      System.out.println(customer);
    }

    System.out.println();

    modifyArray(customerNames);

    // for(String customer : customerNames){
    //   System.out.println(customer);
    // }
    //
    // System.out.println();

  }

  public static void modifyArray(String[] customer){

    for(int i = customer.length-1; i >= 0; i--){
      if(customer[i].equals("Meg")){
        for(int j = i; j < customer.length; j++){
          if(j != customer.length-1){
            customer[j] = customer[j+1];
          }else{
            customer[j] = null;
          }
        }
      }
    }

    for(String name : customer){
        System.out.println(name);
    }

    System.out.println();

  }


}
