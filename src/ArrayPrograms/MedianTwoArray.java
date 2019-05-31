package ArrayPrograms;

import java.util.Arrays;

/**
 * nums1 = [1, 3] nums2 = [2]
 *
 * The median is 2.0
 *
 * nums1 = [1, 2] nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * @author akshay Date 2019-05-10 14:58
 */
public class MedianTwoArray {

  public static void main(String a[]) {

    int[] inputArr1 = {1,8,6,2,5,4,8,3,7};
    int[] inputArr2 = {3, 5};
    System.out.println(" Median :: " + findMedianSortedArrays(inputArr1, inputArr2));

  }


  private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int num1Len = nums1.length;
    int num2Len = nums2.length;
    int len = num1Len + num2Len;
    int[] mergeArrray = new int[len];

    int i = 0, j = 0, t = 0;
    while (i < num1Len && j < num2Len) {
      if (nums1[i] < nums2[j]) {
        mergeArrray[t] = nums1[i];
        i++;
      } else {
        mergeArrray[t] = nums2[j];
        j++;
      }
      t++;
    }

    while (i < num1Len) {
      mergeArrray[t] = nums1[i];
      i++;
      t++;
    }

    while (j < num2Len) {
      mergeArrray[t] = nums2[j];
      j++;
      t++;
    }
    System.out.println("merged Array :: " + Arrays.toString(mergeArrray));

    if (len % 2 == 0) {
      return (mergeArrray[(len / 2)] + mergeArrray[(len / 2) - 1]) / 2.0;
    } else {
      return mergeArrray[len / 2];
    }
  }

  public static int maxArea(int[] height) {
    int max = 0;
    int secondMax = 0;
    int result = 0;
    for(int i = 0; i< height.length; i++) {
      if(height[i] > max) {
        secondMax = max;
        max = height[i];
      }
      if(height[i] < max && height[i] > secondMax) {
        secondMax = height[i];
      }
    }

    if(max >= secondMax) {
      result = secondMax * secondMax;
    }

    return result;
  }
}
