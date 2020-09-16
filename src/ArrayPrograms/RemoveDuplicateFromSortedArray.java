package ArrayPrograms;

/**
 * @author akshay Date 2019-05-19 09:36
 */
public class RemoveDuplicateFromSortedArray {

  public static void main(String a[]) {

    int[] inputArr1 = {1,2,2,3,4,5,5,6};
    System.out.println(" Before Size :: " + inputArr1.length);
    System.out.println("After Size :: " + removeDuplicates(inputArr1));

  }

  private static int removeDuplicates(int[] nums) {
    int i = 0;
    for(int n : nums)
      if(i < 1 || n > nums[i - 1])
        nums[i++] = n;
    return i;
  }

}
