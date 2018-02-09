package JavaPrograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by apitale on 2018-02-09.
 */
public class LengthOfSubString {

  public static void main(String[] args) {

    // print  the length of largest sub string and the starting point in the string

    String input = "aaabbbbbcdddde";

    char[] inputArray = input.toCharArray();

    int l = 0;
    int r = l + 1;
    int startPoint = 0;
    int len = 0;
    int maxLen = 0, point = 0;
    while (r < inputArray.length) {
      if(inputArray[l] == inputArray[r]) {
        startPoint = l;
        r++;
        len = r - l;
      } else {
        if(maxLen < len) {
          maxLen = len;
          point = startPoint;
        }
        l = r;
        r++;
      }
    }
    System.out.println("Starting point of subString :: " + point + " length of the string ::" + maxLen);


  }
}
