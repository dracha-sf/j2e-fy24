package recursionassignmentquestions;
import java.util.*;
public class Problem4 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of disks:");
        int n = sc.nextInt(); // Number of disks
        System.out.println("Enter the sourceRod:");
        int sourceRod = sc.nextInt(); // Source rod (initially containing all disks)
        System.out.println("Enter the destinationRod:");
        int destinationRod = sc.nextInt(); // Destination rod
        System.out.println("Enter the auxiliaryRod:");
        int auxiliaryRod = sc.nextInt(); // Auxiliary rod

        solveTowersOfHanoi(n, sourceRod, destinationRod, auxiliaryRod);
    }

    public static void solveTowersOfHanoi(int n, int sourceRod, int destinationRod, int auxiliaryRod) 
    {
        if (n == 1) 
        {
            System.out.println("Move disk from rod " + sourceRod + " to rod " + destinationRod);
            return;
        }

        solveTowersOfHanoi(n - 1, sourceRod, auxiliaryRod, destinationRod);
        System.out.println("Move disk from rod " + sourceRod + " to rod " + destinationRod);
        solveTowersOfHanoi(n - 1, auxiliaryRod, destinationRod, sourceRod);
    }
}
