package Java8Example;

/**
 * input 15:
 *
 * 1+2+3+4+5, 4+5+6, 7+8
 *
 * output = 3
 *
 * @author akshay Date 2019-04-07 11:47
 */
public class ConsecutiveNum {


  public static void main(String args[]) {
    int num = 15;

    long temp, i, j, count = 0;
    long limit = (num / 2);
    for (i = 1; i <= limit; i++) {
      temp = num;
      j = i;
      System.out.print("round j = " + j);
      while (j < temp) {
        temp = temp - j;
        j++;
        System.out.print(" + "+ j);
      }
      System.out.println();
      if (j == temp) {
        count++;
        System.out.println("incremented counter");
      }
    }
    System.out.print("count" + count);

  }

}
