package goldman;

/**
 * Given a number in the form of a string, return a single digit sum of the given number.
 * for eg. 12345 -> 15 -> 6, you have to return 6
 * explanation: so continuously sum till we get a single digit,
 * given number sum will be - > 15 (it still in double digits) then sum it again - > 6
 * we just return 6
 *
 * @author : apitale
 * @Date : 11/16/20
 */
public class AddNumbers {

  public static void main(String[] args) {
    System.out.println("result :: "+ addNumbers("12345123456565656565656655654335"));
  }

  private static int addNumbers(String s) {
    int result = addStringDigits(s);
    while (result > 10) {
      result = addStringDigits(String.valueOf(result));
    }
    return result;
  }

  private static int addStringDigits(String s) {
    int result = 0;
    for(int i =0; i < s.length(); i++) {
      result = result + Character.getNumericValue(s.charAt(i));
    }
    return result;
  }
}
