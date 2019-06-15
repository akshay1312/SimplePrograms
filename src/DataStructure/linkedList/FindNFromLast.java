package DataStructure.linkedList;

/**
 * @author akshay Date 2019-05-02 17:16
 */
public class FindNFromLast {

  static Node head;

  static class Node {

    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }


  // prints content of double linked list
  void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  public static void main(String[] args) {
    FindNFromLast list = new FindNFromLast();
    list.head = new FindNFromLast.Node(85);
    list.head.next = new FindNFromLast.Node(15);
    list.head.next.next = new FindNFromLast.Node(4);
    list.head.next.next.next = new FindNFromLast.Node(44);
    list.head.next.next.next.next = new FindNFromLast.Node(20);
    list.head.next.next.next.next.next = new FindNFromLast.Node(12);

    System.out.println("Given Linked list");
    list.printList(head);
    list.printNthFromLast(head, 3);
  }

  private void printNthFromLast(Node head, int n) {

    Node p1 = head, p2 = head;
    Node prev = null;
    int count = 0;
    while (count < n) {
      p2 = p2.next;
      count++;
    }

    if(p2 == null) {
      return;
    }

    while (p2 != null) {
      p2 = p2.next;
      prev = p1;
      p1 = p1.next;
    }

    prev.next = p1.next;
    p1.next = null;
    System.out.println();
    System.out.println("Last nth item ::" + p1.data);
    printList(head);

  }

}
