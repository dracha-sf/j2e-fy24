package graphsassignmentquestions;
import java.util.*;
import javafx.util.Pair;
public class Problem2 
{
    public static int minimumSwaps(int[] arr) {
        int n = arr.length;
        int swaps = 0;

        // Create a copy of the array and sort it to get the correct order
        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);

        // Create a map of element to index for quick access
        Map<Integer, Integer> elementToIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            elementToIndexMap.put(arr[i], i);
        }

        // Iterate through the array to find cycles and count the swaps
        for (int i = 0; i < n; i++) {
            // Check if the element is already in its correct position
            if (arr[i] != sortedArr[i]) {
                swaps++;

                // Swap the elements to bring the current element to its correct position
                int currentElement = arr[i];
                int correctPosition = elementToIndexMap.get(sortedArr[i]);
                arr[i] = arr[correctPosition];
                arr[correctPosition] = currentElement;

                // Update the element's index in the map
                elementToIndexMap.put(currentElement, correctPosition);
            }
        }

        return swaps;
    }

    public static void main(String[] args) 
    {
        int[] arr = {5, 3, 8, 6, 7};
        int minSwaps = minimumSwaps(arr);
        System.out.println(minSwaps);  // Output: 2
    }
}
