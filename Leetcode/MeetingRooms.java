/*
 * 252. Meeting Rooms
 * https://leetcode.com/problems/meeting-rooms/description/
*/
package DSA.Leetcode;

import java.util.Arrays;
import java.util.List;

public class MeetingRooms {
    public static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        int start[] = new int[intervals.size()];
        int finish[] = new int[intervals.size()];
        
        for(int i=0; i<intervals.size(); i++){
            start[i] = intervals.get(i).start;
            finish[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(finish);

        int i =0;

        for(int j=1; j<intervals.size(); j++){
            //start time > end time
            if(start[j] < finish[i]){
                return false;
            }
            finish[i] = finish[j];
        }
        return true;
    }
    public static void main(String[] args) {
        
        List<Interval> interval = Arrays.asList(
            new Interval(0, 30),
            new Interval(5, 10), 
            new Interval(15,20)
            );
        System.out.println(canAttendMeetings(interval));
        
    }
}
