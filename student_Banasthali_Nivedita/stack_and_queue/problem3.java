/*
GIVEN AN ARRAY ARR[] OF SIZE N AND AN INTEGER K. FIND THE MAXIMUM FOR EACH AND EVERY
CONTIGUOUS SUBARRAY OF SIZE K.
 */
package salesforce.stack_and_queue;
import java.util.*;

public class problem3 {
    static void max_of_subarray(int[] arr, int n, int k) {
        Deque<Integer> max_queue = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++) {
            // Remove elements smaller than the current element from the deque
            while (!max_queue.isEmpty() && arr[i] >= arr[max_queue.peekLast()]) {
                max_queue.removeLast();
            }
            max_queue.addLast(i);
        }

        // Process the remaining elements
        for (; i < n; i++) {
            // The front element of the deque is the maximum for the previous window
            System.out.print(arr[max_queue.peekFirst()] + " ");

            // Remove elements outside the current window
            while (!max_queue.isEmpty() && max_queue.peekFirst() <= i - k) {
                max_queue.removeFirst();
            }

            // Remove elements smaller than the current element from the deque
            while (!max_queue.isEmpty() && arr[i] >= arr[max_queue.peekLast()]) {
                max_queue.removeLast();
            }

            max_queue.addLast(i);
        }

        // Print the maximum for the last window
        System.out.print(arr[max_queue.peekFirst()]);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {8,5,10,7,9,4,15,12,90,13};
        int n = 10;
        int k = 4;
        max_of_subarray(arr, n, k);
    }
}
