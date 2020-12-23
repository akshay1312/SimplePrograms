package Java8Example;

import StringProgram.Namer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by apitale on 2018-04-14.
 */
public class Java8Example {

  public static void main(String[] args) {
    List<Product> productsList = new ArrayList<Product>();
    //Adding Products
    productsList.add(new Product(1, "HP Laptop", 25000f));
    productsList.add(new Product(2, "Dell Laptop", 30000f));
    productsList.add(new Product(3, "Lenevo Laptop", 28000f));
    productsList.add(new Product(4, "Sony Laptop", 28000f));
    productsList.add(new Product(5, "Apple Laptop", 90000f));
    List<Float> productPriceList2 = productsList.stream()
        .filter(p -> p.price > 30000)// filtering data
        .map(p -> p.price)        // fetching price
        .sorted()
        .collect(Collectors.toList()); // collecting as list
    System.out.println(productPriceList2);

    Consumer<Namer> printit = e -> System.out.println(e.getFn() + " " + e.getLn());
    List<Namer> names = new ArrayList<>(Arrays.asList(
        new Namer("Harry", "Smith"), new Namer("Joe", "Smith"),
        new Namer("Marry", "Jane"), new Namer("Jane", "Doe"),
        new Namer("Harry", "Homewoner"))
    );

    Comparator<Namer> groupBy = Comparator.comparing(Namer::getFn);
    groupBy = groupBy.thenComparing(Namer::getLn);
    names.removeIf(e -> e.getFn().equals("Marry"));
    names.sort(groupBy);
    names.forEach(printit);

   /* Collections.sort(names, (Namer e1, Namer e2) -> e1.getFn().compareTo(e2.getFn()));
    names.removeIf(e -> e.getFn().equals("Marry"));
    names.forEach(printit);*/

    List<Integer> inputList = new ArrayList<>();
    inputList.add(1);
    inputList.add(2);
    inputList.add(2);
    inputList.add(3);
    inputList.add(4);
    inputList.add(5);
    inputList.add(5);

    // remove duplicate
    List<Integer> collect = inputList.stream().distinct().collect(Collectors.toList());

    System.out.println("result 1 : " + collect);

    for (int i = 0; i < collect.size(); i++) {
      collect.remove(i);
    }
    System.out.println("result 2: " + collect);

  }
}

class Product {

  int id;
  String name;
  float price;

  public Product(int id, String name, float price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }
}
