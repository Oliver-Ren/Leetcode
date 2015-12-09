import java.util.SortedSet;
import java.util.TreeSet;
/**
 * Solution using tree set.
 * Time complexity: O(nlogn)
 * Space Complexity: O(n).
 * Status: 
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        SortedSet<Character> charSet = new TreeSet<Character>();
        char[] str = s.toCharArray();
        for (char c : str) {
            charSet.add(new Character(c));
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : charSet) {
            sb.append(c);
        }
        return sb.toString();
    }
}
