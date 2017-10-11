
public class ArrayPractice{
  public static void main(String[] argv){

    int[] intArray = new int[10];

    for(int i = 0; i < intArray.length; i++){
      intArray[i] = i * i;
    }

    for(int j = 0; j < intArray.length; j++){
      Sytem.out.println(intArray[j]);
    }
  }
}
