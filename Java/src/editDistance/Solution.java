/**
 * This is my first attempt for Leetcode problem <tt>Edit Distance</tt>.
 * The solution is based on the dynamic proramming approach.
 * Time complexity: O(m*n);
 * Space complexity: O(m*n);
 * Status: time limit exceeded.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new NullPointerException();
        }

        int len1 = word1.length();
        int len2 = word2.length();

        // The array for storing the optimal subproblem.
        int[][] opt = new int[len1 + 1][len2 + 1];
        
        // init the first column.
        for (int i = 0; i < len1; i++) {
            opt[i][0] = i;
        }

        // init the first row.
        for (int j = 0; j < len2; j++) {
            opt[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int costInsert = opt[i][j - 1] + 1;
                int costDelete = opt[i - 1][j] + 1;
                int costReplace = opt[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    costReplace++;
                }
                opt[i][j] = Math.min(Math.min(costInsert, costDelete), 
                        costReplace);
                System.out.print(opt[i][j] + ", ");
            }
            System.out.println();
        }

        return opt[len1][len2];
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.minDistance("hhh", "aaa"));
    }
}
        


