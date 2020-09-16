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
  }

  private static String decode(String text) {

    StringBuffer reverse = new StringBuffer(text).reverse();
    StringBuffer b = new StringBuffer();
    for (int i = 0; i < reverse.length(); i++) {
      b.append((char) ((reverse.charAt(i) - i) / 2));
    }
    return b.toString();
  }
}
