package ArrayPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : apitale
 * @Date : 12/22/20
 */
public class RearrangePositiveNegativeNumbers {

  /*public static void main(String[] args) {
    Integer[] input = {5, 3, -3, -4, 0, 2, -1, 4, -7, 2};

    int j=0, temp;
    for(int i =0; i<input.length; i++) {
        if(input[i] < 0) {
          if(i != j) {
            temp = input[i];
            input[i] = input[j];
            input[j] = temp;
          }
          j++;
        }
    }
    LinkedList<Integer> positiveList = new LinkedList<Integer>();
    LinkedList<Integer> negativeList = new LinkedList<Integer>();

    for (Integer n : input) {
      if (n >= 0) {
        positiveList.add(n);
      } else {
        negativeList.add(n);
      }
    }
    positiveList.addAll(negativeList);

    System.out.println("result :: " + positiveList);
  }*/

  static void printArray(Integer arr[], int n)
  {
    for (int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");
  }

  // Driver code
  public static void main(String args[])
  {
    Integer arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
    int n = arr.length;

    rearrange(arr, n);
    printArray(arr, n);

    List<Integer> inputList = new ArrayList<>();
    inputList.add(1);
    inputList.add(2);
    inputList.add(3);
    inputList.add(4);
    inputList.add(5);

    for(int i = 0 ; i < inputList.size(); i++) {
      inputList.remove(i);
    }
    System.out.println(inputList);
    Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>());
  }

  static void rearrange(Integer arr[], int n)
  {
    int j = 0, temp;
    for (int i = 0; i < n; i++) {
      if (arr[i] > 0) {
        if (i != j) {
          temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
        j++;
      }
    }
  }

}
