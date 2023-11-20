package DSA.Leetcode;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        /*
        String s = "";
        for(int i=0; i<digits.length; i++){
            s += digits[i];
        }
        int result = Integer.valueOf(s)+ 1;
        String reString = Integer.toString(result);

        int[] arr = new int[reString.length()];
        for(int i=0; i<arr.length; i++){
            arr[i] = Character.getNumericValue(reString.charAt(i));
        } 
        return arr;
        */

        for(int i=digits.length-1; i>=0; i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }
        int [] result = new int[digits.length +1];
            result[0] = 1;

            return result;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(plusOne(arr))); // output = [1,0,0,0]
    }


}
