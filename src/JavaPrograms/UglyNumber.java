package JavaPrograms;

import java.util.Scanner;

/**
 * @author akshay Date 2019-04-10 15:32
 */
public class UglyNumber {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number to find prime factor :: ");

    int number = sc.nextInt();
    System.out.println("Result :: "+ nthUglyNumber(number));
  }

  public static int nthUglyNumber(int n) {

    int i, count = 1;
      System.out.println("Count :: " + count + " i:: " + 1);
    if (n == count) {
      return count;
    }
    for (i = 2; i <= 1690; i++) {
      boolean isUgly = checkUgly(i);
      if (isUgly) {
        count = count + 1;
        System.out.println("Count :: " + count + " i :: " + i);
        if (count == n) {
          break;
        }
      }
    }
    return i;
  }

  private static boolean checkUgly(int num) {
    if (num <= 5) {
      return true;
    }
    boolean flag = false;
    while (num % 2 == 0) {
      num /= 2;
      flag = true;
    }
    while (num % 3 == 0) {
      num /= 3;
      flag = true;
    }
    while (num % 5 == 0) {
      num /= 5;
      flag = true;
    }
    return flag;
  }

}
