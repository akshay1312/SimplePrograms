package leetcode;

import java.util.Arrays;
import java.util.Comparator;

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
  }
  public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparing((int[] arr) -> arr[0]));

    for(int i=0; i<intervals.length -1 ; i++) {
      if(intervals[i][1] > intervals[i+1][0])
        return false;
    }
    return true;
  }

}
