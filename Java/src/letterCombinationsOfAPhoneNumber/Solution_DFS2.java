import java.util.*;
/**
 * The DFS2 solution for the problem.
 * the table is stored using an array
 * of Strings.
 * 
 * Time complexity: O(3 ^ n)
 * Space compleity: O(3 ^ n)
 * Status: accepted, 256ms;
 */

public class Solution_DFS2 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();

        if (digits == null || digits.equals("")) {
            return result;
        }

        // Construct the table
        HashMap<Character, char[]> letterTable = new HashMap<Character, char[]>();
        letterTable.put('0', new char[] {' '});
        letterTable.put('1', new char[] {'\0'});
        letterTable.put('2', new char[] {'a', 'b', 'c'});
        letterTable.put('3', new char[] {'d', 'e', 'f'});
        letterTable.put('4', new char[] {'g', 'h', 'i'});
        letterTable.put('5', new char[] {'j', 'k', 'l'});
        letterTable.put('6', new char[] {'m', 'n', 'o'});
        letterTable.put('7', new char[] {'p', 'q', 'r', 's'});
        letterTable.put('8', new char[] {'t', 'u', 'v'});
        letterTable.put('9', new char[] {'w', 'x', 'y', 'z'});

        StringBuilder str = new StringBuilder();

        dfs(result, letterTable, 0, str, digits);

        return result;
    }

    private void dfs(List<String> result, HashMap<Character, char[]> letterTable,
            int pos, StringBuilder str, String digits) {
        if (pos == digits.length()) {
           result.add(str.toString());
           return;
        }

        for (char c : letterTable.get(digits.charAt(pos))) {
            str.append(c);
            dfs(result, letterTable, pos + 1, str, digits);
            str.deleteCharAt(str.length() - 1);
        }
    }

        
        



    public static void main(String[] args) {
        Solution_DFS2 test = new Solution_DFS2();
        List<String> result = test.letterCombinations("23");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
