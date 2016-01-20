/**
 * This solution implements binary search for lowerbound.
 * Time complexity: O(logn);
 * Space complexity: O(1);
 * Ststus: Accepted.
 */
public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        // precondition: nums is not null
        if (nums == null) {
            throw new NullPointerException();
        }

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int start = firstGreaterEquals(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{start, firstGreaterEquals(nums, target + 1) - 1};
    }

    private int firstGreaterEquals(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        if (nums[lo] >= target) {
            return lo;
        }

        if (nums[hi] >= target) {
            return hi;
        }

        return hi + 1;
    }


}
