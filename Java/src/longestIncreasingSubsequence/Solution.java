import java.util.Arrays;
/**
 * Dynamic Programming Solution.
 * State: f(i) is the longest increasing subsequnce ending
 * with i.
 * Function: f(i) = max(f(j) + 1), where j less than i 
 * and nums[j] less than nums[i].
 * Initialization: f(0 .. n - 1) = 1; 
 * answer: max(f(0 .. n - 1)) 
 *
 * Time complexity: O(n^2);
 * Space complexity: O(n);
 * Status: Accepted, 31ms.
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // precondition: nums is not null
        if (nums == null) throw new NullPointerException();
        int[] f = new int[nums.length];
        // init
        Arrays.fill(f, 1);
        for (int i = 0; i < nums.length; i++) {
            int maxLen = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxLen = Math.max(maxLen, f[j] + 1);
                }
            }
            f[i] = maxLen;
        }

        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            length = Math.max(length, f[i]);
        }

        return length;
    }
}
