package SapientQuestions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @author akshay Date 2019-05-20 09:59
 */
public class LRU {

  private HashMap<Integer, Integer> hashMap;
  private int capacity;

  LRU(int capacity) {
    this.hashMap = new LinkedHashMap<>();
    this.capacity = capacity;
  }

  public int get(int key) {
    if(!hashMap.containsKey(key)) {
      return -1;
    }
    Integer value = hashMap.get(key);

    // get is one of the operation so
    hashMap.remove(key);
    hashMap.put(key, value);
    return value;
  }

  public void put(int key, int value) {
    if (hashMap.containsKey(key)) {
      hashMap.remove(key);
    }

    if (hashMap.size() == capacity) {
      // eviction
      Iterator<Integer> iterator1 = hashMap.keySet().iterator();
      if (iterator1.hasNext()) {
        Integer key_to_rm = iterator1.next();
        hashMap.remove(key_to_rm);
      }
    }
    hashMap.put(key, value);
  }

  public static void main(String args[]) {
    LRU cache = new LRU(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println("get key 1 :: " + cache.get(1));       // returns 1
    cache.put(3, 3);    // evicts key 2
    System.out.println("get key 2 :: " + cache.get(2));  // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    System.out.println("get key 1 :: " + cache.get(1)); // returns -1 (not found)
    System.out.println("get key 1 :: " + cache.get(3));    // returns 3
    System.out.println("get key 1 :: " + cache.get(4));    // returns 4
  }
}
