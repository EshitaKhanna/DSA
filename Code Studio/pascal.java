/*
 * Striver SDE Sheet Problems
 * Question: https://www.codingninjas.com/studio/problems/pascal-s-triangle_1089580?topList=striver-sde-sheet-problems&leftPanelTab=0
 */ 
import java.util.ArrayList;
public class pascal {


	public static ArrayList<ArrayList<Long>> printPascal(int n) {
		// Write your code here.
		ArrayList<ArrayList<Long>> ans = new ArrayList<>();

		for(int i=0; i<n; i++){
			ArrayList<Long> row = new ArrayList<>();

			for(int j=0; j<=i ; j++){
				long row_values = factorial(i) / (factorial(i - j) * factorial(j));
				row.add(row_values);
			}

			ans.add(row);
		}
		return ans;

	}

	private static long factorial(int n) {
		long result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	public static void main (String [] args) {
		System.out.println(printPascal(3));
	}

}
