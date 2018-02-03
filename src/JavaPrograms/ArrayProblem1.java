package JavaPrograms;

/**
 * Problem Statement :
 * <p>
 * You have an array of integers, and for each index you want to find the product of every integer
 * except the integer at that index.
 * Write a method getProductsOfAllIntsExceptAtIndex() that takes an array of integers and returns
 * an array of the products.
 * <p>
 * For example, given: [1, 7, 3, 4]
 * your method would return: [84, 12, 28, 21]
 * <p>
 * Created by apitale on 2018-01-19.
 */
public class ArrayProblem1 {

  public static void main(String args[]) {
    Integer[] list = { 1, 7, 3, 4 };
    Integer[] result = new Integer[list.length];

    for (int i = 0; i < list.length; i++) {
      int temp = 1;
      for (int j = 0; j < list.length; j++) {
        if (i != j) {
          temp = temp * list[j];
        }
        result[i] = temp;
      }
    }

    for (int i = 0,j=0; i < list.length; i++) {
      int temp = 1;
        if (i != j) {
          temp = temp * list[j];
        }
        result[i] = temp;
    }

    System.out.println("Result output :: " + result.toString());
  }
}
