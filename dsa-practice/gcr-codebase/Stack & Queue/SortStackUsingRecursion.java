import java.util.*;

public class SortStackUsingRecursion {
    public static void sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int temp = stack.pop();
            sortStack(stack);
            sortedInsert(stack, temp);
        }
    }

    public static void sortedInsert(Stack<Integer> stack, int element){
        if(stack.isEmpty() || element > stack.peek()){
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        sortedInsert(stack, element);
        stack.push(temp); 
    }

    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(50);
        s.push(-20);
        s.push(10);
        s.push(90);
        s.push(5);
        System.out.println("Original Stack: " + s);
        sortStack(s);
        System.out.println("Stack After Sorting: " + s);

    }
}
