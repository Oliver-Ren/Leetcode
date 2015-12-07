
/**
 * The greedy soluiton.
 * time complexity: O(n);
 * space complexity: O(1);
 * Status; Accepted;
 */
public class Solution {
    public boolean canJump(int[] nums) {
        // precondition: nums is not null
        if (nums == null) throw new NullPointerException();
        int len = nums.length;

        int maxDist = 0;

        for (int i = 0; i < len; i++) {
            if (i <= maxDist) {
                maxDist = Math.max(maxDist, nums[i] + i);
            } else {
                return false;
            }
        }

        return maxDist >= nums[len - 1];
    }
}

