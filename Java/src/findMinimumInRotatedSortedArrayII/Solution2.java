/**
 * Revisit the problem.
 * idea: Binary search.
 * Time complexity: O(logn)
 * Space compleixty: O(logn).
 * Status: Accepted.
 */
public class Solution2 {
    public int findMin(int[] nums) {
        // precondition: nums is not null
        if (nums == null) {
            throw new NullPointerException();
        }

        int lo = 0;
        int hi = nums.length;


        while (lo + 2 < hi && nums[lo] == nums[hi - 1]) hi--;
        while (lo + 2 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi - 1]) lo = mid + 1;
            else hi = mid + 1;
        }

        return Math.min(nums[lo], nums[hi - 1]);
    }
}
