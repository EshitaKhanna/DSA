/*
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/description/
*/

package DSA.Leetcode;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] m2 = new int[m][n];
        int k = 0;
        int l = 0;
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j-- ){
                m2[k][l] = matrix[i][j];
                k++;
                l++;
            }
        }
        for(int i=0; i<n-1; i++){
            for(int j=0; j<m-1; j++){
                matrix[i][j] = m2[i][j];
            }
        }
    }
    public static void main(String[] args) {
        int[][] arr =  {{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
