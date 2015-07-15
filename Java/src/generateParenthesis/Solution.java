import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return null;
        List<String> result = new ArrayList<String>();
        int[] parenCount = {n - 1, n};
        StringBuilder str = new StringBuilder();
        str.append('(');
        dfs(n, parenCount, str, result, '(');
        return result;
    }

    private void dfs(int n, int[] parenCount, 
            StringBuilder str, List<String> result, char paren) {
        if (paren == ')') {
            if (parenCount[0] >= n || parenCount[0] > parenCount[1]) {
                return;
            }         
        }

        if (parenCount[0] == 0 && parenCount[1] == 0) {
            result.add(str.toString());
        }


        if (parenCount[0] > 0) {
            str.append('(');
            parenCount[0]--;
            dfs(n, parenCount, str, result, '(');
            str.deleteCharAt(str.length() - 1);
            parenCount[0]++;
        }

        if (parenCount[1] > 0) {
            str.append(')');
            parenCount[1]--;
            dfs(n, parenCount, str, result, ')');
            str.deleteCharAt(str.length() - 1);
            parenCount[1]++;
        }
    }

    public static void main(String [] args) {
        Solution test = new Solution();
        List<String> li = test.generateParenthesis(2);
        for (String s : li) {
            System.out.println(s);
        }
    }
}

