package leetcode.Oracle;

import com.sun.tools.javac.util.Pair;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * Design a logger system that receives a stream of messages along with their timestamps. Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).
 *
 * All messages will come in chronological order. Several messages may arrive at the same timestamp.
 *
 * Implement the Logger class:
 *
 * Logger() Initializes the logger object.
 * bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp, otherwise returns false.
 *
 *
 * Example 1:
 *
 * Input
 * ["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
 * [[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
 * Output
 * [null, true, true, false, false, false, true]
 *
 * Explanation
 * Logger logger = new Logger();
 * logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
 * logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
 * logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
 * logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
 * logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
 * logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is
 *                                       // 11 + 10 = 21
 * @author : apitale
 * @Date : 1/3/21
 */
public class LoggerRateLimiter {

  private LinkedList<Pair<Integer, String>> queue;
  private HashSet<String> messages;

  public LoggerRateLimiter() {
    this.queue = new LinkedList<>();
    this.messages = new HashSet<>();
  }

  public static void main(String[] args) {
    LoggerRateLimiter loggerRateLimiter = new LoggerRateLimiter();
    boolean result = loggerRateLimiter.shouldPrintMessage(1, "foo");
    System.out.println("Result :: " + result);
  }

  private boolean shouldPrintMessage(int timestamp, String message) {

    // clean up
    while (queue.size() > 0) {
      Pair<Integer, String> first = queue.getFirst();
      if (timestamp - first.fst >= 10) {
        queue.removeFirst();
        messages.remove(first.snd);
      } else {
        break;
      }
    }

    // insert
    if (!messages.contains(message)) {
      queue.addLast(new Pair<>(timestamp, message));
      messages.add(message);
      return true;
    } else {
      return false;
    }
  }
}
