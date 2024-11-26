package stringassignmentquestions;
import java.util.*;
import java.io.*;
public class Problem10 
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("enter the word:");
        String word = br.readLine();
        String nextPermutation = findNextPermutation(word);
        System.out.println(nextPermutation);
    }

    public static String findNextPermutation(String word) 
    {
        char[] charArray = word.toCharArray();
        int n = charArray.length;

        // Find the largest index k such that charArray[k] < charArray[k+1]
        int k = n - 2;
        while (k >= 0 && charArray[k] >= charArray[k + 1]) 
        {
            k--;
        }

        if (k < 0) 
        {
            // The word is already the last permutation, so return "no answer"
            return "no answer";
        }

        // Find the largest index l such that charArray[l] > charArray[k]
        int l = n - 1;
        while (l > k && charArray[l] <= charArray[k]) 
        {
            l--;
        }

        // Swap charArray[k] and charArray[l]
        char temp = charArray[k];
        charArray[k] = charArray[l];
        charArray[l] = temp;

        // Reverse the suffix starting from k+1
        reverse(charArray, k + 1, n - 1);

        return new String(charArray);
    }

    public static void reverse(char[] arr, int start, int end) 
    {
        while (start < end) 
        {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
