package DataStructure.sorting;

/**
 * Created by Akshay1312 on 11/15/2015.
 */
public class InsertionSort
{
    public static void main(String args[])
    {
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

        insertionSort(arr);

        for(int i = 0 ; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static void insertionSort(int array[])
    {
        int n = array.length;
        for (int j = 1; j < n; j++)
        {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) )
            {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }
}
