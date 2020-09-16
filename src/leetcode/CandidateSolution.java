package leetcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class CandidateSolution {

  public static void main(String[] args) throws IOException {

    List<Long[]> startTime = new ArrayList<>();

    startTime.add(new Long[]{1597588152l, 1597591752l});
    startTime.add(new Long[]{1597588152l, 1597591752l});
    startTime.add(new Long[]{1597588152l, 1597591752l});
    startTime.add(new Long[]{1597588152l, 1597591752l});
    startTime.add(new Long[]{1597588152l, 1597591752l});
    startTime.add(new Long[]{1597588152l, 1597591752l});
    startTime.add(new Long[]{1597588152l, 1597591752l});
    startTime.add(new Long[]{1597588152l, 1597591752l});
    startTime.add(new Long[]{1597588152l, 1597591752l});

    CandidateSolution solution = new CandidateSolution();
    for (Long[] time : startTime) {
      int result = solution.reserveRoom(time[0], time[1]);
      System.out.println("Room Number :: "+ result);
    }

  }

  private Stack<Integer> freeRooms;
  private PriorityQueue<RoomAllocation> bookedRooms;

  CandidateSolution() {
    freeRooms = new Stack<>();
    bookedRooms = new PriorityQueue<>((o1, o2) -> {
      if (o1.end < o2.end) {
        return 1;
      } else if (o1.end > o2.end) {
        return -1;
      }
      return 0;
    });
    for (int i = 8; i >= 1; i--) {
      freeRooms.push(i);
    }
  }

  public int reserveRoom(long startEpochSeconds, long endEpochSeconds) {
    if (!bookedRooms.isEmpty() && startEpochSeconds >= bookedRooms.peek().end) {
      freeRooms.push(bookedRooms.poll().roomNumber);
    }
    // implement this method
    if (freeRooms.isEmpty()) {
      return -1;
    }

    // validate meeting start and ends on 5 min interval
    long temp = endEpochSeconds - startEpochSeconds;
    if (temp % 5 != 0) {
      return -2;
    }

    // validate if meeting at least 5 min long and not more than 7 days
    if (temp < 300 || temp > 604800) {
      return -2;
    }

    int freeRoom = freeRooms.pop();
    bookedRooms.add(new RoomAllocation(startEpochSeconds, endEpochSeconds, freeRoom));
    return freeRoom;
  }

}


class RoomAllocation {

  long start;
  long end;
  int roomNumber;

  RoomAllocation(long start, long end, int roomNumber) {
    this.start = start;
    this.end = end;
    this.roomNumber = roomNumber;
  }
}
