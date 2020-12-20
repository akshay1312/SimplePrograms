package StringProgram;
import java.util.HashMap;
import java.util.Map;

/*
 Given an array of unique characters arr and a string str.
 Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr.  
 Example:
 input:  arr = ['x','y','z'], str = "xyyzyzyx"
 output: "zyx"
 
 Algorithm: Creating a window of valid substring and squeezing it to find the shortest substring
 1. Create a map of all chars in the array or string (to look up chars). 
    Map will be used to look the chars and count the number of occurences of each char.
    If map.containsValue != 0, that means we have a valid substring else not.
 2. Use two pointer i and j - to find valid substrings.
 3. Keep incrementing i until you we have a valid substring.
 4. Once we have a valid substring get the minLen, start and end positions.
 5. Then start moving j pointer until we dont hit a invalid substring. If the substring becomes invalid move j backward. 
 6. Compare the length of window substring with the minLen. Accordingly update minLen, start and end pointers.
 7. i and j pointers will find those valid substrings whereas start and end will point to the shortest one.
*/

public class ShortestSuString {

  public static String getShortestUniqueSubstring(char[] arr, String s) {
    int i = 0, j = 0, alen = arr.length, slen = s.length();
    int minLen = 0, start = 0, end = 0;

    // Track every char and its number of occurences
    Map<Character, Integer> map = new HashMap<>();
    for (char c : arr) {
      map.put(c, 0);
    }

    while (i < slen && j < slen) {

      // Move the pointer i
      if (map.containsKey(s.charAt(i)) && i < slen) {
        int v = map.get(s.charAt(i));
        map.put(s.charAt(i), ++v);
        i++;
      }

      // Now move pointer j. To minimize the window of valid substring
      while (j < i) {

        // Valid substring found
        if (!map.containsValue(0)) {

          // To keep track of minimum length substring
          int curLen = s.substring(j, i).length();
          if (minLen == 0 || curLen < minLen) {
            minLen = curLen;
            start = j;
            end = i;
          }

          int v = map.get(s.charAt(j));
          map.put(s.charAt(j), --v);
          j++;
        }

        // Substring became invalid, backtrack j pointer
        else if (j > 0) {

          int v = map.get(s.charAt(--j));
          map.put(s.charAt(j), ++v);
          break;
        } else {
          break;
        }

      }

    }

    return s.substring(start, end);

  }

  public static void main(String[] args) {
    char[] arr = { 'x', 'y', 'z' };
    String s = "xyyzzyx";
    System.out.println(getShortestUniqueSubstring(arr, s));
  }

}
