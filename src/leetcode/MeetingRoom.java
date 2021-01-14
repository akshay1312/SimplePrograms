package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : apitale
 * @Date : 12/6/20
 */
public class MeetingRoom {

  public static void main(String[] args) {
    MeetingRoom mr = new MeetingRoom();
    int[][] intervals = {{0,30}, {5,10}, {15,20}};
    System.out.println("result :: " + mr.canAttendMeetings(intervals));

    int[][] intervals2 = {{7,10}, {2,4}, {15,20}};
    System.out.println("result :: " + mr.canAttendMeetings(intervals2));

    System.out.println("Min Rooms Required:: " + mr.minMeetingRooms(intervals));
    System.out.println("Min Rooms Required:: " + mr.minMeetingRooms(intervals2));
  }
  public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparing((int[] arr) -> arr[0]));

    for(int i=0; i<intervals.length -1 ; i++) {
      if(intervals[i][1] > intervals[i+1][0])
        return false;
    }
    return true;
  }

  public int minMeetingRooms(int[][] intervals) {

    // Check for the base case. If there are no intervals, return 0
    if (intervals.length == 0) {
      return 0;
    }
    // Sort the intervals by start time
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    // Min heap
    PriorityQueue<Integer> allocator =
        new PriorityQueue<Integer>(
            intervals.length,
            new Comparator<Integer>() {
              public int compare(Integer a, Integer b) {
                return a - b;
              }
            });

    // Add the first meeting
    allocator.add(intervals[0][1]);

    // Iterate over remaining intervals
    for (int i = 1; i < intervals.length; i++) {

      // If the room due to free up the earliest is free, assign that room to this meeting.
      if (intervals[i][0] >= allocator.peek()) {
        allocator.poll();
      }

      // If a new room is to be assigned, then also we add to the heap,
      // If an old room is allocated, then also we have to add to the heap with updated end time.
      allocator.add(intervals[i][1]);
    }

    // The size of the heap tells us the minimum rooms required for all the meetings.
    return allocator.size();
  }
}
