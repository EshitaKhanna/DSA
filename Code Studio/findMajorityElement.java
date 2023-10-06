/*
 * Striver SDE Sheet Problems
 * Question: https://www.codingninjas.com/studio/problems/majority-element_842495?topList=striver-sde-sheet-problems&leftPanelTab=0
 */ 

import java.util.HashMap;
import java.util.Map;

public class findMajorityElement {

	public static int findMajority(int[] arr, int n) {
		// Write your code here.
		Map<Integer, Integer> freq = new HashMap<>();
		
		int max = n/2;
		for(int i: arr) {
			freq.put(i, freq.getOrDefault(i,0)+1);
		}
		
		for(Map.Entry<Integer, Integer> ele: freq.entrySet()) {
			if(ele.getValue() > max) {
				return ele.getKey();
			}
		}
		
		return -1;
	}
	
	public static void main(String [] args) {
		int []arr = {2, 3, 9, 2, 2};
		int n = arr.length;
		
		int []arr2 = {8, 5, 1, 9};
		int n2= arr2.length;
		
		System.out.println("Majority element is " + findMajority(arr, n));
		
	}
}
