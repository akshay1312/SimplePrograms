package Java8Example;

    import java.util.PriorityQueue;

/**
 * Created by apitale on 2018-04-15.
 */
public class PriotyQueue {

  public static void main(String[] args) {
    PriorityQueue t = new PriorityQueue();
    t.add("dishes");
    t.add("laundry");
    t.add("bills");
    t.offer("bills");
    System.out.print(t.size() + " " + t.poll());
    System.out.print(" " + t.peek() + " " + t.poll());
    System.out.println(" " + t.poll() + " " + t.poll());
  }
}
