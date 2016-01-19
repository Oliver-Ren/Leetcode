/**
 * The solution based on vertically scan.
 * Time complexity: O(n * k'), where k' is the length of the common prefix. 
 * Space complexity: O(1) 
 * Status: Accepted.
 */
public class SolutionScan {
    public String longestCommonPrefix(String[] strs) {
        // precondition: strs is not null
        if (strs == null) {
            throw new NullPointerException();
        }

        if (strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() 
                        || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}


