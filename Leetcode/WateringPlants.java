/*
 * 2079. Watering Plants
 * https://leetcode.com/problems/watering-plants/description/
*/

package DSA.Leetcode;

public class WateringPlants {
    public static int wateringPlants(int[] plants, int capacity) {
    
        int steps = 0;
        int curr_capacity = capacity;

        for(int i=0; i<plants.length; i++){
            if(curr_capacity >= plants[i]){
                curr_capacity -= plants[i];
                steps ++;
            }else{
                steps += 2*i; 
                curr_capacity = capacity;
                curr_capacity -= plants[i];
                steps ++;
            }
        }

        return steps;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,3,3};
        System.out.println(wateringPlants(arr, 5));
    }
}
