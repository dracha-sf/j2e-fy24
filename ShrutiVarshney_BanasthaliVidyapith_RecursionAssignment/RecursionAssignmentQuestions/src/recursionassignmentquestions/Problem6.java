package recursionassignmentquestions;
import java.util.*;
public class Problem6 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the set:");
        int n=sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the set:");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print("Subset Sums: ");
        printSubsetSums(arr);
    }

    public static void printSubsetSums(int[] arr) 
    {
        int n = arr.length;
        int sum = 0;
        subsetSumsHelper(arr, n, sum);
    }

    public static void subsetSumsHelper(int[] arr, int n, int sum) 
    {
        if (n == 0) 
        {
            System.out.print(sum + " ");
            return;
        }

        // Include the current element in the sum and recur for the remaining elements
        subsetSumsHelper(arr, n - 1, sum + arr[n - 1]);

        // Exclude the current element and recur for the remaining elements
        subsetSumsHelper(arr, n - 1, sum);
    }
}
