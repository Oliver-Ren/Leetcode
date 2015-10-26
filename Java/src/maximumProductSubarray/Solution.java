/**
 * My first attempt.
 * idea: using DP, using two DP arrays to store the 
 * positive value of maximum product and the negative value 
 * of minimum product. Then choose the maximum from them.
 * Time complexity: O(n)
 * Space Complexity: O(n)
 * Status: Accepted.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        // precondition: nums is not null
        if (nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int len = nums.length;
        int[] posDP = new int[len + 1];
        int[] negDP = new int[len + 1];
        int max = 0;

        // init
        for (int i = 1; i <= len; i++) {
            if (nums[i - 1] >= 0) {
                posDP[i] = nums[i - 1];
            } else {
                negDP[i] = nums[i - 1];
            }
        }

        for (int i = 1; i <= len; i++) {
            if (nums[i - 1] >= 0) {
                posDP[i] = Math.max(posDP[i], posDP[i - 1] * nums[i - 1]);
                negDP[i] = Math.min(negDP[i], negDP[i - 1] * nums[i - 1]);
            } else {
                posDP[i] = Math.max(posDP[i], negDP[i - 1] * nums[i - 1]);
                negDP[i] = Math.min(negDP[i], posDP[i - 1] * nums[i - 1]);
            }
            max = Math.max(max, posDP[i]);
        }

        return max;
    }
}
