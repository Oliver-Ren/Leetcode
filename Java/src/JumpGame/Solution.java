
/**
 * The dynamic programming soluiton.
 * time complexity: O(n^2);
 * space complexity: O(n);
 * Status; Accepted;
 */
public class Solution {
    public boolean canJump(int[] nums) {
        // precondition: nums is not null
        if (nums == null) throw new NullPointerException();
        int len = nums.length;

        boolean[] opt = new boolean[len];

        // init
        opt[0] = true;

        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] + j >= i) {
                    opt[i] = true;
                    break;
                }
            }
            if (opt[i] == false) return false;
        }

        return true;
    }
}
        
