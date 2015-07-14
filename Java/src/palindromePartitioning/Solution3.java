package palindromePartitioning;
import java.util.ArrayList;
import java.util.List;

/** This is the solution for the palindrome partitioning 
  * from the "Leetcode-cpp.pdf" Solution 1.
  * Time complexity is O(2^n), and space complexity is 
  * O(n). */

public class Solution3 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        dfs(result, path, 0, 1);
        return result;
    }

    private boolean isPalindrom
        
