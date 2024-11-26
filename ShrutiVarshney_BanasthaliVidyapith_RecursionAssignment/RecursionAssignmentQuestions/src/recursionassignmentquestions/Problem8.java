package recursionassignmentquestions;
import java.util.*;
public class Problem8 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String s=sc.next();

        List<List<String>> result = partition(s);
        System.out.println("Palindrome Partitioning:");
        for (List<String> partition : result) 
        {
            System.out.println(partition);
        }
    }

    public static List<List<String>> partition(String s)
    {
        List<List<String>> result = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();

        partitionHelper(s, 0, currentPartition, result);

        return result;
    }

    public static void partitionHelper(String s, int start, List<String> currentPartition, List<List<String>> result) 
    {
        // Base case: If we have considered all characters in the string
        if (start >= s.length())
        {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        // Try all possible partitions starting from the current start index
        for (int end = start; end < s.length(); end++)
        {
            // Check if the substring from start to end is a palindrome
            if (isPalindrome(s, start, end))
            {
                // Add the palindrome substring to the current partition
                String palindromeSubstring = s.substring(start, end + 1);
                currentPartition.add(palindromeSubstring);

                // Recur for the remaining part of the string
                partitionHelper(s, end + 1, currentPartition, result);

                // Remove the last added palindrome substring for backtracking
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) 
    {
        while (start < end)
        {
            if (s.charAt(start) != s.charAt(end)) 
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
