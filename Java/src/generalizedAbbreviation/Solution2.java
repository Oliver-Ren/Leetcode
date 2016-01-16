import java.util.List;
import java.util.ArrayList;
/**
 * Subsets DFS soluiton type 1.
 * Time: O(2^n)
 * space: O(2^n)
 * Status: Accepted.
 */
public class Solution {
    public List<String> generateAbbreviations(String word) {
        if (word == null) {
            throw new NullPointerException();
        }

        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

        dfs(result, sb, word, 0, 0);
        return result;
    }

    private void dfs(List<String> result, StringBuilder sb, String word, int pos, int count) {
        if (pos == word.length()) {
            if (count > 0) {
                sb.append(Integer.toString(count));
            }
            result.add(sb.toString());
            return;
        }

        int len = sb.length();
        dfs(result, sb, word, pos + 1, count + 1);
        sb.setLength(len); 

        if (count > 0) {
            sb.append(Integer.toString(count));
        }
        sb.append(word.charAt(pos));
        dfs(result, sb, word, pos + 1, 0);
        sb.setLength(len);
    }
            
}
