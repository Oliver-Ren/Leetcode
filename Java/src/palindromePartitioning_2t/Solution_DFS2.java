import java.util.*;

/** accpetd, 324ms.
  */
public class Solution_DFS2 {
    public List<List<String>> partitioning(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        char[] str = s.toCharArray();
        dfs(str, 0, result, path);
        return result;
    }

    private void dfs(char[] str, int currPos, List<List<String>> result
            , List<String> path) {
        if (currPos == str.length) {
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int i = currPos + 1; i <= str.length; i++) {
            if (isPalindrome(str, currPos, i)) {
                path.add(new String(str, currPos, i - currPos));
                dfs(str, i, result, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(char[] str, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            if (str[start + i] != str[end - 1 -i]) {
                return false;
            }
        }
        return true;
    }
}
    
