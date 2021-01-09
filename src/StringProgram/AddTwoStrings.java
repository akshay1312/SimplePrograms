package StringProgram;

/**
 * @author : apitale
 * @Date : 12/7/20
 */
public class AddTwoStrings {

  public static void main(String[] args) {
    System.out.println("result : " + addStrings("9", "99"));
  }

  public static String addStrings(String num1, String num2) {
    String input1 = num1, input2 = num2;
    int len1 = num1.length();
    int len2 = num2.length();
    if (len1 < len2) {
      int leadingZero = len2 - len1;
      while (leadingZero != 0) {
        input1 = "0" + input1;
        leadingZero--;
      }
    }

    if (len1 > len2) {
      int leadingZero = len1 - len2;
      while (leadingZero != 0) {
        input2 = "0" + input2;
        leadingZero--;
      }
    }

    StringBuilder result = new StringBuilder();
    int carry = 0;
    for (int i = input1.length() - 1; i >= 0; i--) {
      int sum = carry + input1.charAt(i) - '0' + input2.charAt(i) - '0';
      carry = sum >= 10 ? 1 : 0;
      sum = sum % 10;
      result.append(sum);
    }
    if (carry > 0) {
      result.append(carry);
    }
    return result.reverse().toString();
  }

}
