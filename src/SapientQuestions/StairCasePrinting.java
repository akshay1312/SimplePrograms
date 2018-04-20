package SapientQuestions;

import java.util.Scanner;

/**
 * Created by apitale on 2018-04-17.
 */
public class StairCasePrinting {

  public static void main(String[] args) {
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    for(int i=1;i<=n;i++)
    {
      for(int j=1;j<=n;j++)

      {
        if((i+j)>n)
        {
          System.out.print("#");
        }
        else
        {
          System.out.print(" ");
        }

      }
      System.out.println();

    }
  }
}
