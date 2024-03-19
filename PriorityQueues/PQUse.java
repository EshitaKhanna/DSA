package DSA.PriorityQueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PQUse {
    //Inplace Heap Sort Using Min PQ
    private static void insertIntoVirtualHeap(int[] arr, int i) {
        int childIndex = i;
        int parentIndex = (childIndex -1) /2;

        while(childIndex>0){
            if(arr[childIndex] < arr[parentIndex]){
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;

                childIndex = parentIndex;
                parentIndex = (childIndex -1) /2;
            }else{
                return;
            }
        }
    }

    private static int removeMinFromVirtualHeap(int[] arr, int heapSize) {
        int temp = arr[0];
        arr[0] = arr[heapSize-1];
        heapSize--;

        int index = 0;
        int leftChildIndex = 2*index +1;
        int rightChildIndex = 2*index +2;

        while(leftChildIndex < heapSize){
            int minIndex = index;
            if(arr[leftChildIndex] < arr[minIndex]){ // till leaf node
                minIndex = leftChildIndex;
            }

            if(rightChildIndex < heapSize && arr[rightChildIndex] < arr[minIndex]){
                minIndex = rightChildIndex;
            }

            if(minIndex != index){
                //swap
                int temp1 = arr[index];
                arr[index] = arr[minIndex];
                arr[minIndex] = temp1;

                leftChildIndex = 2*index +1;
                rightChildIndex = 2*index +2;

            }else{
                break;
            }
        }
        return temp;
    }
    
    //k sorted array
    public static void sortKSorted(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        for( ; i<k; i++){
            pq.add(arr[i]);
        }
        for(; i<arr.length; i++){
            arr[i-k] = pq.remove();
            pq.add(arr[i]);
        }
        // for remaining k elements
        for(int j=arr.length - k; j<arr.length; j++){
            arr[j] = pq.remove();
        }
        

    }
    
    //k largest
    public static ArrayList<Integer> kLargest(int input[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> output = new ArrayList<>();

        int i = 0;
        for(; i<k; i++){
            pq.add(input[i]);
        }

        for(; i<input.length; i++){
            int min = pq.peek();
            if(min < input[i]){
                pq.remove();
                pq.add(input[i]);

            }
        }

        while(!pq.isEmpty()){
            output.add(pq.remove());
        }

        return output;
    }
    
    public static int buyTicket(int input[], int k) {
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //max PQ
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<input.length; i++){
            pq.add(input[i]);
            queue.add(i);

        }

        while(!pq.isEmpty()){
            int frontPerson = queue.poll();
            int frontPriority = input[frontPerson];

            if(pq.peek() > frontPriority){
                queue.add(frontPerson); //move person to end
            }else{
                //give the ticket and increase the time
                time ++;
                pq.poll();
                if(frontPerson == k){
                    break;
                }
            }
        }
        return time;
    }

    public static void main(String[] args) throws PQ_Exception {
        //Inplace Heap Sort
       
        // int arr[] = {5,1,9,2,0,6};
        // for(int i=0; i<arr.length; i++){
        //     insertIntoVirtualHeap(arr,i);
        // }

        // for(int i=0; i<arr.length; i++){
        //     arr[arr.length-1-i] = removeMinFromVirtualHeap(arr, arr.length-i);

        // }

        // for(int i=0; i<arr.length; i++){
        //     System.out.print(arr[i] + " ");
        // }

        // Min_Priority_Queue pq = new Min_Priority_Queue();
        // int arr[] = {5,1,9,2,0,6};
        // for(int i=0; i<arr.length; i++){
        //     pq.insert(arr[i]);
        // }

        // while(!pq.isEmpty()){
        //     System.out.print(pq.removeMin() + " ");
        // }
        // System.out.println();

        //Inbuilt PQ
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int arr[] = {9,1,0,4,7,3};
        // for(int i=0; i<arr.length; i++){
        //     pq.add(arr[i]);
        // }

        // System.out.println(pq.element()); //getMin()
        // while(!pq.isEmpty()){
        //     System.out.print(pq.remove() + " ");
        // }

        // k sorted
        int arr[] = {2,4,1,9,6,8};
        int k = 3;
        sortKSorted(arr, k);
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
        ArrayList<Integer> klargest = kLargest(arr, k);
        for(int i=0; i< klargest.size(); i++){
            System.out.print(klargest.get(i) + " ");
        }


    }

    
}
