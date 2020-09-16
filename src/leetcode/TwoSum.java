package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 * @author akshay Date 2020-07-30 22:59
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] arr = {11, 7, 2, 15};
    System.out.println("Result :: " + Arrays.toString(twoSum(arr, 9)));
  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int first, second;
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        first = map.get(nums[i]);
        second = i;
        return new int[]{first, second};
      } else {
        int temp = target - nums[i];
        map.put(temp, i);
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

}
