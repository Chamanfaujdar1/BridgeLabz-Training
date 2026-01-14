import java.util.*;

public class ImplementationOfQueueUsingStacks {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public ImplementationOfQueueUsingStacks(){
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void enqueue(int x){
        stackIn.push(x);
    }

    public int dequeue(){
        fillStackOut();
        if(stackOut.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }

        return stackOut.pop();
    }

    public int peek(){
        fillStackOut();
        if(stackOut.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }

        return stackOut.peek();
    }

    public boolean isEmpty(){
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void fillStackOut(){
        if(stackOut.isEmpty()){
            while(!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
    }

    public static void main(String[] args){
        ImplementationOfQueueUsingStacks q = new ImplementationOfQueueUsingStacks();
        q.enqueue(20);
        q.enqueue(15);
        System.out.println(q.dequeue());
        q.enqueue(10);
        System.out.println(q.peek());
    }
}
