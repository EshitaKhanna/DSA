/*
 * 771. Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/description/
*/

package DSA.Leetcode;

public class JewelsAndStones {
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for(int i=0; i<stones.length(); i++){
            for(int j=0; j<jewels.length(); j++){
                if(stones.charAt(i) == jewels.charAt(j)){
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
    }
}
