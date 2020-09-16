package ArrayPrograms;

import java.util.stream.IntStream;

/**
 * @author akshay Date 2019-04-27 17:16
 */
public class UBSL2Program {

  public static String roll(String s, int[] roll) {

    int toRollLength = s.length();
    int each_character_roll[] = new int[s.length()];
    char[] toRollCharArr = s.toCharArray();

    for (int i = 0; i < roll.length; ++i) {
      ++each_character_roll[0];
      int noOfRoll = roll[i];
      if (noOfRoll >= each_character_roll.length) {
      } else {
        --each_character_roll[noOfRoll];
      }
    }

    IntStream.range(1, toRollLength).forEach(index -> each_character_roll[index]
        = each_character_roll[index] + each_character_roll[index - 1]);

    IntStream.range(0, toRollLength).forEach(index -> {
      toRollCharArr[index] = roll_character(toRollCharArr[index], each_character_roll[index]);
    });

    return String.valueOf(toRollCharArr);

  }

  private static char roll_character(char c, int roll) {
    roll = roll % 26;
    int character = c - 'a';

    return (char) ('a' + (character + roll) % 26);
  }

  // Driver code
  public static void main(String[] args) {
    String s = "geeks";
    int[] k = {1, 2, 5};
    System.out.println(roll(s, k));
  }
}
