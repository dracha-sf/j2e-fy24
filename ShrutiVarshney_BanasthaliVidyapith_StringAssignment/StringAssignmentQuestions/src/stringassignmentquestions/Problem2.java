package stringassignmentquestions;
import java.util.*;
public class Problem2 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string containing binary numbers only:");
        String inputStr = sc.next();
        int minPackets = findMinPackets(inputStr);
        System.out.println(minPackets);
    }

    public static int findMinPackets(String str) 
    {
        int count = 0;
        for (int i = 1; i < str.length(); i++) 
        {
            if (str.charAt(i) != str.charAt(i - 1)) 
            {
                count++;
            }
        }
        return count + 1;
    }
}
