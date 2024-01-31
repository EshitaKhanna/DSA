/*
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/description/
*/
package DSA.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures{

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        int[] res = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; --i) {
            if (deque.isEmpty()) {
                deque.offerFirst(i);
                res[i] = 0;
            } else {
                while (!deque.isEmpty() && temperatures[i] >= temperatures[deque.peekFirst()]) {
                    deque.pollFirst();
                }

                if (deque.isEmpty()) {
                    res[i] = 0;
                }else {
                    res[i] = deque.peekFirst() - i;
                }

                deque.offerFirst(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};
        for(int i: dailyTemperatures(temp)){
            System.out.print(i + " ");
        }
    }
}