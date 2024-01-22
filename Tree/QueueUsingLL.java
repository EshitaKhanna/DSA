package DSA.Tree;

public class QueueUsingLL <T>{
    private Node<T> front;
    private Node<T> rear;
    int size;

    QueueUsingLL(){
        front  = null;
        rear = null;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return (size == 0);
    }

    T front() throws QueueEmptyException{
        if(size == 0){
            throw new QueueEmptyException();
        }
        return front.data;
    }

    void enqueue(T ele){
        Node<T> newNode = new Node<>(ele);

        if(size == 0){
            rear = newNode;
            front = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    T dequeue() throws QueueEmptyException{
        if(size == 0){
            throw new QueueEmptyException();
        }

        T temp = front.data;
        front = front.next;
        if(size == 1){
            rear = null;
        }

        size --;

        return temp;
    }

    public static void main(String[] args) {
        QueueUsingLL<Integer> queue = new QueueUsingLL<>();

        for(int i=1; i<=5; i++){
            queue.enqueue(i);
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
