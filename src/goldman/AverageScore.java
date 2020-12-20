package goldman;/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */

import static java.util.Comparator.comparingInt;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 **  Instructions:
 **
 **  Given a list of student test scores, find the best average grade.
 **  Each student may have more than one test score in the list.
 **
 **  Complete the bestAverageGrade function in the editor below.
 **  It has one parameter, scores, which is an array of student test scores.
 **  Each element in the array is a two-element array of the form [student name, test score]
 **  e.g. [ "Bobby", "87" ].
 **  Test scores may be positive or negative integers.
 **
 **  If you end up with an average grade that is not an integer, you should
 **  use a floor function to return the largest integer less than or equal to the average.
 **  Return 0 for an empty input.
 **
 **  Example:
 **
 **  Input:
 **  [ [ "Bobby", "87" ],
 **    [ "Charles", "100" ],
 **    [ "Eric", "64" ],
 **    [ "Charles", "22" ] ].
 **
 **  Expected output: 87
 **  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
 **  respectively. 87 is the highest.
 */

class Solution
{

  public static class  Average {
    private int count;
    private int average;
    private int total;
    public Average(int count, int average, int total) {

      this.count = count;
      this.average = average;
      this.total = total;
    }

  }

  /*
   **  Find the best average grade.
   */
  public static Integer bestAverageGrade(String[][] scores)
  {
    Map<String, Average> studentMap = new HashMap<>();
    for (String[] strings : scores) {
      String name = strings[0];
      int score = Integer.parseInt(strings[1]);
      if (studentMap.containsKey(name)) {
        Average avg = studentMap.get(name);
        int val = avg.total + score;
        ++avg.count;
        avg.average = val / avg.count;
        studentMap.put(name, avg);
      } else {
        studentMap.put(name, new Average(1, score, score));
      }

    }
    Entry<String, Average> stringAverageEntry = studentMap.entrySet()
        .stream()
        .max(comparingInt(e -> e.getValue().average)).get();
    System.out.println(stringAverageEntry.getKey() + " : "+ stringAverageEntry.getValue().average);
    return stringAverageEntry.getValue().average;
  }

  /*
   **  Returns true if the tests pass. Otherwise, returns false;
   */
  public static boolean doTestsPass()
  {
    // TODO: implement more test cases
    String[][] tc1 = { { "Bobby", "87" },
        { "Charles", "100" },
        { "Eric", "64" },
        { "Charles", "22" } };

    return bestAverageGrade(tc1) == 87;
  }

  /*
   **  Execution entry point.
   */
  public static void main(String[] args)
  {
    // Run the tests
    if(doTestsPass())
    {
      System.out.println("All tests pass");
    }
    else
    {
      System.out.println("Tests fail.");
    }
  }
}
