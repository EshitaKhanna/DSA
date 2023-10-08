import java.util.Arrays;
public class Searching {
	public static int linearSearch(int[] input, int x) {
		for(int i = 0; i<input.length; i++) {
			if(input[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public static int binarySearch(int[] input, int x) {
		int start = 0;
		int end = input.length-1;

		while(start <= end){
			int mid = (start + end)/2;	

			if(input[mid]>x) {
				end = mid-1;
			}else if(input[mid]<x) {
				start = mid+1;
			}
			else {
				return mid;
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		int arr[] = {1,2,5,3,0};
		System.out.println(linearSearch(arr, 0));
		Arrays.sort(arr);
		System.out.println(binarySearch(arr, 0));

	}

}
