/*
Print all possible strings of length k that can be formed from a set of n characters.
*/
package salesforce.recursion;
import java.util.*;

public class problem1 {
    public static void generateStr(char[] set, int k) {
        
        //length of set
        int n = set.length;
        
        //array to store the current string being formed
        char[] currentString = new char[k];
        
        //called on (set, currentString, start, end, index, k)
        generateStrRecursive(set, currentString, 0, n - 1, 0, k);
    }

    private static void generateStrRecursive(char[] set, char[] currentString, int start, int end, int index, int k) {
        if (index == k) {
            System.out.println(Arrays.toString(currentString));
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= k - index; i++) {
            currentString[index] = set[i];
            generateStrRecursive(set, currentString, i, end, index + 1, k);
        }
    }

    public static void main(String[] args) {
        char[] set = {'a', 'b','c','d'};
        int k = 1;
        generateStr(set, k);
    }
}

