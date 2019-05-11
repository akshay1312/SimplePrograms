package JavaPrograms;

/**
 * Created by Akshay1312 on 11/13/2015.
 */
public class StringReverse {

  public static void main(String args[]) {
    String s1 = "Akshay";

    StringReverse stringReverse = new StringReverse();

    String result = stringReverse.reverse(s1);
    String result2 = stringReverse.reverse2(s1);

    System.out.println("String reverse1 of Akshay is :: " + result);
    System.out.println("String reverse2 of Akshay is :: " + result2);
  }

  private String reverse(String s1) {
    char[] ch = s1.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = ch.length - 1; i >= 0; i--) {
      sb.append(ch[i]);
    }
    return sb.toString();
  }

  private String reverse2(String s1) {
    int p1 = 0;
    int p2 = s1.length() - 1;
    char[] charset = s1.toCharArray();
    while (p1 < p2) {
      char temp = charset[p1];
      charset[p1] = charset[p2];
      charset[p2] = temp;
      p1++;
      p2--;
    }
    return new String(charset);
  }
}
