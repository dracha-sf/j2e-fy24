package bitmanipulationandgreedyassignmentquestions;
import java.util.*;
public class Problem7 
{
    public static int findMinXOR(int[] A) 
    {
        Arrays.sort(A);
        int minXOR = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) 
        {
            minXOR = Math.min(minXOR, A[i] ^ A[i + 1]);
        }
        return minXOR;
    }

    public static void main(String[] args) 
    {
        int[] A1 = {0, 2, 5, 7};
        int minXOR1 = findMinXOR(A1);
        System.out.println(minXOR1); // Output: 2

        int[] A2 = {0, 4, 7, 9};
        int minXOR2 = findMinXOR(A2);
        System.out.println(minXOR2); // Output: 3
    }
}
