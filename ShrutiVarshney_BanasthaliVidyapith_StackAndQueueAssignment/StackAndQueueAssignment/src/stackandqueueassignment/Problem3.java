package stackandqueueassignment;
import java.util.*;
public class Problem3 
{
    public static ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        
        // Process the first k elements separately
        for (int i = 0; i < k; i++) {
            // Remove all elements smaller than the current element
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) 
            {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        
        // Process the remaining elements
        for (int i = k; i < n; i++) 
        {
            // The front of the deque contains the maximum element for the previous window
            result.add(arr[deque.peekFirst()]);
            
            // Remove elements that are outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k)
            {
                deque.removeFirst();
            }
            
            // Remove all elements smaller than the current element
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) 
            {
                deque.removeLast();
            }
            
            deque.addLast(i);
        }
        
        // Add the maximum element for the last window
        result.add(arr[deque.peekFirst()]);
        
        return result;
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n=sc.nextInt();
        System.out.println("Enter the array");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter the size of subarrays:");
        int k=sc.nextInt();
        ArrayList<Integer> result = Problem3.max_of_subarrays(arr, n, k);
        System.out.println(result);
    }
}
