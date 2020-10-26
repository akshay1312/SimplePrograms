package goldman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a list of scores of different students, return the average score of each student's top five
 * scores in the order of each student's id.
 * <p>
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The
 * average score is calculated using integer division.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]] Output:
 * [[1,87],[2,88]] Explanation: The average of the student with id = 1 is 87. The average of the
 * student with id = 2 is 88.6. But with integer division their average converts to 88.
 * <p>
 * Created by apitale on 2020-09-15.
 */
public class HighFive {

  public static void main(String[] args) {
    int[][] input = new int[11][11];
    input[0][0] = 1;
    input[0][1] = 91;
    input[1][0] = 1;
    input[1][1] = 92;
    input[2][0] = 2;
    input[2][1] = 93;
    input[3][0] = 1;
    input[3][1] = 60;
    input[4][0] = 2;
    input[4][1] = 77;
    input[5][0] = 1;
    input[5][1] = 65;
    input[6][0] = 1;
    input[6][1] = 87;
    input[7][0] = 1;
    input[7][1] = 100;
    input[8][0] = 2;
    input[8][1] = 100;
    input[9][0] = 2;
    input[9][1] = 76;
    input[10][0] = 2;
    input[10][1] = 97;
    int[][] output = highFive1(input);
    System.out.print(Arrays.deepToString(output));
  }

  public static int[][] highFive(int[][] items) {
    Map<Integer, PriorityQueue<Integer>> map;
    map = new HashMap<>();
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int[] item : items) {
      map.putIfAbsent(item[0], new PriorityQueue<Integer>());
      addHeap(map.get(item[0]), item[1]);
      min = Math.min(item[0], min);
      max = Math.max(item[0], max);
    }
    int result[][] = new int[map.size()][];
    int index = 0;
    for (int i = min; i <= max; i++) {
      if (map.containsKey(i)) {
        result[index] = new int[]{i, average(map.get(i))};
        index++;
      }
    }
    return result;
  }

  static void addHeap(PriorityQueue<Integer> queue, int i) {
    if (queue.size() < 5) {
      queue.add(i);
    } else if (i > queue.peek()) {
      queue.remove();
      queue.add(i);
    }
  }

  static int average(PriorityQueue<Integer> queue) {
    int size = queue.size();
    int avg = 0;
    for (int score : queue) {
      avg += score;
    }
    return avg / size;
  }


  public static int[][] highFive1(int[][] items) {
    HashMap<Integer, PriorityQueue<Integer>> map = new HashMap();

    for(int[] item : items) {
      map.putIfAbsent(item[0], new PriorityQueue());
      addToQueue(map.get(item[0]), item[1]);
    }

    int[][] result = new int[map.size()][2];
    int index = 0;
    for(Map.Entry<Integer,PriorityQueue<Integer>> entry : map.entrySet())   {
      result[index][0]= entry.getKey();
      result[index][1]= averageOut(entry.getValue());
      index++;
    }
    return result;
  }

  private static void addToQueue(PriorityQueue<Integer> queue, int grade) {
    if(queue.size()<5) {
      queue.add(grade);
    }else {
      queue.poll();
      queue.offer(grade);
    }
  }

  private static int averageOut(PriorityQueue<Integer> queue) {
    int size = queue.size();
    int avg = 0;
    for(int s: queue) {
      avg += s;
    }
    return avg/size;
  }

}
