package DSA.PriorityQueues;

import java.util.ArrayList;

public class Min_Priority_Queue {
    private ArrayList<Integer> heap;

    public Min_Priority_Queue(){
        heap = new ArrayList<>();
    }

    public boolean isEmpty(){
        return heap.size() == 0;
    }

    public int size(){
        return heap.size();
    }

    //Min Heap

    int getMin() throws PQ_Exception{
        if(isEmpty()){
            throw new PQ_Exception();
        }
        return heap.get(0);
    }

    void insert(int element){
        heap.add(element);
        // up-heapify after inserting
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex -1 )/2;

        while(childIndex > 0){
            if(heap.get(childIndex) < heap.get(parentIndex)){
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);

                childIndex = parentIndex;
                parentIndex = (childIndex -1 )/2;
            }else{
                return;
            }
        }
    }

    int removeMin() throws PQ_Exception{
        if(isEmpty()){
			throw new PQ_Exception();
		}

        int minEle = getMin();
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        //down - heapify after deleting

        int parentIndex = 0 ;
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;
        int minIndex = parentIndex;

        while(leftChildIndex < heap.size()){
            if(heap.get(leftChildIndex) < heap.get(minIndex)){
                minIndex = leftChildIndex;
            }
            if(rightChildIndex <  heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)){
                minIndex = rightChildIndex;
            }

            if(minIndex == parentIndex){
                break;
            }else{
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(minIndex));
                heap.set(minIndex, temp);

                parentIndex = minIndex;
                leftChildIndex = 2*parentIndex + 1;
                rightChildIndex = 2*parentIndex + 2;

            }
        }
        return minEle;

    }
}
