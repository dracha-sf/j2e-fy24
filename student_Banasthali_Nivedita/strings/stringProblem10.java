/*
Given word, return the next alphabetically greater string in all permutations of that word. If there is no greater permutation,
return the string 'no answer' instead.
 */
package salesforce;

/**
 *
 * @author hp
 */
public class stringProblem10 {
    public static String nextPermutation(String s) {
        char[] charr = s.toCharArray();
        
        // Find the largest index i such that arr[i] < arr[i+1]
        int i = charr.length - 2;
        while (i >= 0 && charr[i] >= charr[i + 1]) {
            i--;
        }
        
        // If no such index exists, it means the word is already the greatest permutation
        if (i < 0) {
            return "no answer";
        }
        
        // Find the largest index j such that arr[j] > arr[i]
        int j = charr.length - 1;
        while (charr[j] <= charr[i]) {
            j--;
        }
        
        // Swap arr[i] and arr[j]
        char temp = charr[i];
        charr[i] = charr[j];
        charr[j] = temp;
        
        // Reverse the suffix starting from index i+1
        int left = i + 1;
        int right = charr.length - 1;
        while (left < right) {
            temp = charr[left];
            charr[left] = charr[right];
            charr[right] = temp;
            left++;
            right--;
        }
        
        return new String(charr);
    }
    
    public static void main(String[] args) {
        String s = "baca";
        String permutation = nextPermutation(s);
        System.out.println(permutation);
    }
}

