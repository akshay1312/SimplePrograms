package leetcode;

import java.util.Arrays;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that
 * they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based. You may assume that each input
 * would have exactly one solution and you may not use the same element twice. Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9 Output: [1,2] Explanation: The sum of 2 and 7 is 9.
 * Therefore index1 = 1, index2 = 2.
 *
 * @author akshay Date 2020-07-30 22:59
 */
public class TwoSum_SortedArray {

  public static void main(String[] args) {
    int[] arr = {2,7,11,15};
    System.out.println("Result :: " + Arrays.toString(twoSum(arr, 9)));
  }

  public static int[] twoSum(int[] nums, int target) {
    int i = 0;
    int j = nums.length - 1;
    if (nums[i] > target) {
      throw new IllegalStateException("No Two Sum Solution");
    }
    while (i < j) {
      int complement = target - nums[j];
      if (complement == nums[i]) {
        return new int[]{i + 1, j + 1};
      } else if (complement > nums[i]) {
        i++;
      } else {
        j--;
      }

    }
    throw new IllegalStateException("No Two Sum Solution");
  }

}
