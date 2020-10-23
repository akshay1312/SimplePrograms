package ArrayPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apitale on 2018-04-11.
 */
public class ArrayProblem2 {

  public static void main(String args[]) {
    Integer[] list = { 2, 2, 3, 3, 3, 7, 3, 2, 7, 12 };
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer input : list) {
      if (map.containsKey(input)) {
        map.put(input, map.get(input) + 1);
      } else {
        map.put(input, 1);
      }
    }
    map.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .forEach(e -> System.out.println(e.getKey() + " :: " + e.getValue()));

   /* ArrayList<Map.Entry<Integer, Integer>> result = new ArrayList<>(map.entrySet());
    Collections.sort(result, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
    for (Map.Entry<Integer, Integer> entry : result) {
      System.out.println(entry.getKey() + " <-> " + entry.getValue());
    }*/
  }
}
