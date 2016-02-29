package JavaPrograms;

/**
 * Created by Akshay1312 on 11/13/2015.
 */
public class FibonacciSeries
{

    public static void main (String args[])
    {
        int n0 =0, n1 = 1, n3, count = 10;
        System.out.print(n0 + " "+ n1);

        for(int i = 2; i < count; ++i)
        {
            n3 = n0 + n1;
            System.out.print(" "+n3);
            n0 = n1;
            n1 = n3;
        }
    }
}
