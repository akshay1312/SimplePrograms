package StringProgram;

/**
 * Example: inputStr = "abcde" subStr = "cd" return = "e"
 *
 * @author akshay Date 2019-03-01 15:37
 */
public class RemainderString {

  public static void main(String args[]) {
    String input = "abcde";
    String subInput = "bc";
    char[] inputChar = input.toCharArray();
    char[] subStr = subInput.toCharArray();
    int index = 0;
    for (int i = 0; i < inputChar.length; i++) {
      if (inputChar[i] == subStr[0]) {
        String substring = input.substring(i, i + subStr.length);
        if (subInput.equals(substring)) {
          index = i + subStr.length;
          break;
        }
      }
    }
    String result = input.substring(index);
    System.out.println("RemainderString :: " + result);
  }

}
