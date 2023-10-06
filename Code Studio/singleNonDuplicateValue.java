/*
 * Striver SDE Sheet Problems
 * Question: https://www.codingninjas.com/studio/problems/unique-element-in-sorted-array_1112654?topList=striver-sde-sheet-problems&leftPanelTab=0
 */ 

import java.util.ArrayList;
import java.util.Collections;

public class singleNonDuplicateValue {

	//Time COmplexity O(n)
	public static int singleNonDuplicate1(ArrayList<Integer> arr) {

		int maxValue = Collections.max(arr);

		ArrayList<Integer> freq = new ArrayList<>(maxValue+1);

		for (int i = 0; i <= maxValue+1; i++) {
			freq.add(0);
		}

		for (int val : arr) {
			freq.set(val, freq.get(val) + 1);
		}

		for (int i = 0; i < freq.size(); i++) {
			if (freq.get(i) == 1) {
				return i;
			}
		}
		return -1;

	}

	//Time COmplexity O(n)
	public static int singleNonDuplicate2(ArrayList<Integer> arr){
		int result = 0;

		for (int num : arr) {
			result ^= num;
		}

		return result;
	}

	//Time COmplexity O(log n)
	public static int singleNonDuplicate3(ArrayList<Integer> arr) {
		int left = 0;
		int right = arr.size() - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			// Ensure mid is at an even index
			if (mid % 2 == 1) {
				mid--;
			}

			// Check if the single non-duplicate is on the left or right side
			if (arr.get(mid).equals(arr.get(mid + 1))) {
				left = mid + 2;  // Unique number is on the right side
			} else {
				right = mid;  // Unique number is on the left side
			}
		}

		return arr.get(left);
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();

		arr.add(1);
		arr.add(1);
		arr.add(2);
		arr.add(2);
		arr.add(3);
		arr.add(3);
		arr.add(4);

		for(int i: arr) {
			System.out.print(i + " ");
		}
		System.out.println("\nThe single non-duplicate value in the array is: " + singleNonDuplicate1(arr));
		System.out.println("\nThe single non-duplicate value in the array is: " + singleNonDuplicate2(arr));
		System.out.println("\nThe sisinglegnle non-duplicate value in the array is: " + singleNonDuplicate3(arr));

	}

}
