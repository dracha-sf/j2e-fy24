package recursionassignmentquestions;
import java.util.*;
public class Problem7 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of items:");
        int N=sc.nextInt();// Number of items
        System.out.println("Enter the capacity of bags:");
        int W = sc.nextInt(); // Capacity of the bag
        int[] profit = new int[N]; // Profits of the items
        int[] weight = new int[N]; // Weights of the items
        System.out.println("Enter the profits:");
        for(int i=0;i<N;i++)
        {
            profit[i]=sc.nextInt();
        }
        
        System.out.println("Enter the weights:");
        for(int i=0;i<N;i++)
        {
            weight[i]=sc.nextInt();
        }

        int maxProfit = knapsack(N, W, profit, weight);
        System.out.println("Maximum Profit: " + maxProfit);
    }

    public static int knapsack(int N, int W, int[] profit, int[] weight) 
    {
        return knapsackHelper(N, W, profit, weight, 0);
    }

    public static int knapsackHelper(int N, int W, int[] profit, int[] weight, int currentIndex) 
    {
        // Base case: If we have considered all the items or the bag capacity is 0
        if (currentIndex >= N || W == 0) 
        {
            return 0;
        }

        // If the weight of the current item is more than the remaining bag capacity, skip the item
        if (weight[currentIndex] > W) 
        {
            return knapsackHelper(N, W, profit, weight, currentIndex + 1);
        }

        // Recursive calls:
        // 1. Include the current item and subtract its weight from the remaining bag capacity
        int includeCurrent = profit[currentIndex] + knapsackHelper(N, W - weight[currentIndex], profit, weight, currentIndex + 1);

        // 2. Exclude the current item and consider the remaining items
        int excludeCurrent = knapsackHelper(N, W, profit, weight, currentIndex + 1);

        // Return the maximum of the two choices
        return Math.max(includeCurrent, excludeCurrent);
    }
}
