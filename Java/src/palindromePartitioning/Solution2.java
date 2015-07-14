package palindromePartitioning;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return null;
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> cand = new ArrayList<String>();
        char [] str = s.toCharArray();
        dfs(str, result, cand, 0, 0);
        return result;
    }

    private void dfs(char [] str, List<List<String>> result, 
            List<String> cand, int start, int end) {
    
        if (end - start > 0) {
            cand.add(new String(str, start, end - start));
        }

        if (end == str.length) {
            result.add(new ArrayList<String>(cand));
            return;
        }

        int newStart = end;

        for (int newEnd = newStart + 1; newEnd <= str.length; newEnd++) {
            if (!isPalindrom(str, newStart, newEnd)) {
                continue;
            }
            dfs(str, result, cand, newStart, newEnd);
            cand.remove(cand.size() - 1);
           
        }

    }  

    /* check if the subarray of index [start, end) is palindrome. */
    private boolean isPalindrom(char [] str, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            if (str[start + i] != str[end - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
        
