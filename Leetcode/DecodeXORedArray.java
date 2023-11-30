/*
 * 1720. Decode XORed Array
 * https://leetcode.com/problems/decode-xored-array/description/
*/

package DSA.Leetcode;

public class DecodeXORedArray {
    public static int[] decode(int[] encoded, int first) {
        // encoded[i] = arr[i] ^ arr[i + 1]
        int[] arr = new int[encoded.length +1];
        arr[0] = first;
        for(int i=0; i<arr.length-1; i++){
            arr[i+1] = encoded[i] ^ arr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] encoded = {1,2,3};
        for(int i: decode(encoded, 1)){
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
