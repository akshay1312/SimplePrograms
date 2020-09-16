package StringProgram;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author akshay Date 2019-05-31 21:00
 */
public class StringAnagrams {


  public static void main(String args[]) {
    System.out.println("result :: " + isAnagram("anagram", "nagaram"));
    System.out.println("result :: " + isAnagram("rat", "car"));
  }


  public static boolean isAnagram(String s, String t) {
    HashMap<Character, Integer> smap = new HashMap<>();
    int sl = s.length();
    int tl = t.length();
    if (sl != tl) {
      return false;
    }
    for (int i = 0; i < sl; i++) {
      smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
      smap.put(t.charAt(i), smap.getOrDefault(t.charAt(i), 0) - 1);
    }
    for (char c : smap.keySet()) {
      if (smap.get(c) != 0) {
        return false;
      }
    }

    return true;
  }

  // time complexity = o(nlon n ) and space complexity = o(1)
  public static boolean isAnagram1(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
  }


  // time complexity = o(n) and space complexity = o(1)
  // disadvantage -- counter wont be able to count unicode char
  public static boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }

}
