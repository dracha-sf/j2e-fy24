package bitmanipulationandgreedyassignmentquestions;
import java.util.*;
public class Problem10 
{
    public static long reverseBits(long A) 
    {
        long reversed = 0;
        int bitCount = 32; // 32 bits for a 32-bit unsigned integer

        for (int i = 0; i < bitCount; i++) 
        {
            reversed <<= 1; // Left shift reversed to make space for the next bit
            if ((A & 1) == 1) 
            {
                reversed |= 1; // Set the least significant bit of reversed if the current bit of A is 1
            }
            A >>= 1; // Right shift A to move to the next bit
        }

        return reversed;
    }

    public static void main(String[] args) 
    {
        long A1 = 0;
        long reversed1 = reverseBits(A1);
        System.out.println(reversed1); // Output: 0

        long A2 = 3;
        long reversed2 = reverseBits(A2);
        System.out.println(reversed2); // Output: 3221225472
    }
}
