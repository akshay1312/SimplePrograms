package ArrayPrograms;

/**
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Basically, for each pair of heights, we have to maximize the product of width between them and a minimum of both the heights. It will be the maximum possible area. In the above case,
 * we choose the pair 8 (at 1st index) and 7 (at 8th index). The width between them is the difference of their index, i.e. 7 and minimum of heights 8 and 7 is 7. So the area is 7*7 = 49.
 *
 * @author akshay Date 2019-06-01 09:05
 */
public class maxAreaWater {

  public static void main(String a[]) {

    int[] inputArr1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(" MAX AREA :: " + maxArea2(inputArr1));

  }

  public static int maxArea(int[] height) {
    int max = 0;
    int lo = 0;
    int hi = height.length - 1;

    while (lo < hi) {

     /* int loMax = height[lo], hiMax = height[hi];

      int candidate = (hi-lo) * (loMax<hiMax ? loMax : hiMax);
      max = candidate > max ? candidate : max;

      if(height[lo]<=height[hi])
        while(lo<hi && height[lo]<=loMax) ++lo;
      else
        while(hi>lo && height[hi]<=hiMax) --hi;*/

      int area = 0;
      if (height[lo] < height[hi]) {
        area = height[lo] * (hi - lo);
        lo++;
      } else {
        area = height[hi] * (hi - lo);
        hi--;
      }
      System.out.println("area :: = " + area);
      max = Math.max(area, max);
    }
    return max;
  }

  public static int maxArea2(int[] height) {
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
