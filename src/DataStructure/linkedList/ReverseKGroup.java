package DataStructure.linkedList;

/**
 * Created by apitale on 2018-04-14.
 */
public class ReverseKGroup {
  static Node head;

  public static void main(String[] args) {
    ReverseKGroup list = new ReverseKGroup();
    list.head = new Node(1);
    list.head.next = new Node(2);
    list.head.next.next = new Node(3);
    list.head.next.next.next = new Node(4);
    list.head.next.next.next.next = new Node(5);

    System.out.println("Given Linked list");
    list.printList(head);
    head = list.reverseKGroup(head, 2);
    System.out.println("");
    System.out.println("Reversed k group linked list ");
    list.printList(head);
  }

  /* Function to reverse the linked list */
  Node reverse(Node node) {
    Node prev = null;
    Node current = node;
    Node next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }

  // prints content of double linked list
  void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  private Node reverseKGroup(Node head, int k) {
    Node p, q, newStart, temp;
    int counter = 0;
    p = head;
    while (counter != k - 1) {
      if (p.next == null) {
        return head;
      }
      p = p.next;
      counter++;
    }
    newStart = p;
    q = newStart;

    while (true) {
      p = head;
      temp = q.next;
      if (temp == null) {
        return reverse(p);
      }
      q.next = null;
      q = temp;
      head = temp;
      counter = 0;

      while (counter != k - 1) {
        if (temp.next == null) {
          reverse(p);
          p.next = q;
          return newStart;
        }
        temp = temp.next;
        counter++;
      }

      reverse(p);
      p.next = temp;
      q = temp;
    }

   // return newStart;
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
