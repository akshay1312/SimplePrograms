package CrackingCode;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string without using
 * any additional buffer. NOTE: One or two additional variables are fine. An extra copy of the array
 * is not.
 *
 * @author akshay Date 2019-04-28 16:23
 */
public class RemoveDuplicateChar {

  public static void main(String[] args) {
    String s = "seek";
    System.out.println("After removing duplicate char :: " + checkChar(s));
  }

  private static String checkChar(String s) {
    int[] charSet = new int[256];
    String result = s;
    for (int i = 0; i < s.length(); i++) {
      int val = s.charAt(i);
      charSet[val]++;
      if (charSet[val] == 2) {
        result = s.substring(0, i).concat(s.substring(i + 1));
      }
    }
    return result;
  }
}
