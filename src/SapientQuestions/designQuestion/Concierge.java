package SapientQuestions.designQuestion;

/**
 * @author akshay Date 2019-07-09 14:19
 */
public interface Concierge {
  Ticket store(Bag bag);
  Bag retrieve(Ticket ticket);
}
