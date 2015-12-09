/**
 * The dynamic programming solution.
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


