public class StackImplementation {
    static class Stack{
        private int[] arr;
        private int top;
        private int capacity;

        public Stack(int size){
            arr = new int[size];
            capacity = size;
            top = -1;
        }

        public void push(int x){
            if(isFull()){
                System.out.println("Stack is Overflow");
            }
            else{
                arr[++top] = x;
            }
        }

        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is underflow");
                return -1;
            }
            return arr[top--];
        }

        public int peek(){
            if(!isEmpty()){
                return arr[top];
            }
            else{
                System.out.println("Stack is empty");
                return -1;
            }
        }
        public int size(){
            return top+1;
        }

        public boolean isEmpty(){
            return top == -1;
        }

        public boolean isFull(){
            return top == capacity -1;
        }
    }

    public static void main(String[] args){
        Stack stack = new Stack(5);
        stack.push(15);
        stack.push(25);
        stack.push(10);

        System.out.println("Top element is:  " + stack.peek());
        System.out.println("Stack size is: " + stack.size());
        System.out.println("Popped element is: " + stack.pop()); 
        System.out.println("Stack empty status: " + stack.isEmpty());
    }
}
