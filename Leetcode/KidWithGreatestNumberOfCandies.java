/*
 * 1431. Kids With the Greatest Number of Candies
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
*/
package DSA.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidWithGreatestNumberOfCandies {
    
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = candies[0];
        for(int i=1;i<candies.length;i++){
            if(candies[i] > max){
                max = candies[i];
            }         
        }
        for(int i = 0; i <candies.length; i++){
            if(candies[i]+extraCandies >= max){
              list.add(true);
            }else{
              list.add(false);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int candies[] = {2,3,5,1,3};
        for(boolean flag : kidsWithCandies(candies, 3)){
            System.out.print(flag + " ");
        }

    }
}
