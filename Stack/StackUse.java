package DSA.Stack;

public class StackUse {

    private int data[];
    private int top;

    public StackUse(){
        data = new int[10];
        top = -1;
    }
    public StackUse(int capacity){
        data = new int[capacity];
        top = -1;
    }

    public void push(int ele) throws StackFullException{
        if(isFull() ){
            //StackFullException e = new StackFullException();
            //throw e;
            doubleCapacity();
        }else{
            top ++;
            data[top] = ele;
        }
    }

    private void doubleCapacity(){
        int []temp = data;
        data = new int[2* data.length];
        for(int i=0; i<=top; i++){
                data[i] = temp[i];
        }
    }

    public int pop() throws StackEmptyException{
        if(isEmpty()){
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        int temp = data[top];
        top--;

        return temp;
    }

    public int size(){
        return (top +1) ;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (size() == data.length);
    }

    public int peek() throws StackEmptyException{

        if(top == -1){
            //Exception
            StackEmptyException e = new StackEmptyException();
            throw e;
        }

        return data[top];
    }

    public static void main(String[] args) throws StackFullException {
        StackUse s = new StackUse();

        for(int i=0; i<= 5; i++){
            s.push(i);
        }

        while(!s.isEmpty()){
            try{
                System.out.println(s.pop());
            }
            catch(StackEmptyException e){
                e.printStackTrace();
            }
        }

    }
}
