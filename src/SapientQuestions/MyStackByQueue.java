package SapientQuestions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author akshay Date 2019-05-05 16:15
 */
public class MyStackByQueue {


  public static void main(String args[]) {
    MyStackByQueue s = new MyStackByQueue();
    Stack stack = new Stack();
    stack.queue1 = new LinkedList();
    stack.queue2 = new LinkedList();
    s.push(6);
    s.push(7);
    s.push(34);
    s.push(56);


    System.out.println("current size: " + s.size());
    System.out.println(s.top());
    s.pop();
    System.out.println(s.top());
    s.pop();
    System.out.println(s.top());

    System.out.println("current size: " + s.size());

  }

  private void pop() {

  }

  private boolean top() {
    return false;
  }

  private String size() {
    return null;
  }

  private void push(int i) {

  }

  static class Stack {

    Queue queue1;
    Queue queue2;
    static int currentSize;

    public Stack() {
      currentSize = 0;
    }

  }
}
