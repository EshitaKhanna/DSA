/*
 * 1816. Truncate Sentence
 * https://leetcode.com/problems/truncate-sentence/description/
*/
package DSA.Leetcode;

public class TruncateSentence {
    public static String truncateSentence(String s, int k) {
        String[] ans = s.split(" ");
        StringBuilder str = new StringBuilder();

        for(int i=0; i<k; i++){
            str.append(ans[i]);
            if (i < k - 1) {
                str.append(" ");
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        System.out.println(truncateSentence(s, 4));
    }
}
