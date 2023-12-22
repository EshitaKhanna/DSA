/*
 * 1422. Maximum Score After Splitting a String
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/
*/
package DSA.Leetcode;

public class MaximumScoreAfterSplittingAString {
    public static int maxScore(String s) {
        int one = 0;
        int zero = 0;
        int score = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                one ++;
            }
        }

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == '1'){
                one --;
            }else{
                zero ++;
            }

            score = Math.max(score, (one+zero));
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
    }
}
