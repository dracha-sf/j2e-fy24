package recursionassignmentquestions;
import java.util.*;
public class Problem1 
{
    public static void printAllStrings(char[] set, int k) 
    {
        int n = set.length;
        printAllStringsHelper(set, "", n, k);
    }

    private static void printAllStringsHelper(char[] set, String prefix, int n, int k)
    {
        if (k == 0) 
        {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < n; i++) 
        {
            String newPrefix = prefix + set[i];
            printAllStringsHelper(set, newPrefix, n, k - 1);
        }
    }

    public static void main(String[] args) 
    {
        char[] set1 = {'a', 'b'};
        int k1 = 3;

        System.out.println("Strings of length " + k1 + " from set:");
        printAllStrings(set1, k1);

        char[] set2 = {'a', 'b', 'c', 'd'};
        int k2 = 1;

        System.out.println("Strings of length " + k2 + " from set:");
        printAllStrings(set2, k2);
    }
}
