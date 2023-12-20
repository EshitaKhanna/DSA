package DSA.Queue;

public class QueueUsingArray {
    private int[] data;
    private int front; //insertion at rear end
    private int rear;
    private int size;

    public QueueUsingArray(){
        data = new int[10];
        front = -1;
        rear = -1;
        size = 0;
    }

    public QueueUsingArray(int capacity){
        data = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return (size == 0);
    }
    
    public int front() throws QueueEmptyException{
        if(size == 0){
            throw new QueueEmptyException();
        }
        return data[front];
    }
    
    public void enqueue(int ele) throws QueueFullException{
        if(size == data.length){
            //throw new QueueFullException();
            doubleCapacity();
        }

        rear++;
        if(size == 0){
            front++;
        }
        data[rear] = ele;
        size++; 

    }
    
    private void doubleCapacity() {
        int[] temp = data;
        data = new int[2*data.length];
        int index = 0;

        for(int i= front; i<temp.length; i++){
            data[index] = temp[i];
            index ++;
        }

        for(int i=0; i<=front-1; i++){
            data[index] = temp[i];
            index ++;
        }
    }

    public int dequeue() throws QueueEmptyException{
        if(size == 0){
            throw new QueueEmptyException();
        }
        int temp = data[front];
        front++;
        size--;

        if(size == 0){
            front = -1;
            rear = -1;  
        }
        return temp;
    }


    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray();

        for(int i=1; i<=5; i++){
            try {
                queue.enqueue(i);
            } catch (QueueFullException e) {
                
            }
        }

        while (!queue.isEmpty()) {
            try {
                System.out.println(queue.dequeue());
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
    }


}
