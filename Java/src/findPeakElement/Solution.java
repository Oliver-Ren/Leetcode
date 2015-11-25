/**
 * idea: Binary Search.
 * Status: Accepted
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        // precondition: nums is not null and is not empty.
        if (nums == null || nums.length == 0) {
            throw new NullPointerException();
        }

        int lo = 0;
        int hi = nums.length;

        while (lo + 2 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else if (nums[mid - 1] > nums[mid]) {
                hi = mid;
            }
        }

        if (nums[lo] > nums[hi - 1]) return lo;
        else return hi -1;
    }

}
