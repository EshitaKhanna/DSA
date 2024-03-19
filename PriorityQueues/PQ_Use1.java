package DSA.PriorityQueues;

public class PQ_Use1 {
    public static void main(String[] args) throws PQ_Exception {
        Min_Priority_Queue pq = new Min_Priority_Queue();
        int arr[] = {5,1,9,2,0};
        for(int i=0; i<arr.length; i++){
            pq.insert(arr[i]);
        }
        while(!pq.isEmpty()){
            System.out.println(pq.removeMin() + " ");
        }
        System.out.println();
    }

}
