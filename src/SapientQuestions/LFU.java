package SapientQuestions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

/**
 * @author akshay Date 2019-05-19 14:38
 */
public class LFU {

  private int capacity;
  private HashMap<Integer, Pair> hashMap;
  PriorityQueue<Integer> queue;
  int globalAge = 0;

  public LFU(int capacity) {
    this.capacity = capacity;
    this.hashMap = new LinkedHashMap<>();
    Comparator<? super Integer> comparator = (Comparator<Integer>) (o1, o2) -> {
      if (hashMap.get(o1).age < hashMap.get(o2).age) {
        return -1;
      } else {
        return 1;
      }
    };
    this.queue = new PriorityQueue<>(16, comparator);
  }

  public static void main(String args[]) {
    LFU cache = new LFU(0);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println("get key 1 :: " + cache.get(1));       // returns 1
    cache.put(3, 3);    // evicts key 2
    System.out.println("get key 2 :: " + cache.get(2));  // returns -1 (not found)
    System.out.println("get key 3 :: " + cache.get(3));  // returns 3
    cache.put(4, 4);    // evicts key 1
    System.out.println("get key 1 :: " + cache.get(1)); // returns -1 (not found)
    System.out.println("get key 1 :: " + cache.get(3));    // returns 3
    System.out.println("get key 1 :: " + cache.get(4));    // returns 4
  }

  public int get(int key) {
    Pair entry = hashMap.get(key);
    if (null != entry) {
      hashMap.put(key, new Pair(entry.value, ++globalAge));
      queue.remove(key);
      queue.add(key);
      return entry.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    hashMap.put(key, new Pair(value, ++globalAge));
    if (hashMap.size() == capacity) {
      Integer expired = queue.poll();
      System.out.println("removing item from queue :: " + expired);
      hashMap.remove(expired);
    }
    queue.remove(key);
    queue.add(key);
  }

  private class Pair {

    int value;
    int age;

    public Pair(int value, int age) {
      this.value = value;
      this.age = age;
    }

    @Override
    public String toString() {
      return "" + value + ":" + age;
    }
  }
}
