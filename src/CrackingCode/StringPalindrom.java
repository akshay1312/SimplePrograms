package CrackingCode;

/**
 * write a program to check if two string are anagrams or not ?
 *
 * @author akshay Date 2019-04-30 22:59
 */
public class StringPalindrom {

  public static void main(String[] args) {
    String s1 = "sees";
    if (checkPalindrome(s1)) {
      System.out.println("String are palindrome");
    } else {
      System.out.println("String are not palindrome");
    }
  }

  private static boolean checkPalindrome(String s1) {

    char[] chars = s1.toCharArray();
    int i = 0, j = chars.length-1;
    while (i < j) {
      if (chars[i] == chars[j]) {
        i++;
        j--;
      } else {
        return false;
      }
    }
    return true;
  }
}
