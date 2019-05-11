package CrackingCode;

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
}
