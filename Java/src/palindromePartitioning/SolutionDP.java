package palindromePartitioning;
import java.util.ArrayList;
import java.util.List;

/** This is the dynamic programming approach for the
  * padlindrome partitioning problem.
  * from the "Leetcode-cpp.pdf" Solution 3.
  * Time complexity is O(2^n), and space complexity is 
  * O(1). 
  * Status: Not Finished.
  */

public class SolutionDP {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return null;
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        


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
    

        
