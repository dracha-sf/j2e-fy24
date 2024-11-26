package bitmanipulationandgreedyassignmentquestions;
import java.util.*;
public class Problem9 
{
    public static int hammingDistance(int x, int y)
    {
        int xorResult = x ^ y;
        int distance = 0;
        while (xorResult != 0) 
        {
            if ((xorResult & 1) == 1) 
            {
                distance++;
            }
            xorResult >>= 1;
        }
        return distance;
    }

    public static void main(String[] args) 
    {
        int x1 = 1, y1 = 4;
        int distance1 = hammingDistance(x1, y1);
        System.out.println(distance1); // Output: 2

        int x2 = 3, y2 = 1;
        int distance2 = hammingDistance(x2, y2);
        System.out.println(distance2); // Output: 1
    }
}
