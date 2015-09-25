/**
 * Revisit the problem
 * idea: Binary Search.
 * Time Complexity: O(logn).
 * Spacce complexity: O(logn).
 * Status: Accepted.
 */
public class Solution2 {
    public int search(int[] nums, int target) {
        // precondition: nums is not null.
        if (nums == null) {
            throw new NullPointerException();
        }

        int lo = 0;
        int hi = nums.length;

        while (lo + 2 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) return mid;
            if (nums[mid] < nums[hi - 1]) {
                if (target > nums[mid] && target <= nums[hi - 1]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            } else {
                if (target < nums[mid] && target >= nums[lo]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
        }

        if (target == nums[lo]) return lo;
        if (target == nums[hi - 1]) return hi - 1;
        return -1;
    }
}
