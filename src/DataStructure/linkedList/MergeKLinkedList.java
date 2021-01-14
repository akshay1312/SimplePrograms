package DataStructure.linkedList;

import java.util.PriorityQueue;

/**
 * Created by apitale on 2018-04-09.
 */
public class MergeKLinkedList {

  static Node a, b, c;

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
    MergeKLinkedList list = new MergeKLinkedList();
    Node result;

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

    list.c = new Node(1);
    list.c.next = new Node(7);
    list.c.next.next = new Node(9);

    System.out.println("List a before merge :");
    list.printlist(a);
    System.out.println("");
    System.out.println("List b before merge :");
    list.printlist(b);
    System.out.println("");
    System.out.println("List c before merge :");
    list.printlist(c);


    // merge two sorted linkedlist in decreasing order
    //result = list.sortedmerge(a, b);
    Node[] arrayList = new Node[]{a,b,c};
   // result = list.mergeKList(arrayList);
    result = list.mergeKLists2(arrayList);
    System.out.println("");
    System.out.println("Merged linked list : ");
    list.printlist(result);
  }

  private Node mergeKList(Node[] arrayList) {
    int k = arrayList.length;
    if(k == 0) {
      return null;
    }

    if(k == 1) {
      return arrayList[0];
    }

    int n = 0;
    Node a = arrayList[0], b = arrayList[1];
    for (int i = 1; i<k; i++) {
      a = sortedmerge2(a, arrayList[i]);
    }

    return a;
  }

  public Node mergeKLists2(Node[] lists) {

    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

    for(Node node : lists){
      while(node != null){
        pq.add(node);
        node = node.next;
      }
    }

    Node root = new Node(-1);
    Node pointer = root;

    while(!pq.isEmpty()){
      pointer.next = new Node(-1);
      pointer = pointer.next;
      pointer.data = pq.poll().data;
    }
    return root.next;
  }
  // merge without recursion
  private Node sortedmerge2(Node a, Node b) {
    Node preHead = new Node(-1);
    Node prev = preHead;
    while(a != null && b != null) {
      if(a.data < b.data) {
        prev.next = a;
        a = a.next;
      } else {
        prev.next = b;
        b = b.next;
      }
      prev = prev.next;
    }
    prev.next = a == null ? b : a;
    return preHead.next;
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
    Node result;
      if(node1.data < node2.data) {
        result = node1;
        result.next = sortedmerge(node1.next, node2);
      } else {
        result = node2;
        result.next = sortedmerge(node1, node2.next);
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
