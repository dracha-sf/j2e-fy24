package bitmanipulationandgreedyassignmentquestions;
import java.util.*;
public class Problem6 
{
    public static int findSingleNumber(int[] nums) 
    {
        int result = 0;
        for (int i = 0; i < 32; i++) 
        {
            int count = 0;
            for (int num : nums) 
            {
                // Count the number of elements with a set bit at the i-th position
                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }
            // If the count is not a multiple of 3, the single number has a set bit at the i-th position
            if (count % 3 != 0) 
            {
                result |= (1 << i);
            }
        }
        return result;
    }

    public static void main(String[] args) 
    {
        int[] nums1 = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        int singleNumber1 = findSingleNumber(nums1);
        System.out.println(singleNumber1); // Output: 4

        int[] nums2 = {0, 0, 0, 1};
        int singleNumber2 = findSingleNumber(nums2);
        System.out.println(singleNumber2); // Output: 1
    }
}
