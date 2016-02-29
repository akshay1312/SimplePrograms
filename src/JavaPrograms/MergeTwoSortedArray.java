package JavaPrograms;

/**
 * Created by Akshay1312 on 11/13/2015.
 */
public class MergeTwoSortedArray
{
    public static void main (String args[])
    {
        Integer[] s1 = {2,4,6, null, null};
        Integer[] s2 = {1,3,5};

        int i = s1.length -1;
        int j = s2.length - 1;
        int x = i + j -1;
        while (i>=0 && j>=0) {
            if (s1[i] >= s2[j])
                s1[x--] = s1[i--];
            else
                s1[x--] = s2[j--];
        }
        while(i >= 0) s1[x--] = s1[i--];
        while(j >= 0) s1[x--] = s2[j--];

        System.out.print("Merge and sorted array : " + s1);
    }
}
