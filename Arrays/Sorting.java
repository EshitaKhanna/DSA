public class Sorting {

	public static int[] bubbleSort(int[] input) {
		for(int j=0; j<input.length-1; j++) {
			for(int i=0; i<input.length-1; i++) {
				if(input[i+1] < input[i]) {
					int temp = input[i];
					input[i] = input[i+1];
					input[i+1] = temp;
				}
			}
		}
		return input;
	}

	public static int[] selectionSort(int[] input) {
		for(int i=0; i<input.length-1; i++) {
			int min = input[i];
			int minIndex = i;
			for(int j = i+1; j<input.length; j++) {
				if(input[j] < min) {
					min = input[j];
					minIndex = j;
				}
			}
			if(minIndex != i) {
				input[minIndex] = input[i];
				input[i] = min;
			}
		}
		return input;
	}

	public static int[] insertionSort(int[] input) {
		for(int i=1; i<input.length; i++) {
			int j = i-1;
			int temp = input[i];
			while(j>=0 && input[j] > temp) {
				input[j+1] = input[j]; 
				j--;
			}
			input[j+1] = temp;
		}
		return input;
	}

	public static int[] mergeSort(int[] input, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;

			mergeSort(input, start, mid);
			mergeSort(input, mid+1, end);
			merge(input, start, mid, end);
		}
		return input;
	}

	public static void merge(int[] input, int start, int mid, int end) {
		int n1 = mid - start + 1;
		int n2 = end - mid;

		int[] left = new int[n1];
		int[] right = new int[n2];

		for (int i = 0; i < n1; ++i) {
			left[i] = input[start + i];
		}
		for (int j = 0; j < n2; ++j) {
			right[j] = input[mid + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = start;

		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				input[k] = left[i];
				i++;
			} else {
				input[k] = right[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			input[k] = left[i];
			i++;
			k++;
		}

		while (j < n2) {
			input[k] = right[j];
			j++;
			k++;
		}
	}

	public static int partition(int[] input, int start, int end) {
		
		int pivot = input[end];
		int i = start-1;
		
		for(int j=start; j<=end-1; j++) {
			if(input[j] < pivot) {
				i++;
				swap(input, i, j);
			}
		}
		
		swap(input, i+1, end);
		
		return i+1;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
        arr[j] = temp;
		
	}
	
	public static int[] quickSort(int[] input, int start, int end) {
		if(start<end) {
			int pivot = partition(input, start, end);
			quickSort(input, start, pivot-1);
			quickSort(input, pivot+1, end);
		}
		
		return input;
	}
	
	public static void main(String[] args) {
		
		int[] input = {2,6,9,1,5};
		
		//selectionSort(input);
		//bubbleSort(input);
		//insertionSort(input);
		//mergeSort(input, 0,input.length-1);
		quickSort(input, 0,input.length-1);

		for(int i:input) {System.out.print(i + " ");}

	}

}
