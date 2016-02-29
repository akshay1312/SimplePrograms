package DataStructure;

/**
 * Created by Akshay1312 on 11/15/2015.
 */
public class BubbleSort {

    public static void main(String args[]) {
        BubbleSort sort = new BubbleSort();
        int[] arr = new int[10];
        arr[0] = 3;
        arr[1] = 5;
        arr[2] = 1;
        arr[3] = 7;
        arr[4] = 9;
        arr[5] = 6;
        arr[6] = 4;
        arr[7] = 2;
        arr[8] = 8;
        arr[9] = 10;

        int[] result = sort.bubbleSort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.println(result[i]);
    }

    /**
     * Bubble sort steps are as follows.
     * <p>
     * 1. Compare array[0] & array[1]
     * 2. If array[0] > array [1] swap it.
     * 3. Compare array[1] & array[2]
     * 4. If array[1] > array[2] swap it.
     * ...
     * 5. Compare array[n-1] & array[n]
     * 6. if [n-1] > array[n] then swap it.
     * <p>
     * After this step we will have largest element at the last index.
     * <p>
     * Repeat the same steps for array[1] to array[n-1]
     *
     * @param arr
     * @return
     */
    private int[] bubbleSort(int[] arr) {
        int length = arr.length;
        if (arr != null && length > 0) {
            for (int i = 0; i < length; i++) {
                for (int j = 1; j < (length - i); j++) {
                    if (arr[j - 1] > arr[j]) {
                        swap(arr, j);
                    }
                }
            }
            return arr;
        }
        return null;
    }

    private void swap(int[] arr, int j) {
        int temp = arr[j - 1];
        arr[j - 1] = arr[j];
        arr[j] = temp;
    }
}