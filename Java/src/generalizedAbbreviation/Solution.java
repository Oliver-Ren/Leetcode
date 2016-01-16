import java.util.List;
import java.util.ArrayList;
/**
 * Solution with DFS + backtracking
 * time complexity: O(2^n)
 * space complexity: O(2^n)
 * Status: Accepted.
 */
public class Solution {
    public List<String> generateAbbreviations(String word) {
        // precondition: word is not null
        if (word == null) {
            throw new NullPointerException();
        }

        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfs(result, sb, word, 0, 0);
        return result;
    }

    private void dfs(List<String> result, StringBuilder sb,  String word, int pos, int prevCount) {
        if (pos == word.length()) {
            result.add(sb.toString());
            return;
        }
        
        int len = sb.length();

        if (prevCount == 0) {
            for (int i = pos + 1; i <= word.length(); i++) {
                sb.append(i - pos);
                dfs(result, sb, word, i, i - pos);
                sb.setLength(len);
            }
        }
        
        sb.append(word.charAt(pos));
        dfs(result, sb, word, pos + 1, 0);
        sb.setLength(len);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> result = s.generateAbbreviations("ab");
        for (String str : result) {
            System.out.println(str);
        }
    }
        
            
}
