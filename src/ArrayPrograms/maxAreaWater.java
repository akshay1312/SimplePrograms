package ArrayPrograms;

/**
 * @author akshay Date 2019-06-01 09:05
 */
public class maxAreaWater {

  public static void main(String a[]) {

    int[] inputArr1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(" MAX AREA :: " + maxArea(inputArr1));

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
}
