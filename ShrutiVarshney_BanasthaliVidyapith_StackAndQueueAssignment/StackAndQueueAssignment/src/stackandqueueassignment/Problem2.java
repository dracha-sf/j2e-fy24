package stackandqueueassignment;
import java.util.*;
public class Problem2 
{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    // Function to push an element into the queue
    void push(int x) 
    {
        s1.push(x);
    }
    
    // Function to remove an element from the queue
    int pop() 
    {
        if (s1.isEmpty() && s2.isEmpty())
            return -1; // Queue is empty
        
        if (s2.isEmpty()) 
        {
            // Move all elements from s1 to s2 in reverse order
            while (!s1.isEmpty()) 
            {
                s2.push(s1.pop());
            }
        }
        
        // Pop the top element from s2 (which is the front of the queue)
        return s2.pop();
    }
    public static void main(String[] args) 
    {
        Problem2 queue = new Problem2();
        
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop()); // Output: 2
        
        queue.push(4);
        System.out.println(queue.pop()); // Output: 3
    }
}

