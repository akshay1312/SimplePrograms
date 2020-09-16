package StringProgram;

public class StringPalindrome {

  public static void main(String args[]) {
    System.out.println("result :: " + isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println("result :: " + isPalindrome("0p"));
  }

  public static boolean isPalindrome(String s) {
    char[] ch = s.toCharArray();
    int l = 0;
    int r = ch.length - 1;
    boolean result = false;
    while (l < r) {
      if (!isAlphabate(ch[l])) {
        l++;
      } else if (!isAlphabate(ch[r])) {
        r--;
      } else if (Character.toUpperCase(ch[l]) == Character.toUpperCase(ch[r])) {
        l++;
        r--;
        result = true;
      } else {
        result = false;
      }
    }
    return result;
  }

  public static boolean isAlphabate(char c) {
    return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
  }

}
