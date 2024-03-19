package DSA.PriorityQueues;

import java.util.ArrayList;

public class Max_Priority_Queue {
    private ArrayList<Integer> heap;

    public Max_Priority_Queue(){
        heap = new ArrayList<>();
    }

    public boolean isEmpty(){
        return heap.size() == 0;
    }

    public int size(){
        return heap.size();
    }

    int getMax() throws PQ_Exception{
        if(heap.isEmpty())
            throw new PQ_Exception();
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1) /2;

        while(parentIndex>=0){
            if(heap.get(childIndex) > heap.get(parentIndex)){
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);

                childIndex = parentIndex;
                parentIndex =( childIndex-1)/2;

            }
            else{
                return;
            }
        }
    }

    int removeMax() throws PQ_Exception{
        if(heap.isEmpty()){
            throw new PQ_Exception();
        }

        int maxEle = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));

        // down - heapify 
        int parentIndex=0;
        int maxIndex = parentIndex;
        int leftChildIndex = 2*parentIndex + 1;
        int  rightChildIndex= 2*parentIndex + 2;

        while(leftChildIndex < heap.size()){
            if(heap.get(maxIndex)<heap.get(leftChildIndex)){
                maxIndex=leftChildIndex;
            }
            if(rightChildIndex<heap.size()){
                if(heap.get(maxIndex)<heap.get(rightChildIndex)){
                	maxIndex=rightChildIndex;
            	}
            }
            if(maxIndex == parentIndex){
                return maxEle;
            }

            int temp=heap.get(maxIndex);
            heap.set(maxIndex,heap.get(parentIndex));
            heap.set(parentIndex,temp);
            
            parentIndex=maxIndex;
            leftChildIndex=2*parentIndex+1;
            rightChildIndex=2*parentIndex+2;
        }
        return maxEle;

    }

    public static void main(String[] args) {
        
    }

}

