/*
 * 1893. Check if All the Integers in a Range Are Covered
 * https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/description/
*/
package DSA.Leetcode;

public class CheckIfAlltheIntegersInARangeAreCovered {
    public static boolean isCovered(int[][] ranges, int left, int right) {

        
        for(int i =left ; i <= right; i++){
            boolean flag = false;
            for(int j = 0; j < ranges.length; j++){
                if(ranges[j][0] <= i && i <= ranges[j][1]){
                    flag = true;
                    break;
                }
            }
            if(flag== false){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] ranges = {{1,2},{3,4},{5,6}};
        System.out.println(isCovered(ranges, 2, 5));
    }
}
