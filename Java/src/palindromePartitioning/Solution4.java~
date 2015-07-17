package palindromePartitioning;
import java.util.LinkedList;
import java.util.List;

/** This is the solution for the palindrome partitioning 
  * from the "Leetcode-cpp.pdf" Solution 2.
  * This solution is more concise than the version 1,
  * such style is also shown in problem "Combination Sum".
  * Time complexity is O(2^n), and space complexity is 
  * O(n). */

public class Solution4 {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return null;
        List<List<String>> result = new LinkedList<List<String>>();
        List<String> path = new LinkedList<String>();
        char [] str = s.toCharArray();
        dfs(str, result, path, 0);
        return result;
    }

    private void dfs(char [] str, List<List<String>> result, List<String> path,
            int start) {
        if (start == str.length) {
            return;
        }

        for (int i = start; i == str.length; i++) {
            if (isPalindrome(str, start, i)) {
                path.add(new String(str, start, i - start));
                dfs(str, result, path, i);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(char [] str, int start, int end) {
        while (start < end && str[start] == str[end - 1]) {
                start++;
                end--;
        }

        return start >= end;
    }
}
