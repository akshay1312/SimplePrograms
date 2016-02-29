package DataStructure;

/**
 * Created by Akshay1312 on 11/15/2015.
 */
public class SelectionSort
{
    public static void main(String args[])
    {
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

        int [] result = selectionSort(arr);

        for(int i = 0 ; i < arr.length; i++)
            System.out.println(result[i]);
    }

    public static int[] selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }
}
