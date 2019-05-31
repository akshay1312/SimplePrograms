package ArrayPrograms;

import java.util.Arrays;

/**
 * Sum of array index of right,left,up,down and replace array index with result
 *
 * Input Array ::  [1, 2, 3]
 *                 [4, 5, 6]
 *                 [7, 8, 9]
 *
 * Output Array :: [6, 9, 8]
 *                 [13, 20, 17]
 *                 [12, 21, 14]
 *
 * @author akshay Date 2019-03-23 20:42
 */
public class TwoDArraySideIndexSum {

  public static void main(String args[]) {
    int row = 3;
    int col = 3;
    int[][] input = new int[row][col];
    int[][] output = new int[row][col];
    int count = 1;

    //preparing input array
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        input[i][j] = count++;
      }
    }

    // solution 1 ::
    System.out.println("*** Solution 1 ***** ");
    System.out.println("Input Array :: " + Arrays.deepToString(input));
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int result = getResult(row, col, input, i, j);
        output[i][j] = result;
      }
    }
    System.out.println("Output Array :: " + Arrays.deepToString(output));

    // solution 2 ::
    System.out.println("*** Solution 2 ***** ");
    System.out.println("Input Array :: " + Arrays.deepToString(input));
    for (int i = 0; i < input.length * input[0].length; i++) {
      int k = i % input.length;
      int j = i / input.length;
      int result = getResult(row, col, input, k, j);
      output[k][j] = result;
    }
    System.out.println("Output Array :: " + Arrays.deepToString(output));
  }

  private static int getResult(int row, int col, int[][] input, int i, int j) {
    int result = 0;
    if (i - 1 >= 0) {
      result = result + input[i - 1][j];
    }

    if (i + 1 < col) {
      result = result + input[i + 1][j];
    }

    if (j - 1 >= 0) {
      result = result + input[i][j - 1];
    }

    if (j + 1 < row) {
      result = result + input[i][j + 1];
    }
    return result;
  }


}
