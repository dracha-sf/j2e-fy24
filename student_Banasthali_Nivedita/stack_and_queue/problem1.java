/*
IMPLEMENT A STACK USING TWO QUEUES Q1 AND Q2.
 */
package salesforce.stack_and_queue;
import java.util.*;

public class problem1 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Function to push an element to the stack
    void push(int x) {
        // Add the new element to q2
        q2.add(x);

        // Push all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Function to remove the topmost element from the stack
    int pop() {
        // If q1 is empty, the stack is empty
        if (q1.isEmpty()) {
            return -1; // or throw an exception
        }

        // Remove and return the front element of q1
        return q1.peek();
    }

    public static void main(String[] args) {
        problem1 stack = new problem1();
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Output: 3
        stack.push(4);
        System.out.println(stack.pop()); // Output: 4
    }
}
