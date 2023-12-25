/*
 * 2391. Minimum Amount of Time to Collect Garbage
 * https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/description/
*/

package DSA.Leetcode;

public class MinimumAmountOfTimeToCollectGarbage {
    public static int garbageCollection(String[] garbage, int[] travel) {
        int garbage_collection_time = 0;
        int travel_time = 0;
        int total_time = 0;

        int g = 0;
        int m = 0;
        int p = 0;

        for(int i=0; i<garbage.length; i++){
            String str = garbage[i];
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == 'M'){
                    m = i;
                }else if(str.charAt(j) == 'P'){
                    p = i;
                }else if(str.charAt(j) == 'G'){
                    g = i;
                }
                garbage_collection_time++;
            }
        }

        for(int i=1; i<travel.length; i++){
            travel[i] += travel[i-1];
        }

        if(m>0){
            travel_time += travel[m-1];
        }else{
            travel_time += 0;
        }

        if(p>0){
            travel_time += travel[p-1];
        }else{
            travel_time += 0;
        }

        if(g>0){
            travel_time += travel[g-1];
        }else{
            travel_time += 0;
        }

        total_time = garbage_collection_time + travel_time;
        return total_time;

    }

    public static void main(String[] args) {
        String[] garbage = {"G","P","GP","GG"};
        int[] travel ={2,4,3};

        System.out.println(garbageCollection(garbage, travel));
    }
}
