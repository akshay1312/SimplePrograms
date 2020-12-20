package Java8Example;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author : apitale
 * @Date : 12/14/20
 */
public class Predicator {


  static boolean testit(Objects s, MyPredicate<Objects> p) {
    return p.test(s);
  }

  public static void main(String[] args) {

    final String s1 = "HI";
    final int i1 = 3;
    final int x = 1;
    MyPredicate<Object>[] p = new MyPredicate[4];
    p[0] = new MyPredicate<>(e -> e.equals(s1));
    p[1] = new MyPredicate<>(e -> {
      if (x == 1) {
        return e.equals(s1);
      }
      return !e.equals(s1);
    });
    p[2] = new MyPredicate<>(e -> {
      if (x != 1) {
        return e.equals(i1);
      }
      return !e.equals(s1);
    });

   /* for (Java8Example.MyPredicate<Objects> pp : p) {
      System.out.println(testit(s1, pp));
    }*/
  }


}

class MyPredicate<T> implements Predicate<T> {

  Predicate<T> local;

  public MyPredicate(Predicate<T> local) {
    this.local = local;
  }

  @Override
  public boolean test(T t) {
    return local.test(t);
  }
}
