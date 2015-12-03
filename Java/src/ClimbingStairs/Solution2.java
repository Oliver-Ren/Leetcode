/**
 * A dynamic programming approach.
 * Time complexity: O(n).
 * Space complexity: O(n). 
 * Status: Accepted.
 */
public class Solution2 {
    public int climbStairs(int n) {
        // precondition: n is no less than 0
        if (n <= 0) return 0;

        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }

        return nums[n];

    }
}
