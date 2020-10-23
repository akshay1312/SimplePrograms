package StringProgram;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: "abcabcbb" Output: 3
 *
 * Explanation: The answer is "abc", with the length of 3.
 *
 * @author akshay Date 2019-03-31 16:44
 */
public class LongestSubString {


  public static void main(String[] args) {
    //int i = lengthOfLongestSubstring("dvdf");
    int i = lengthOfLongestSubstring2("dabbcabcd");
    System.out.println("length :: " + i);
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
      //  sb = new StringBuffer().append(c);
      }
    }

    if (result.length() < sb.toString().length()) {
      result = sb.toString();
    }
    System.out.println("Result :: " + result);
    return result.length();
  }

  static int lengthOfLongestSubstring1(String s) {
    Map<Character, Integer> hashmap = new HashMap();
    int start = -1;
    int length = 0;
    for(int i =0; i<s.length(); i++) {
      if(hashmap.containsKey(s.charAt(i))) {
        Integer newStart = hashmap.get(s.charAt(i));
        start = Math.max(start, newStart);
      }
      length = Math.max(i, start);
      hashmap.put(s.charAt(i), i);
    }
    return  length;
  }

  static int lengthOfLongestSubstring2(String s) {
    Map<Character, Integer> hashmap = new HashMap();
    int length = 0;
    StringBuffer sb = new StringBuffer();
    for(int i =0; i<s.length(); i++) {
      if(!hashmap.containsKey(s.charAt(i))) {
        hashmap.put(s.charAt(i), i);
        sb = sb.append(s.charAt(i));
      } else {
        length = Math.max(sb.length(), length);
        sb = new StringBuffer();
        i = hashmap.get(s.charAt(i));
        hashmap.remove(s.charAt(i));
      }
    }
    return  length;
  }
}
