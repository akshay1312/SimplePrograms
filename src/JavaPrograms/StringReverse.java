package JavaPrograms;

/**
 * Created by Akshay1312 on 11/13/2015.
 */
public class StringReverse
{
    public static void main (String args[])
    {
        String s1 = "Akshay";

        StringReverse stringReverse = new StringReverse();

        String result = stringReverse.reverse(s1);

        System.out.print("String reverse of Akshay is :: " + result);
    }

    private String reverse(String s1)
    {
        char[] ch = s1.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = ch.length - 1; i >= 0; i--)
            sb.append(ch[i]);
        return sb.toString();
    }
}
