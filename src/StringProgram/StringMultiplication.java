package StringProgram;

/**
 * @author akshay Date 2019-06-01 18:34
 */
public class StringMultiplication {


  public static void main(String a[]) {

    String num1 = "123";
    String num2 = "456";
    System.out.println(" Result :: " + multiply(num1, num2));
    System.out.println(" Result :: " + multiply1(num1, num2));

  }

  private static String multiply(String num1, String num2) {
    char[] mul1 = num1.toCharArray();
    char[] mul2 = num2.toCharArray();

    if (mul1.length < mul2.length) {
      char[] temp = mul1;
      mul1 = mul2;
      mul2 = temp;
    }

    int carry = 0;
    StringBuilder sb = new StringBuilder();
    String result;
    for (int i = mul1.length - 1; i >= 0; i--) {
      for (int j = mul2.length - 1; j >= 0; j--) {
        int temp = ((mul1[i] - '0') * (mul2[j] - '0'));
        System.out.println("Temp = " + temp);
        temp = temp + carry;
        sb.append(temp%10);
        System.out.println("String Builder :: "+ sb.toString());
        carry = temp / 10;
        System.out.println("Carry :: "+ carry);
      }
    }

    return sb.toString();
  }


  private static String multiply1(String num1, String num2) {
    int m = num1.length(),
        n = num2.length();
    int[] pos = new int[m + n];

    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int p1 = i + j, p2 = i + j + 1;
        int sum = mul + pos[p2];

        pos[p1] += sum / 10;
        pos[p2] = (sum) % 10;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int p : pos) {
      if (!(sb.length() == 0 && p == 0)) {
        sb.append(p);
      }
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
