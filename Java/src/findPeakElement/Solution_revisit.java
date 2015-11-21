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
            if (nums[mid] > nums[mid - 1]) {
                if (nums[mid] > nums[mid + 1]) return mid;
                else lo = mid;
            } else {
                hi = mid + 1;
            }
        }
        
        return nums[lo] < nums[hi - 1] ? hi - 1 : lo;
    }

}
