package DataStructure.linkedList;

import java.util.Stack;

/**
 * Created by apitale on 2018-04-25.
 */
public class AddTwoLinkedList {

  static Node head1, head2;

  public static void main(String[] args) {
    AddTwoLinkedList list = new AddTwoLinkedList();

    // creating first list
    list.head1 = new Node(7);
    list.head1.next = new Node(5);
    list.head1.next.next = new Node(9);
    list.head1.next.next.next = new Node(4);
    list.head1.next.next.next.next = new Node(6);
    System.out.print("First List is ");
    list.printList(head1);

    // creating seconnd list
    list.head2 = new Node(8);
    list.head2.next = new Node(4);
    System.out.print("Second List is ");
    list.printList(head2);

    // add the two lists and see the result
    Node rs = list.addTwoLists(head1, head2);
    System.out.print("Resultant List is ");
    list.printList(rs);

    // add the two lists and see the result
    rs = list.addTwoNumbers(head1, head2);
    System.out.print("Resultant List 2 is ");
    list.printList(rs);
  }

  public Node addTwoNumbers(Node l1, Node l2) {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    while(l1 != null) {
      s1.push(l1.data);
      l1 = l1.next;
    };
    while(l2 != null) {
      s2.push(l2.data);
      l2 = l2.next;
    }

    int sum = 0;
    Node list = new Node(0);
    while (!s1.empty() || !s2.empty()) {
      if (!s1.empty()) sum += s1.pop();
      if (!s2.empty()) sum += s2.pop();
      list.data = sum % 10;
      Node head = new Node(sum / 10);
      head.next = list;
      list = head;
      sum /= 10;
    }

    return list.data == 0 ? list.next : list;
  }

  /* Adds contents of two linked lists and return the head node of resultant list */
  Node addTwoLists(Node first, Node second) {
    Node res = null; // res is head node of the resultant list
    Node prev = null;
    Node temp = null;
    int carry = 0, sum;

    while (first != null || second != null) //while both lists exist
    {
      // Calculate value of next digit in resultant list.
      // The next digit is sum of following things
      // (i)  Carry
      // (ii) Next digit of first list (if there is a next digit)
      // (ii) Next digit of second list (if there is a next digit)
      sum = carry + (first != null ? first.data : 0)
          + (second != null ? second.data : 0);

      // update carry for next calulation
      carry = (sum >= 10) ? 1 : 0;

      // update sum if it is greater than 10
      sum = sum % 10;

      // Create a new node with sum as data
      temp = new Node(sum);

      // if this is the first node then set it as head of
      // the resultant list
      if (res == null) {
        res = temp;
      } else // If this is not the first node then connect it to the rest.
      {
        prev.next = temp;
      }

      // Set prev for next insertion
      prev = temp;

      // Move first and second pointers to next nodes
      if (first != null) {
        first = first.next;
      }
      if (second != null) {
        second = second.next;
      }
    }

    if (carry > 0) {
      temp.next = new Node(carry);
    }

    // return head of the resultant list
    return res;
  }
    /* Utility function to print a linked list */

  void printList(Node head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println("");
  }

  static class Node {

    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }
}
