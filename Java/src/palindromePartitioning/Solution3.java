package palindromePartitioning;
import java.util.ArrayList;
import java.util.List;

/** This is the solution for the palindrome partitioning 
  * from the "Leetcode-cpp.pdf" Solution 1.
  * Time complexity is O(2^n), and space complexity is 
  * O(n). */

public class Solution3 {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return null;
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        char [] str = s.toCharArray();
        dfs(str, result, path, 0, 1);
        return result;
    }

    private void dfs(char [] str, List<List<String>> result, List<String> path,
            int left, int right) {
       if (right == str.length) {
           if (isPalindrome(str, left, right)) {
               path.add(new String(str, left, right - left));
               result.add(new ArrayList<String>(path));
               path.remove(path.size() - 1);
           }
           return;
       }

       /* do not partition. This is always a solution when 
        * right pointer does not reach the end. */
       dfs(str, result, path, left, right + 1);

       /* when the prefix is already a palindrome, we could 
        * make a partiion here. */
       if (isPalindrome(str, left, right)) {
           path.add(new String(str, left, right - left));
           dfs(str, result, path, right, right + 1);
           path.remove(path.size() - 1);
       }
    }

       


    /* check if the string is palindrome, the range is [left, right)
     * where the left is inclusive and the right is exclusive. */
    private boolean isPalindrome(char [] str, int left, int right) {
        while (left < right && str[left] == str[right - 1]) {
            left++;
            right--;
        }

        return left >= right;
    }
}
    

        
