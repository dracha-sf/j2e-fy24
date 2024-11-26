package stackandqueueassignment;
import java.util.*;
public class Problem1 
{
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    
    // Function to push an element into the stack
    void push(int x) 
    {
        q1.add(x);
    }
    
    // Function to remove an element from the stack
    int pop() 
    {
        if (q1.isEmpty())
            return -1; // Stack is empty
        
        // Move all elements except the last one from q1 to q2
        while (q1.size() > 1) 
        {
            q2.add(q1.remove());
        }
        
        // Pop the last element from q1 (which is the top of the stack)
        int poppedElement = q1.remove();
        
        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        return poppedElement;
    }
    public static void main(String[] args) 
    {
        Problem1 stack = new Problem1();
        
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Output: 3
        
        stack.push(4);
        System.out.println(stack.pop()); // Output: 4
    }
}