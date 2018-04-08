package JavaPrograms;

import java.util.Stack;

/**
 * Created by apitale on 2018-04-08.
 */
public class SmallStringNumber {

  static String generateLowestNumber(String number, int n) {
    Stack<Integer> stack = new Stack<>();
    for(Character c : number.toCharArray()) {

      int num = Character.getNumericValue(c);
      if(!stack.isEmpty() && n != 0) {
         if(num < stack.peek()) {
           stack.pop();
           n--;
           stack.push(num);
         }else {
           stack.push(num);
         }
      } else {
        stack.push(num);
      }
    }
    while (n != 0) {
      stack.pop();
      n--;
    }
    StringBuffer sb = new StringBuffer();
    while(!stack.isEmpty()) {
      sb = sb.insert(0, stack.pop());
    }
    return sb.toString();
  }

  static String generateLowestNumber2(String str, int num) {
    if(num == 0) {
      return str;
    }

    int index = str.length() -1;
    for(int i=0;i< str.length() -1; i++) {
      if(getNum(str,i) > getNum(str, i+1)) {
        index = i;
        break;
      }
    }
    String newStr = str.substring(0, index);
    if(index < str.length() - 2) {
      newStr += str.substring(index+1);
    }
    return generateLowestNumber(newStr, num -1);
  }

  static int getNum(final String str, final int index) {
    return Character.getNumericValue(str.charAt(index));
  }
  public static void main(String[] args) {
    String result = generateLowestNumber("4205123", 3);
    System.out.println("smallest string number is :: " + result);
  }
}
