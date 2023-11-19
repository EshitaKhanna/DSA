/*
 * 2114. Maximum Number of Words Found in Sentences
 * https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/description/
*/

package DSA.Leetcode;

public class MaximumNumberOfWordsFoundinSentences {
    public static int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<sentences.length; i++){
            int count = 1;
            String word = sentences[i];
            for (int j = 0; j < word.length(); j++) {
                if(word.charAt(j) == ' '){
                    count++;
                }
            }
            if(count>max){
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(mostWordsFound(sentences));
    }
}
