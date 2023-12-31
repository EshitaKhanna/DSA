/*
 * 258. Add Digits
 * https://leetcode.com/problems/add-digits/description/
*/
package DSA.Leetcode;

public class AddDigits {
    public static int addDigits(int num) {
        int sum = 0;
        while(num>0){
            sum += (num % 10);
            num /= 10;

            if(sum > 9 && num == 0){
                num = sum;
                sum = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
