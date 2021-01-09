package leetcode.Oracle;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 * <p>
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the
 * divide and conquer approach, which is more subtle.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 * <p>
 * Input: nums = [1] Output: 1
 *
 * @author : apitale
 * @Date : 1/5/21
 */
public class MaxSubArray {

  public static void main(String[] args) {
    int[] inputArr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(" MAX SUM :: " + maxSubArray1(inputArr1));
    System.out.println(" MAX SUM :: " + maxSubArray2(inputArr1));
  }

  // greedy problem o(n) and space o (1)
  private static int maxSubArray1(int[] nums) {
    if(nums.length == 1) {
      return nums[0];
    }

    int maxSum = nums[0], currSum = nums[0];

    for(int i = 1; i < nums.length; i++) {
      currSum = Math.max(nums[i], currSum + nums[i]);;
      maxSum = Math.max(maxSum, currSum);
    }


    return maxSum;
  }


  // dynamic problem o(n) and space o (1)
  public static int maxSubArray2(int[] nums) {
    int n = nums.length, maxSum = nums[0];
    for(int i = 1; i < n; ++i) {
      if (nums[i - 1] > 0) nums[i] += nums[i - 1];
      System.out.println("nums[" + i + "] :: " + nums[i]);
      maxSum = Math.max(nums[i], maxSum);
    }
    return maxSum;
  }
}
