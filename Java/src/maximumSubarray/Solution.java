/**
 * The dynamic programming solution.
 * State: f(i) represents the max subarray ending with nums[i];
 * Function: f(i) = max(f(i-1), 0) + nums[i], where i > 0.
 * Initialize: f(0) = 0.
 * answer: max(f(1 .. n)).
 *
 * Time complexity; O(n).
 * Space complexity: O(n).
 * Status: Accepted. 
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] opt = new int[nums.length];
        opt[0] = nums[0];
        int maxValue = opt[0];
        for (int i = 1; i < nums.length; i++) {
            opt[i] = Math.max(opt[i - 1] + nums[i], nums[i]);
            maxValue = Math.max(opt[i], maxValue);
        }

        return maxValue;
    }
}


