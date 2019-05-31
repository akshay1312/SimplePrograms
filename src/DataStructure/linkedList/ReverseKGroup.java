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
    System.out.println("");

    ReverseKGroup list1 = new ReverseKGroup();
    list1.head = new Node(5);
    list1.head.next = new Node(6);
    list1.head.next.next = new Node(15);
    list1.head.next.next.next = new Node(14);
    list1.head.next.next.next.next = new Node(12);
    list1.head.next.next.next.next.next = new Node(18);
    list1.head.next.next.next.next.next.next = new Node(25);
    System.out.println("Given Linked list 1");
    list.printList(head);
    System.out.println("");
    head = list.reverseKGroup(head, 3, 5);
    System.out.println("");
    System.out.println("Reversed k group linked list 1 ");
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


  private Node reverseKGroup(Node head, int m, int n) {
    Node current = head;
    Node prev = head;
    Node last = null;
    Node end = head;
    int count = 1;
    while(prev != null && count < m-1) {
      prev = prev.next;
      count++;
    }
    current = prev.next;
    System.out.println("Prev :: " + prev.data);
    System.out.println("Current :: " + current.data);
    int ending = 1;
    while(end != null && ending <= n-1) {
      end = end.next;
      ending++;
    }
    last = end.next;
    System.out.println("end :: " + end.data);
    System.out.println("last :: " + last.data);
    Node reverse = reverse(current, ending, count);
    return head;
  }

  private Node reverse(Node node, int end, int start) {
    Node prev = null;
    Node startNode = node;
    while(start != end) {
      Node temp = node.next;
      node.next = prev;
      prev = node;
      node = temp;
      start++;
    }
    startNode.next = node.next;
    node.next = prev;
    return node;
  }

  private Node reverseKGroupStack(Node head, int m, int n) {
    Node current = head;
    Node prev = head;
    Node last = null;
    Node end = head;
    int count = 1;
    while(prev != null && count < m-1) {
      prev = prev.next;
      count++;
    }
    current = prev.next;
    System.out.println("Prev :: " + prev.data);
    System.out.println("Current :: " + current.data);
    count = 1;
    while(end != null && count <= n-1) {
      end = end.next;
      count++;
    }
    last = end.next;

    return head;
  }

}
