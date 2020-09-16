package StringProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by apitale on 2018-01-27.
 */
public class StringFindDuplicates {
  public static void main(String[] args) {
    duplicateWords("Java is java again");
  }

  static void duplicateWords(String inputString) {

    HashMap<String, Integer> wordCount = new HashMap<>();

    String[] words = inputString.split(" ");

    for(String input : words) {
      if(wordCount.containsKey(input.toLowerCase()))   {
        wordCount.put(input.toLowerCase(), wordCount.get(input.toLowerCase()) + 1);
      } else {
        wordCount.put(input.toLowerCase(), 1);
      }
    }
    Set<String> keys = wordCount.keySet();
    System.out.println("Keys : " + keys.toString());
    for(String result : keys) {
      if(wordCount.get(result) > 1) {
        System.out.println(result + ":" + wordCount.get(result));
      }
    }
  }

}
