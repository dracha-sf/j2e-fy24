package bitmanipulationandgreedyassignmentquestions;
import java.util.*;
public class Problem1 
{
    public static int countSlicingSteps(int[] A) 
    {
        Arrays.sort(A); // Sort the array in ascending order
        
        int steps = 1;
        int currentWeight = A[0];
        
        for (int i = 1; i < A.length; i++) 
        {
            if (A[i] != currentWeight) 
            {
                steps++;
                currentWeight = A[i];
            }
        }
        
        return steps;
    }
    
    public static void main(String[] args) 
    {
        int[] A1 = {3, 6, 7, 7};
        int steps1 = countSlicingSteps(A1);
        System.out.println("Example 1: " + steps1);
        
        int[] A2 = {20, 40, 30, 50, 40, 20};
        int steps2 = countSlicingSteps(A2);
        System.out.println("Example 2: " + steps2);
    }
}
