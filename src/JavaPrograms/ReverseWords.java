package JavaPrograms;

import java.util.Objects;

/**
 * Created by akshay pitale on 2018-04-10.
 */
public class ReverseWords {

  public static String reverseWords(char[] message) {
    StringBuilder sb = new StringBuilder();
    StringBuilder result = new StringBuilder();
    for (int i = message.length - 1; i >= 0; i--) {
      if (message[i] != ' ') {
        sb.insert(0, message[i]);
      } else {
        result.append(sb).append(" ");
        sb = new StringBuilder();
      }
    }
    return result.append(sb).toString();
  }

  public static String reverseWords(String s) {
    String[] wordArray =  s.split(" ");
    String result = "";
    for(int i = wordArray.length -1 ; i >= 0; i--) {
      if(Objects.equals(result, "")) {
        result = result + wordArray[i];
      }else {
        result = result + " " + wordArray[i];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // run your function through some test cases here
    // remember: debugging is half the battle!
    char[] message = { 'c', 'a', 'k', 'e', ' ',
        'p', 'o', 'u', 'n', 'd', ' ',
        's', 't', 'e', 'a', 'l' };
    String s = reverseWords("Akshay here how are you");
    System.out.println(reverseWords(message));
  }
}
