package JavaPrograms;

import java.util.Scanner;

/**
 * Created by Akshay Pitale on 2018-04-13.
 */
public class PrimeFactor {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number to find prime factor :: ");

    int number = sc.nextInt();

    // print number of 2s that divide number
    while (number % 2 == 0) {
      System.out.println(2 + " ");
      number /= 2;
    }

    //  at this point n must be odd
    double sqrt = Math.sqrt(number);
    for(int i = 3; i<= sqrt; i+=2) {
      while (number % i == 0) {
        System.out.println(i + " ");
        number = number/i;
      }
    }

    if (number > 2)
      System.out.print(number);
  }
}
