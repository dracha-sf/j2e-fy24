/*
Given a string s, partition s such that every string of the partition is a palindrome. Return all possible palindrome partitioning
of s.
 */
package salesforce.recursion;
import java.util.*;


public class problem7 {
     public static List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        partitionRecr(s, 0, currentPartition, partitions);

        return partitions;
    }

    private static void partitionRecr(String s, int start, List<String> currentPartition, List<List<String>> partitions) {
        if (start == s.length()) {
            partitions.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (isPalindrome(substring)) {
                currentPartition.add(substring);
                partitionRecr(s, i + 1, currentPartition, partitions);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);

        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}
