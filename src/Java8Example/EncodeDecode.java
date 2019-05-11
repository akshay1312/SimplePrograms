package Java8Example;

/**
 * @author akshay Date 2019-05-06 23:22
 */
public class EncodeDecode {


  private static String encode(String text) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      b.append((char) ((2 * c) + i));
    }
    return b.reverse().toString();
  }

  public static void main(String args[]) {
    System.out.println("answer ::" + encode("abc"));
    System.out.println("----");
    System.out.println("answer :: " + decode("ÈÅÂ"));
    int data[] = new int[]{10, 7, 5, 8, 11, 9};
    String s = computeBestTransactions(data);
    System.out.println(s);
  }

  private static String decode(String text) {

    StringBuffer reverse = new StringBuffer(text).reverse();
    StringBuffer b = new StringBuffer();
    for (int i = 0; i < reverse.length(); i++) {
      b.append((char) ((reverse.charAt(i) - i) / 2));
    }
    return b.toString();
  }

  public static String computeBestTransactions(int[] data) {

    if (data.length < 2) {
      return "";
    }

    int buyDay = 0;
    int sellDay = 1;
    int minPrice = data[buyDay];
    int maxProfit = data[sellDay] - data[buyDay];
    int sellPrice = data[sellDay];
    for (int i = 1; i < data.length; i++) {
      int currentPrice = data[i];

      // see what our profit would be if we bought at the
      // min price and sold at the current price
      int potentialProfit = currentPrice - minPrice;

      // update maxProfit if we can do better
      int currMaxProfit = Math.max(maxProfit, potentialProfit);
      if(currMaxProfit != maxProfit) {
        maxProfit = currMaxProfit;
        sellPrice = currentPrice;
        sellDay = i;
      }
      // update minPrice so it's always
      // the lowest price we've seen so far
      int currMinPrice = Math.min(minPrice, currentPrice);
      if(currMinPrice != minPrice) {
        minPrice = currMinPrice;
        buyDay = i;
      }
    }
      System.out.println("max profit :: " + maxProfit);
      System.out.println("buy price :: " + minPrice);
      System.out.println("buy Day :: " + buyDay++);
      System.out.println("sell price :: " + sellPrice);
      System.out.println("sell Day :: " + sellDay++);
    return formatOutputString(minPrice, buyDay, sellPrice, sellDay, maxProfit);
  }


  private static String formatOutputString(int buyPrice, int buyDay, int sellPrice,
      int sellDay, int maxProfit) {
    return "BUY@" + buyPrice + " on day " + buyDay + " and SELL@" + sellPrice + " on Day " + sellDay
        + " for max profit of :: " + maxProfit;
  }

}
