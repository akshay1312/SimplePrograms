package JavaPrograms;

import java.util.Stack;

/**
 * Created by Akshay1312 on 11/15/2015.
 */
public class FindValidParenthesis
{

    public static void main (String args[])
    {
        String s1 = "()";
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

        System.out.print("Number Of valid parenthesis are :: " + counter);
        System.out.print("is valid :: " + isValid(s1));
    }


    public static  boolean isValid(String s) {
        char[] charStr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : charStr) {
            if(c == '(' || c=='{' || c == '[') {
                stack.push(c);
            } else if(c == ')' || c == ']' || c == '}') {
                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }



}
