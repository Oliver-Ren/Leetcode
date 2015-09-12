import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n < 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, sb, result);
        return result;
    }

    private void dfs(int n, int rNeed, StringBuilder sb, List<String> result) {
        if (n == 0 && rNeed == 0) {
            result.add(sb.toString());
            return;
        }

        if (n > 0) {
            sb.append('(');
            dfs(n - 1, rNeed + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);

        }

        if (rNeed > 0) {
            sb.append(')');
            dfs(n, rNeed - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

