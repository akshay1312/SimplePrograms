package JavaPrograms;

import java.util.Scanner;

/**
 * Created by apitale on 2018-02-02.
 */
public class checkNumberPalindrome {

  public static void main(String[] args) {

    System.out.println("Please Enter a number : ");
    int givennumber = new Scanner(System.in).nextInt();
    int reverse = reverseNumber(givennumber);
    if (givennumber == reverse)
      System.out.println("Result:Palindrome");
    else
      System.out.println("Result:Not Palindrome");
  }

  private static int reverseNumber(int givennumber) {
    int number = givennumber;
    int reverse = 0;
    while (number != 0) {
      int remainder = number % 10;
      reverse = reverse * 10 + remainder;
      number = number / 10;
    }
    return reverse;
  }

}
