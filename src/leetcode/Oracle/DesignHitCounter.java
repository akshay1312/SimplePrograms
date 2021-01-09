package leetcode.Oracle;

import java.util.Deque;
import java.util.LinkedList;
import javafx.util.Pair;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 *
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 *
 * It is possible that several hits arrive roughly at the same time.
 *
 *
 * HitCounter counter = new HitCounter();
 *
 * // hit at timestamp 1.
 * counter.hit(1);
 *
 * // hit at timestamp 2.
 * counter.hit(2);
 *
 * // hit at timestamp 3.
 * counter.hit(3);
 *
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 *
 * // hit at timestamp 300.
 * counter.hit(300);
 *
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 *
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301);
 *
 * @author : apitale
 * @Date : 12/27/20
 */
public class DesignHitCounter {

  public static void main(String[] args) {
    DesignHitCounter counter = new DesignHitCounter();
    counter.hit(1);
    counter.hit(2);
    counter.hit(3);
    System.out.println(counter.getHits(4));
    counter.hit(300);
    System.out.println(counter.getHits(300));
    System.out.println(counter.getHits(301));


  }
    private int total;
    private Deque<Pair<Integer, Integer>> hits;

    /** Initialize your data structure here. */
    public DesignHitCounter() {
      // Initialize total to 0
      this.total = 0;
      this.hits = new LinkedList<Pair<Integer, Integer>>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
      if (this.hits.isEmpty() || this.hits.getLast().getKey() != timestamp) {
        // Insert the new timestamp with count = 1
        this.hits.add(new Pair<>(timestamp, 1));
      } else {
        // Update the count of latest timestamp by incrementing the count by 1

        // Obtain the current count of the latest timestamp
        int prevCount = this.hits.getLast().getValue();
        // Remove the last pair of (timestamp, count) from the deque
        this.hits.removeLast();
        // Insert a new pair of (timestamp, updated count) in the deque
        this.hits.add(new Pair<Integer, Integer>(timestamp, prevCount + 1));
      }
      // Increment total
      this.total++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
      while (!this.hits.isEmpty()) {
        int diff = timestamp - this.hits.getFirst().getKey();
        if (diff >= 300) {
          // Decrement total by the count of the oldest timestamp
          this.total -= this.hits.getFirst().getValue();
          this.hits.removeFirst();
        }
        else break;
      }
      return this.total;
    }
}
