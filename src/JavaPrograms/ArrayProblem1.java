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
    Integer[] arr = { 1, 7, 3, 4 };
    Integer[] result = new Integer[arr.length];

    // first solution
    for (int i = 0; i < arr.length; i++) {
      int temp = 1;
      for (int j = 0; j < arr.length; j++) {
        if (i != j) {
          temp = temp * arr[j];
        }
        result[i] = temp;
      }
    }

    // second solution
    // Initialize memory to all arrays
    int n = arr.length;
    int left[] = new int[n];
    int right[] = new int[n];
    int prod[] = new int[n];

    int i, j;

        /* Left most element of left array is always 1 */
    left[0] = 1;

        /* Rightmost most element of right array is always 1 */
    right[n - 1] = 1;

        /* Construct the left array */
    for (i = 1; i < n; i++)
      left[i] = arr[i - 1] * left[i - 1];

        /* Construct the right array */
    for (j = n - 2; j >= 0; j--)
      right[j] = arr[j + 1] * right[j + 1];

        /* Construct the product array using
           left[] and right[] */
    for (i = 0; i < n; i++)
      prod[i] = left[i] * right[i];

        /* print the constructed prod array */
    for (i = 0; i < n; i++)
      System.out.print(prod[i] + " ");

    System.out.println("Result output :: " + result.toString());
  }
}
