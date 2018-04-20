package JavaPrograms;

/**
 * To find the second largest element in array.
 * <p>
 * Created by Akshay pitale on 2018-02-09.
 */
public class SecondLargestNumber {

  public static void main(String[] args) {

    int arr[] = { 14, 46, 47, 86, 92, 52, 48, 36, 66, 85 };
    int i, first, second;

        /* There should be atleast two elements */
    if (arr == null || arr.length < 2) {
      System.out.print(" Invalid Input ");
      return;
    }
    int v = arr.length;

    first = second = arr[0];
    for (i = 0; i < v; i++) {
            /* If current element is smaller than
            first then update both first and second */
      if (arr[i] > first) {
        second = first;
        first = arr[i];
      }

            /* If arr[i] is in between first and
               second then update second  */
      else if (arr[i] > second && arr[i] != first)
        second = arr[i];
    }

    if (second == Integer.MIN_VALUE)
      System.out.print("There is no second largest" +
          " element\n");
    else
      System.out.print("The second largest element" +
          " is " + second);

  }
}
