/**
 * This is my first attempt for Leetcode problem <tt>Edit Distance</tt>.
 * The solution is based on the dynamic proramming approach.
 * Time complexity: O(m*n);
 * Space complexity: O(n);
 * Status: time limit exceeded.
 */
public class Solution2 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new NullPointerException();
        }

        int len1 = word1.length();
        int len2 = word2.length();

        // The array for storing the optimal subproblem.
        int[] opt = new int[len2 + 1];

        // init the first row.
        for (int j = 0; j <= len2; j++) {
            opt[j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            int prev = opt[0];
            opt[0] = i;
            for (int j = 1; j <= len2; j++) {
                int costInsert = opt[j - 1] + 1;
                int costDelete = opt[j] + 1;
                int costReplace = prev;
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    costReplace++;
                }
                prev = opt[j];
                opt[j] = Math.min(Math.min(costInsert, costDelete), 
                        costReplace);
            }
        }

        return opt[len2];
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.minDistance("hhh", "aaa"));
    }
}
        


