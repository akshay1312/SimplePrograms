package SapientQuestions.designQuestion;

import java.util.HashMap;

/**
 * Implement two methods of concierge interface which is store and retrieve
 *
 * Condition : 1. Storage bin allows 2 carry on Bags or 1 checked bag 2. Storage Size is limited
 *
 * @author akshay Date 2019-07-09 14:02
 */

public class BaggageConcierge implements Concierge {

  public HashMap<Ticket, StorageBin> hashMap = new HashMap<>();
  public int capacity = 10;

  @Override
  public Ticket store(Bag bag) {
    if (capacity == hashMap.size()) {
      return null;
    } else {
      Ticket ticket = new Ticket();
      hashMap.put(ticket, new StorageBin());
    }
    return null;
  }

  @Override
  public Bag retrieve(Ticket ticket) {
    return null;
  }
}
