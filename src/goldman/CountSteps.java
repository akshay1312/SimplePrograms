package goldman;


/**
 *  A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps
 *  at a time. Implement a method to count how many possible ways the child can run up the stairs.
 *
 *  Input : 4
 * Output : 7
 * Explantion:
 *  Below are the four ways
 *  1 step + 1 step + 1 step + 1 step
 *  1 step + 2 step + 1 step
 *  2 step + 1 step + 1 step
 *  1 step + 1 step + 2 step
 *  2 step + 2 step
 *  3 step + 1 step
 *  1 step + 3 step
 */

public class CountSteps {

  // Returns count of ways to reach
  // n-th stair using 1 or 2 or 3 steps.
  public static int findStep(int n)
  {
    if (n == 1 || n == 0)
      return 1;
    else if (n == 2)
      return 2;

    else
      return findStep(n - 3) + findStep(n - 2) + findStep(n - 1);
  }

  // Driver function
  public static void main(String argc[])
  {
    int n = 4;
    System.out.println(findStep(n));
  }
}
