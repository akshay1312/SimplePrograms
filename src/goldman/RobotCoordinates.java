package goldman;


/**
 * There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
 *
 * The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.
 *
 * Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once, "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
 *
 *
 *
 * Example 1:
 *
 * Input: moves = "UD"
 * Output: true
 * Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
 * Example 2:
 *
 * Input: moves = "LL"
 * Output: false
 * Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
 */

public class RobotCoordinates {


  public static void main(String[] args) {
    System.out.println(judgeCircle("UD"));
    System.out.println(judgeCircle1("LL"));
  }

  public static boolean judgeCircle(String moves) {
    char[] move = moves.toCharArray();
    int[] position = { 0, 0 };
    for(char ch : move) {
      switch (ch) {
        case 'U':
          position[0]++;
          break;
        case 'D':
          position[0]--;
          break;
        case 'L':
          position[1]++;
          break;
        case 'R':
          position[1]--;
          break;
      }
    }
    return position[0] == 0 && position[1] == 0;
  }

  public static boolean judgeCircle1(String moves) {
    char[] move = moves.toCharArray();
    int[] position = { 0, 0, 0 ,0 };
    for(char ch : move) {
      switch (ch) {
        case 'U':
          position[0]++;
          break;
        case 'D':
          position[1]++;
          break;
        case 'L':
          position[2]++;
          break;
        case 'R':
          position[3]++;
          break;
      }
    }

    int ud = position[0] - position[1];
    int lr = position[2] - position[3];
    return ud ==0 && lr == 0;
  }
}
