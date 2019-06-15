package StringProgram;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akshay Date 2019-05-31 21:00
 */
public class UniqueEmailAddress {


  public static void main(String args[]) {
    String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
    System.out.println("result :: " + numUniqueEmails(emails));
  }



  public static int numUniqueEmails(String[] emails) {
    if (emails == null) {
      return 0;
    }

    Set<String> addresses = new HashSet<>();

    for (String email : emails) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < email.length(); i++) {
        char ch = email.charAt(i);
        switch (ch) {
          case '.':
            break;
          case '+':
            while (ch != '@') {
              ch = email.charAt(++i);
            }
            sb.append(email.substring(i));
            i = email.length();
            break;
          case '@':
            sb.append(email.substring(i));
            i = email.length();
          default:
            sb.append(ch);
        }
      }
      addresses.add(sb.toString());
    }

    return addresses.size();
  }

}
