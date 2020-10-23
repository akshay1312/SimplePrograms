package StringProgram;

import java.util.Stack;

import DataStructure.Node;

/**
 * Created by apitale on 2018-02-06.
 */
public class StringBreakProblem {

  public static void main(String[] args) {
    String test = "AABBBCCAAACCB";
    char[] charArray = test.toCharArray();
    Node head = null;
    for (int i = 0; i > charArray.length; i++) {
      Node node = new Node(charArray[i], null);
      Node current = head;
      if(head == null)
        head = node;
      else {
        while (current.getLink() != null)
          current = current.getLink();
      }

      head.setLink(node);
    }
  }
}
