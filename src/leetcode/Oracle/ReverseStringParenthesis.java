package leetcode.Oracle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 *
 * Input: s = "(abcd)"
 * Output: "dcba"
 *
 *
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * Explanation: The substring "love" is reversed first, then the whole string is reversed.
 *
 *
 * Input: s = "(ed(et(oc))el)"
 * Output: "leetcode"
 * Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 *
 *
 * Input: s = "a(bcdefghijkl(mno)p)q"
 * Output: "apmnolkjihgfedcbq"
 *
 *
 * @author : apitale
 * @Date : 1/9/21
 */
public class ReverseStringParenthesis {

  public static void main(String[] args) {
    ReverseStringParenthesis reverseStringParenthesis = new ReverseStringParenthesis();
    System.out.println("REsult : " + reverseStringParenthesis.reverseParentheses("(abcd)"));
  }
  public String reverseParentheses(String s) {
    Stack<Character> stack = new Stack();
    Deque<Character> d = new ArrayDeque();
    StringBuilder sb  = new StringBuilder();
    for(Character c : s.toCharArray()) {
      if(c != ')') {
        stack.push(c);
      }else {
        while(!stack.isEmpty() && stack.peek() != '('){
          d.add(stack.pop()); //d c b a
        }

        //remove the open bracket
        if(!stack.isEmpty()) {
          stack.pop();
        }

        // pollFirst() method of deque remvoes the first element of deque
        while(!d.isEmpty()){
          stack.push(d.pollFirst()); // d c b a
        }

      }
    }

    String result = "";
    while(!stack.empty()) {
      result = stack.pop() + result;
    }

    return result;
  }
}
