package JavaPrograms;

import java.util.Stack;

/**
 * Created by Akshay1312 on 11/15/2015.
 */
public class FindValidParenthesis
{

    public static void main (String args[])
    {
        String s1 = ")()())";
        char[] ch = s1.toCharArray();
        Stack<Integer> parenthesis = new Stack<>();
        parenthesis.push(-1);
        int counter = 0;
        for(int i = 0; i< ch.length; i++)
        {
            if(ch[i] == '(')
                parenthesis.push(i);
            if(ch[i] == ')')
            {
                parenthesis.pop();
                if(!parenthesis.empty())
                    counter = Math.max(counter, i - parenthesis.peek());
                else
                    parenthesis.push(i);
            }
        }

        System.out.print("String reverse of Akshay is :: " + counter);
    }

}
