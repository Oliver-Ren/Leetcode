/** 
 * This implementation makes it easier to write
 * correct code.
 *
 * Time complexity: O(n) in the worst case.
 * Space complexity: O(1);
 * Status: Accepted.
 */
public class Solution {
    public int findMin(int[] nums) {
        // precondition: nums is not null
        if (nums == null) {
            throw new NullPointerException();
        }
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else if (nums[mid] > nums[hi]) {
                lo = mid;
            } else {
                if (nums[hi] >= nums[lo]) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        
        if (nums[lo] > nums[hi]) {
            return nums[hi];
        } else {
            return nums[lo];
        }
        
    }
}
