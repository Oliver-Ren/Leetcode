/** time complexity: O(n)
 *  space complexity: O(1)
 *  Status: accpted.
 */

public class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        long sum = (len + 1) * len / 2;
        long realSum = 0;
        for (int i = 0; i < len; i++) {
            realSum += nums[i];
        }

        return (int)(sum - realSum);
    }
}



