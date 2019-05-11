package DataStructure.linkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * @author akshay Date 2019-05-02 11:47
 */
public class FindDuplicates {

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
    FindDuplicates list = new FindDuplicates();
    list.head = new Node(85);
    list.head.next = new Node(15);
    list.head.next.next = new Node(4);
    list.head.next.next.next = new Node(85);
    list.head.next.next.next.next = new Node(20);
    list.head.next.next.next.next.next = new Node(12);

    System.out.println("Given Linked list");
    list.printList(head);
    list.RemoveDuplicate(head);
    System.out.println();
    System.out.println("After Removing Duplicates ");
    list.printList(head);
  }

/*  private Node RemoveDuplicate(Node head) {
    Node previous = head;
    Node current = head.next;
    while (current != null) {
      Node runner = head;
      while(runner != current) {
        if(runner.data == current.data) {
          Node temp = current.next;
          previous.next = temp;
          current = temp;
          break;
        }
        runner = runner.next;
      }
      previous = current;
      current = current.next;
    }
    return head;
  }*/

  private void RemoveDuplicate(Node head) {
    HashSet hashtable = new HashSet();
    Node previous = null;
    Node current = head;
    while(current != null) {
      int data = current.data;
      if(hashtable.contains(data))
         previous.next = current.next;
      else {
        hashtable.add(data);
        previous = current;
      }
      current = current.next;
    }
  }
}
