/*
8. Given a string s, partition s such that every string of the partition is a palindrome. Return all
possible palindrome partitioning of s.
*/
class Solution {
public List<List<String>> partition(String s) {
List<List<String>> result = new ArrayList<>();
partitionHelper(s, 0, new ArrayList<>(), result);
return result;
}
private static void partitionHelper(String s, int start, List<String>
current, List<List<String>> result) {
if (start == s.length()) {
result.add(new ArrayList<>(current));
return;
}
for (int i = start; i < s.length(); i++) {
if (isPalindrome(s, start, i)) {
current.add(s.substring(start, i + 1));
partitionHelper(s, i + 1, current, result);
current.remove(current.size() - 1);
}
}
}
private static boolean isPalindrome(String s, int start, int end) {
while (start < end) {
if (s.charAt(start) != s.charAt(end)) {
return false;
}
start++;
end--;
}
return true;
}
}