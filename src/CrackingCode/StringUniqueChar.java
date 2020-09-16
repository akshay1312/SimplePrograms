package CrackingCode;

import java.util.HashMap;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you can not
 * use additional data structures?
 *
 * @author akshay Date 2019-04-28 16:01
 */
public class StringUniqueChar {

  public static void main(String[] args) {
    String s = "geeks";
    if (checkChar(s)) {
      System.out.println("String has unique char");
    } else {
      System.out.println("String has not unique char");
    }
    System.out.println("First Unique Char is at index :: " + firstUniqChar("dacca"));
    System.out.println("First Unique Char is at index :: " + firstUniqChar("leetcode"));
  }

  private static boolean checkChar(String s) {
    boolean[] charSet = new boolean[256];
    for (int i = 0; i < s.length(); i++) {
      int val = s.charAt(i);
      if (charSet[val]) {
        return false;
      }
      charSet[val] = true;
    }
    return true;
  }

  public static int firstUniqChar(String s) {
    HashMap<Character, Integer> count = new HashMap<Character, Integer>();
    int n = s.length();
    // build hash map : character and how often it appears
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      count.put(c, count.getOrDefault(c, 0) + 1);
    }

    // find the index
    for (int i = 0; i < n; i++) {
      if (count.get(s.charAt(i)) == 1)
        return i;
    }
    return -1;
  }
}
