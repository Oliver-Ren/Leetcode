import java.util.Map;
import java.util.HashMap;
/**
 * My first attempt for the problem.
 * The idea is using greedy approach.
 * Time complexity: O(n);
 * Space complexity: O(n);
 * Status: Accepted.
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        // precondition: s is not null
        if (s == null) {
            return 0;
        }

        int start = 0;
        int end = 1;    // exclusive end position
        // keep track of the position of the longest
        // substring.
        int maxStart = 0;
        int maxEnd = 0;
        Map<Character, Integer> posMap = new HashMap<Character, Integer>();

        for (; end <= s.length(); end++) {
            char curr = s.charAt(end - 1);
            if (!posMap.containsKey(curr)) {
                // ok to go
                posMap.put(curr, end);
            } else {
                // bad, duplicate

                // Be very very very careful about this.
                // the pointer could go back if no max.
                start = Math.max(start, posMap.get(curr));
                posMap.put(curr, end);
            }
            // update
            if (end - start > maxEnd - maxStart) {
                maxStart = start;
                maxEnd = end;
            }
            System.out.println("ptr1 = " + (start) + ", ptr2 = " + (end - 1) + ", max = " + (maxEnd - maxStart));
        }

        //System.out.println("" + maxStart + ", " + maxEnd);
        return (maxEnd - maxStart);

    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        test.lengthOfLongestSubstring("gehmbfqmozbpripibusbezagafqtypz");
    }
}
