package JavaPrograms;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by apitale on 2018-03-16.
 */
public class IntegerComparator {

  public static void main(String args[]) {
    Pair<Integer, String> map1 = new Pair<>(5, "ak");
    Pair<Integer, String> map2 = new Pair<>(4, "sh");
    Pair<Integer, String> map3 = new Pair<>(3, "ay");
    Pair<Integer, String> map4 = new Pair<>(5, "pi");
    Pair<Integer, String> map5 = new Pair<>(5, "ta");
    List<Pair<Integer, String>> pairList = new ArrayList<>();
    pairList.add(map1);
    pairList.add(map2);
    pairList.add(map3);
    pairList.add(map4);
    pairList.add(map5);

    /*List<Integer> list = Arrays.asList(5,3,8);
    Optional<Integer> op = list.stream().max((a, b) -> {
      System.out.println("Input arguments a=" + a + ", b=" + b);

      int max = Integer.compare(a, b);
      System.out.println("Returning max(a,b)=" + max);
      return max;
    });
    System.out.println("Optional result=" + op.get());
*/
    Stream<Pair<Integer, String>> stream = pairList.stream();
    Optional<Pair<Integer, String>> maxResult = stream.max((p1, p2) -> Integer.compare(p1.getA(), p2.getA()));
    System.out.println("Max result=" + maxResult.get().getA() + ":" + maxResult.get().getB());
  }

  static class Pair<A,B> {
    private final A a;
    private final B b;

    public Pair(A a, B b) {
      this.a = a;
      this.b = b;
    }



    public A getA() {
      return a;
    }

    public B getB() {
      return b;
    }

    @Override
    public int hashCode() {
      return Objects.hash(a, b);
    }

    @Override
    public boolean equals(Object o) {
      if(o == null || !(o instanceof Pair)) {
        return false;
      }
      Pair<?,?> that = (Pair<?,?>)o;
      return Objects.equals(this.a, that.a) &&
          Objects.equals(this.b, that.b);
    }


  }
}
