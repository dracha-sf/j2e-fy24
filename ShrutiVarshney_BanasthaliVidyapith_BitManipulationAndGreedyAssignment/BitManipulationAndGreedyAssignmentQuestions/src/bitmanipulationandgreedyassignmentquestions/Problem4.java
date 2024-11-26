package bitmanipulationandgreedyassignmentquestions;
import java.util.*;
public class Problem4 
{
    public static int minPillsToSurvive(int[] a, int n, int v) {
        int minPills = 0; // Minimum number of pills needed
        int health = v; // Current health

        for (int i = 0; i < n; i++) 
        {
            // If the current health is already sufficient to survive the remaining days, break out of the loop
            if (health > n - i)
                break;

            // If the current health is less than the current pill's characteristic value, consume the pill
            if (health <= a[i]) 
            {
                minPills += 1; // Increase the minimum pill count
                health += a[i]; // Increase the health by consuming the pill
            }
            else
                health--;
        }

        return minPills;
    }

    public static void main(String[] args) 
    {
        int[] a1 = {1, 1, 1, 1, 1};
        int n1 = 5;
        int v1 = 1;
        int result1 = minPillsToSurvive(a1, n1, v1);
        System.out.println("Minimum pills needed to survive: " + result1); // Output: 3

        int[] a2 = {1, 3, 1, 1, 3};
        int n2 = 5;
        int v2 = 2;
        int result2 = minPillsToSurvive(a2, n2, v2);
        System.out.println("Minimum pills needed to survive: " + result2); // Output: 1
    }
}