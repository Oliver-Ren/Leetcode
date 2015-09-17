import java.util.*;
/**
 * The Iterative solution for the problem.
 * inspired by the highest vote answer in
 * Leetcode.
 * Using a FIFO queue and append letters
 * in rounds.
 * It is quite similar to the level order
 * traversal
 * 
 * Time complexity: O(3 ^ n)
 * Space compleity: O(3 ^ n)
 * Status: accepted, 230ms;
 */

public class Solution_Iter {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();

        if (digits == null || digits.equals("")) {
            return result;
        }

        String[] letterTable = {" ", "", "abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"};

        // firstly put something into the list.
        result.add("");
        

        for (int pos = 0; pos < digits.length(); pos++) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
               String curr = result.remove();

               for (char c : letterTable[digits.charAt(pos) - '0'].toCharArray()) {
                   result.add(curr + c);
               }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Iter test = new Solution_Iter();
        List<String> result = test.letterCombinations("23");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
