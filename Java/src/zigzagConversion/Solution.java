/**
 * Time complexity: O(n)
 * Sapce Complexity: O(n)
 */
public class Solution {
    public String convert(String s, int numRows) {
        // precondition: s is not null
        if (s == null) throw new NullPointerException();
        if (numRows <= 1) return s;
        int cycle = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i + j < s.length(); i += cycle) {
                sb.append(s.charAt(i + j));
                if (j >= 1 && j < numRows - 1 && i + cycle - j < s.length()) {
                    sb.append(s.charAt((i + (cycle - j))));
                }
            }
        }
        
        return sb.toString();
    }
}
