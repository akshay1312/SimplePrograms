package DataStructure.linkedList;

/**
 * Created by apitale on 2018-04-09.
 */
public class MergeLinkedList {

  Node head;  // head of list
  static Node a, b;

  /* Node Class */
  static class Node {

    int data;
    Node next;

    // Constructor to create a new node
    Node(int d) {
      data = d;
      next = null;
    }
  }

  public static void main(String args[])
  {
    MergeLinkedList list = new MergeLinkedList();
    Node result = null;

        /*Let us create two sorted linked lists to test
         the above functions. Created lists shall be
         a: 5->10->15
         b: 2->3->20*/
    list.a = new Node(5);
    list.a.next = new Node(10);
    list.a.next.next = new Node(15);

    list.b = new Node(2);
    list.b.next = new Node(3);
    list.b.next.next = new Node(20);

    System.out.println("List a before merge :");
    list.printlist(a);
    System.out.println("");
    System.out.println("List b before merge :");
    list.printlist(b);

    // merge two sorted linkedlist in decreasing order
    result = list.sortedmerge(a, b);
    result = list.sortedmerge2(a, b);
    System.out.println("");
    System.out.println("Merged linked list : ");
    list.printlist(result);
  }

  // merge without recursion
  private Node sortedmerge2(Node a, Node b) {
    return null;
  }

  private Node sortedmerge(Node node1, Node node2) {
    if (node1 == null && node2 == null) {
      return null;
    }
    if(node1 == null) {
      return node2;
    }
    if(node2 == null) {
      return node1;
    }
    Node result = null;
      if(node1.data < node2.data) {
        result = node1;
        result.next = sortedmerge(node1.next, node2);
      } else if(node1.data > node2.data) {
        result = node2;
        result.next = sortedmerge(node1, node2.next);
      } else {
        return result;
    }
    return result;
  }

  void printlist(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }


}
