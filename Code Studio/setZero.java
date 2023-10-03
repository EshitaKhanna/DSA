/*
 * Striver SDE Sheet Problems
 * Question: https://www.codingninjas.com/studio/problems/set-matrix-zeros_3846774?topList=striver-sde-sheet-problems
 */ 
public class setZero {
	public static void setZeros(int matrix[][]) {
		// Write your code here..
		int n = matrix.length;
		int m = matrix[0].length;

		boolean row[] = new boolean[n];
		boolean col[] = new boolean[m];

		for (int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					col[j] = true;
				}
			}
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(row[i] ==true || col[j] ==true){
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String args[]) {
		int [][] matrix = {{7,0,3}, {4,21,0}};
		setZeros(matrix);
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
