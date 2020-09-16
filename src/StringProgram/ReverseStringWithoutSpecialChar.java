package StringProgram;

import java.util.Arrays;

/**
 * Created by Akshay1312 on 11/15/2015.
 */
public class ReverseStringWithoutSpecialChar
{

    public static void main (String args[])
    {
        String s1 = "a,b$c"; // output should be: c,b$a

        ReverseStringWithoutSpecialChar stringReverse = new ReverseStringWithoutSpecialChar();

        String result = stringReverse.reverse(s1);

        System.out.print("String reverse of "+ s1 +" is :: " + result);
    }

    private String reverse(String s1)
    {
        char[] ch = s1.toCharArray();
        int r = ch.length - 1;
        int l = 0;
        while(l < r)
        {
            if(!isAlphabet(ch[l]))
                l++;
            else if (!isAlphabet(ch[r]))
                r--;
            else
            {
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
        }

        return Arrays.toString(ch);
    }

    private boolean isAlphabet(char c)
    {
        return ((c >= 'A' && c <= 'Z')||(c >= 'a' && c <= 'z'));
    }
}
