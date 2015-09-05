import java.util.*;
/**
 * The DFS solution for the problem.
 * the table is stored using an array
 * of Strings.
 * 
 * Time complexity: O(3 ^ n)
 * Space compleity: O(n)
 * Status: accepted, 244ms;
 */

public class Solution_DFS {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();

        // Handing illegal inputs.
        // Be careful not to use "==" to compare two strings.
        if (digits == null || digits.equals("")) {
            return result;
        }

        String[] letterTable = {" ", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};
        char[] digs = digits.toCharArray();
        StringBuilder cand = new StringBuilder();
        dfs(result, digs, cand, 0, letterTable);
        return result;
    }

    public void dfs(List<String> result, char[] digs, StringBuilder cand,
            int digitPos, String[] letterTable) {
        if (digitPos == digs.length) {
            result.add(cand.toString());
            return;
        }

        for (int i = 0; i < letterTable[digs[digitPos] - '0'].length(); i++) {
            cand.append(letterTable[digs[digitPos] - '0'].charAt(i));
            dfs(result, digs, cand, digitPos + 1, letterTable);
            cand.deleteCharAt(cand.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_DFS test = new Solution_DFS();
        List<String> result = test.letterCombinations("23");
        for (String s : result) {
            System.out.println(s);
        }
    }



}
