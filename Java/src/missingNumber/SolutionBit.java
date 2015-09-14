/* Solution using bit manipulation.
 * time complexity: O(n);
 * space compelxity: O(1);
 * status: accepted.
 */

public class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.lengtF;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
            result ^= i;
        }

        return result;
    }
}

