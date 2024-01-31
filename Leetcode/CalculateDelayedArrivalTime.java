/*
 * 2651. Calculate Delayed Arrival Time
 * https://leetcode.com/problems/calculate-delayed-arrival-time/description/
*/
package DSA.Leetcode;

public class CalculateDelayedArrivalTime {
    public static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int sum = arrivalTime + delayedTime;
        if(sum >= 24){
            sum = sum %24;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findDelayedArrivalTime(11, 12));
    }
}
