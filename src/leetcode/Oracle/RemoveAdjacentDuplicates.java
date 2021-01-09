package leetcode.Oracle;

import java.util.Stack;

/**
 * @author : apitale
 * @Date : 12/30/20
 */
public class RemoveAdjacentDuplicates {


  public static void main(String[] args) {
    RemoveAdjacentDuplicates removeAdjacentDuplicates = new RemoveAdjacentDuplicates();
    System.out.println("Result :: " + removeAdjacentDuplicates.removeDuplicates("abbaca"));
  }

  public String removeDuplicates(String S) {
    Stack<Character> stack = new Stack<>();
    StringBuilder result = new StringBuilder();
    for (int i = S.length() - 1; i >= 0; i--) {
      if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
        stack.pop();
      } else {
        stack.push(S.charAt(i));
      }
    }
    while (!stack.isEmpty()) {
      result.append(stack.pop());
    }
    return result.toString();
  }
}
