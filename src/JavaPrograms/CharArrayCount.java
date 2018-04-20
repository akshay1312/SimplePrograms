package JavaPrograms;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by apitale on 2018-04-16.
 */
public class CharArrayCount {

  static final int NO_OF_CHARS = 256;
  static char count[] = new char[NO_OF_CHARS];

  /* calculate count of characters
     in the passed string */
  static void getCharCountArray(String str)
  {
    for (int i = 0; i < str.length();  i++)
      count[str.charAt(i)]++;
  }

  /* The method returns index of first non-repeating
     character in a string. If all characters are repeating
     then returns -1 */
  static int firstNonRepeating(String str)
  {
    getCharCountArray(str);
    int index = -1, i;

    for (i = 0; i < str.length();  i++)
    {
      if (count[str.charAt(i)] == 1)
      {
        index = i;
        break;
      }
    }

    return index;
  }


  // Driver method
  public static void main (String[] args)
  {
    String str = "geeksforgeeks";
    int index =  firstNonRepeating(str);
    int charAsscii =  firstNonRepeating2(str);
    System.out.println("Non Repeatable char is :: " + Character.toString((char) charAsscii));

    System.out.println(index == -1 ? "Either all characters are repeating or string " +
        "is empty" : "First non-repeating character is " +  str.charAt(index));
  }

  private static int firstNonRepeating2(String str) {
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

    for(char ch : str.toCharArray()) {
      if(map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      }else {
        map.put(ch, 1);
      }
    }

    int result = -1;
    for(Map.Entry<Character, Integer> entry : map.entrySet()) {
       if(entry.getValue() == 1) {
         result =  entry.getKey();
       }
    }
    return result;
  }
}
