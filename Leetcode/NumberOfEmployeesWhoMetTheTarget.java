/*
 * 2798. Number of Employees Who Met the Target
 * https://leetcode.com/problems/number-of-employees-who-met-the-target/description/
*/

package DSA.Leetcode;

public class NumberOfEmployeesWhoMetTheTarget {
    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for(int i=0; i<hours.length; i++){
            if(hours[i] >= target){
                count ++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        System.out.println(numberOfEmployeesWhoMetTarget(nums, 2));
    }
}
