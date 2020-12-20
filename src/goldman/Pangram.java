package goldman;

import java.util.Arrays;

public class Pangram {

  public static void main(String[] args) {
    String missingChars = findMissingCharacters("Welcome to greeksforgreeks");
    System.out.println("output = " + missingChars);
  }

  private static String findMissingCharacters(String input) {
    boolean[] visited = new boolean[26];
    for (int i = 0; i < input.length(); i++) {
      if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
        visited[input.charAt(i) - 'a'] = true;
      }else if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
        visited[input.charAt(i) - 'A'] = true;
      }
    }

    StringBuilder output = new StringBuilder();
    for(int i =0; i < 26; i++) {
      if(!visited[i]) {
        output.append((char) (i + 'a'));
      }
    }
    return output.toString();
  }
}
