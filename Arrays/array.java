package DSA.Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class array {
	public static int[] pushZerosAtEnd(int[] arr) {
		int n = arr.length;
		int[] temp = new int[n];
		int k=0;

		for(int i=0; i<arr.length; i++) {
			if(arr[i] !=0 ) {
				temp[k] = arr[i];
				k++;
			}

		}
		while(k<n) {
			temp[k] = 0;
			k++;
		}
		return temp;
	}

	public static int[] rotateArray(int[] arr, int d) {
		int n = arr.length;
		int[] temp = new int[n];
		int k =0;


		for(int i=d; i<n; i++) {
			temp[k] = arr[i];
			k++;
		}

		for(int i=0; i<d; i++) {
			temp[k] = arr[i];
			k++;
		}

		for(int i=0; i<n; i++) {
			arr[i] = temp[i];
		}
		return arr;
	}

	public static int secondLargestElement(int[] arr) {

		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;

		for(int i: arr) {
			if(i>first) {
				first = i;
			}
		}

		for(int i: arr) {
			if(i>second && i<first) {
				second = i;
			}
		}

		return second;

	}

	public static int arrayRotateCheck(int[] arr){
		int index = 0 ;

		for( int i=1; i< arr.length; i++) {
			if(arr[i-1] > arr[i]){
				index = i;
			}
		}
		return index;
	}
	
	 
	public static void main(String[] args) {
		int[] arr = {0,2,1,0,9,4,0};

		//for(int i: pushZerosAtEnd(arr)) {System.out.print(i + " "); }

		//for(int i: rotateArray(arr,2)) { System.out.print(i + " "); }
		//for(int i: rotateArray(arr,2)) { System.out.print(i + " "); }
		
        int[] arr1 = {3,4,5,1,2};
		//System.out.print(secondLargestElement(arr1)); 
		System.out.print(arrayRotateCheck(arr1)); 
	}

}
