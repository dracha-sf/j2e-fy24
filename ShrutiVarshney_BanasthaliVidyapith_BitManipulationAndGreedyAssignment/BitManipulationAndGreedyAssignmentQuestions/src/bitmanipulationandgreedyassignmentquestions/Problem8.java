package bitmanipulationandgreedyassignmentquestions;
import java.util.*;
public class Problem8 
{
    public static int findSingleInteger(int[] A) 
    {
        int singleInteger = 0;
        for (int num : A) 
        {
            singleInteger ^= num;
        }
        return singleInteger;
    }

    public static void main(String[] args) 
    {
        int[] A1 = {1, 2, 2, 3, 1};
        int singleInteger1 = findSingleInteger(A1);
        System.out.println(singleInteger1); // Output: 3

        int[] A2 = {1, 2, 2};
        int singleInteger2 = findSingleInteger(A2);
        System.out.println(singleInteger2); // Output: 1
    }
}
