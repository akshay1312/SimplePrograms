package JavaPrograms;

/**
 * Created by Akshay1312 on 11/15/2015.
 */
public class ReverseStringWithoutSpace
{

    public static void main (String args[])
    {
        String s1 = "This is cool"; // output should be: c,b$a

        ReverseStringWithoutSpace stringReverse = new ReverseStringWithoutSpace();

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
            if(isSpace(ch[l]))
                l++;
            else if (isSpace(ch[r]))
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

        return new String(ch);
    }

    private boolean isSpace(char c)
    {
        return (c == ' ');
    }
}
