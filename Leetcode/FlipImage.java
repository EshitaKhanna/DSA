package DSA.Leetcode;

public class FlipImage {
    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        // flip the array i.e. reverse each row
        int [][] flipped = new int[n][n];

        // invert the array i.e interchange 0 and 1
        int [][] output = new int[n][n];

        return output;
        
    }

    public static void main(String [] args){
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] output = flipAndInvertImage(image);
        for(int i=0; i<output.length; i++){
            for(int j=0; j<output[0].length; j++){
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }

}