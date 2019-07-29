package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Input : 2D grid character array and list of string is input. Output : how many string exist in
 * the dictionary
 *
 * Rule : one time you can travel either up, down or left,right at one time .
 *
 * @author akshay Date 2019-07-17 16:18
 */
public class CharacterDictionary {


  public static void main(String a[]) {

    char[][] dictionary = {
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}
    };

    String[] words = {"eat", "oath"};
    System.out.println("Output :: " + findWords(dictionary, words).size());

  }

  private static List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();

    int m = board.length;
    int n = board[0].length;

    for (String word : words) {
      boolean flag = false;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (dfs(board, word, i, j, 0)) {
            flag = true;
          }
        }
      }
      if (flag) {
        result.add(word);
      }
    }

    return result;
  }

  private static boolean dfs(char[][] board, String word, int i, int j, int k) {
    int m = board.length;
    int n = board[0].length;

    if (i < 0 || j < 0 || i >= m || j >= n || k > word.length() - 1) {
      return false;
    }

    if (board[i][j] == word.charAt(k)) {
      char temp = board[i][j];
      board[i][j] = '#';

      if (k == word.length() - 1) {
        return true;
      } else if (dfs(board, word, i - 1, j, k + 1)
          || dfs(board, word, i + 1, j, k + 1)
          || dfs(board, word, i, j - 1, k + 1)
          || dfs(board, word, i, j + 1, k + 1)) {
        board[i][j] = temp;
        return true;
      }

    } else {
      return false;
    }

    return false;
  }


}
