package bitmanipulationandgreedyassignmentquestions;
import java.util.*;
public class Problem3 
{
   public static int minTotalCandies(int[] a) 
   {
        int n = a.length;
        
        // Sort the array in non-decreasing order
        Arrays.sort(a);
        
        // Calculate the minimum number of candies in a box
        int minCandies = a[0];
        
        // Calculate the minimum total number of candies to eat
        int eatenCandies = 0;
        for (int i = 0; i < n; i++) 
        {
            eatenCandies += a[i] - minCandies;
        }
        
        return eatenCandies;
    }
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of boxes
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) 
        {
            a[i] = scanner.nextInt(); // Quantity of candies in each box
        }
        
        int minCandies = minTotalCandies(a);
        System.out.println(minCandies);
    }
}
