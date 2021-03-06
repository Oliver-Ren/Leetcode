package palindromePartitioning;
import java.util.ArrayList;
import java.util.List;

public class Solution {
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
        if (!isPalindrom(str, start, end)) {
            return;
        }

        if (end == str.length) {
            result.add(new ArrayList<String>(cand));
            return;
        }

        int newStart = end;
        int newEnd = newStart + 1;

        while (newEnd <= str.length) {
            dfs(str, result, cand, newStart, newEnd);
            cand.remove(cand.size() - 1);
            newEnd++;
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
        
