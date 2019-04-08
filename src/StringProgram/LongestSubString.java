package StringProgram;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 *
 * @author akshay Date 2019-03-31 16:44
 */
public class LongestSubString {


  public static void main(String[] args) {
    lengthOfLongestSubstring("geeksforgeeks");
  }

  static int lengthOfLongestSubstring(String s) {
    char[] input = s.toCharArray();

    Map<Character, Integer> hashmap = new HashMap();
    StringBuffer sb = new StringBuffer();
    String result = "";
    for (char c : input) {
      if (!hashmap.containsKey(c)) {
        hashmap.put(c, 1);
        sb = sb.append(c);
      } else {
        if (result.length() < sb.toString().length()) {
          result = sb.toString();
        }
        sb = new StringBuffer().append(c);
      }
    }

    System.out.println("Result :: " + result);
    return result.length();
  }

}
