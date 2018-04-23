package JavaPrograms;

/**
 * Created by apitale on 2018-04-22.
 */
public class ExcelColumnNumber {

  public static void main (String args[]) {
    System.out.println("Column number :: " + titleToNumber("BA"));
  }
  public static int titleToNumber(String s) {
    int result = 0;
    for(int i = 0 ; i < s.length(); i++) {
      result = result * 26 + (s.charAt(i) - 'A' + 1);
    }
    return result;
  }
}
