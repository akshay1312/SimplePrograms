package DataStructure.linkedList;

import DataStructure.Node;

/**
 * Created by Akshay1312 on 11/13/2015.
 */
public class    SingleLinkList {
  private Node head;
  private int size;

  public SingleLinkList() {
    head = null;
    size = 0;
  }

  public static void main(String args[]) {
    SingleLinkList singleLinkList = new SingleLinkList();

    singleLinkList.add(3);
    singleLinkList.add(5);
    singleLinkList.add(2);

    singleLinkList.add(4, 1);
    singleLinkList.add(9, 0);
    singleLinkList.add(7, 2);
    singleLinkList.findData(5);
    singleLinkList.remove(3);
    System.out.print(singleLinkList.toString());
  }

  private void findData(int data) {
    Node temp = head;
    while (temp != null && temp.getData() != data) {
       temp = temp.getLink();
    }
    if(temp.getData() == data) {
      System.out.println("Found data :: " + temp.getData());
    }
  }

  public void add(int data) {
    Node temp = new Node(data, null);

    if (head == null) {
      head = temp;
      this.size++;
      return;
    }
    Node last = head;
    while (last.getLink() != null)
      last = last.getLink();
    last.setLink(temp);
    this.size++;
  }

  public void add(int data, int index) {
    Node temp = new Node(data, null);

    if (index == 0) {
      temp.setLink(head);
      this.head = temp;
      this.size++;
      return;
    }

    Node current = head;
    for (int i = 1; i < index; i++)
      current = current.getLink();
    temp.setLink(current.getLink());
    current.setLink(temp);
    this.size++;
  }

  public void remove(int index) {
    Node current = head;
    if (index == 0) {
      head = head.getLink();
    } else {
      for (int i = 1; i < index; i++)
        current = current.getLink();

      current.setLink(current.getLink().getLink());
    }

    this.size--;
  }

  public String toString() {
    String list = "";
    list += "[" + this.head.getData() + "]";

    Node curr = head.getLink();
    while (curr != null) {
      list += "[" + curr.getData() + "]";
      curr = curr.getLink();
    }

    return list;

  }
}
