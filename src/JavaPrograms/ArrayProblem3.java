package JavaPrograms;

/**
 * aabbbcc => a2b3c2

   aaa => a3

   aabbaa   => a2b2a2

 * Created by apitale on 2018-04-12.
 */
public class ArrayProblem3 {

  public static void main(String args[]) {
    String input = "aabbbcc";
    char[] charArray = input.toCharArray();

    StringBuffer sb = new StringBuffer();
    int count = 0;
    int length = charArray.length;

    for(int i = 0; i < length; i++) {
      char c = charArray[i];
      for(int j = i; j < length; j++) {
         if(c == charArray[j])
           count++;
        else
          break;
      }
      if(count > 1) {
        i = i + (count - 1);
        sb.append(c).append(count);
      }else {
        sb.append(c);
      }
      count = 0;
    }
    System.out.println(sb.toString());
  }
}
