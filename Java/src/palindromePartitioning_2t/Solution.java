import java.util.*;
/** The DFS solution.
  * time complexity: O(2^n) in the worst case.
  * space complexity: O(n).
  * Status: 312ms.
  */ 

public class Solution {
    public List<List<String>> partitioning(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        char[] str = s.toCharArray();
        dfs(str, -1, 0, result, path); 
        return result;
    }

    private void dfs(char[] str, int partition, int step, List<List<String>> result, List<String> path ) {
        if (step == str.length) {
            if (partition == str.length - 1) {
                result.add(new ArrayList<String>(path));
            }
            return;
        }

        dfs(str, partition, step + 1, result, path);

        if (isPalindrome(str, partition + 1, step)) {
            String s = new String(str, partition + 1, step - partition);
            path.add(s);
            dfs(str, step, step + 1, result, path);
            path.remove(path.size() - 1);
        }
    }


    private boolean isPalindrome(char[] str, int start, int end) {

        for (int i = 0; i <= (end - start) / 2; i++) {
            if (str[start + i] != str[end - i]) {
                
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        List<List<String>> result = test.partitioning("aba");
        for (List<String> l : result) {
            for (String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    }
}
