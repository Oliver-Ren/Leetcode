/** This solution is the basic 
  * quick select..
  * the Time complexity is: O(n);
  * space complexity is: O(1);
  * Status: Accepted, 296ms. 
  */

public class Solution_QSelect {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo < hi) {
            mid = partition(nums, lo, hi);
            if (mid == nums.length - k) {
                break;
            } else if (mid > nums.length - k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return nums[nums.length - k];
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        
        while (true) {
            while (i < hi && nums[++i] < nums[lo]);
            while (j > lo && nums[--j] > nums[lo]);

            if (i >= j) {
                break;
            } else {
                exch(nums, i, j);
            }
        }

        exch(nums, lo, j);
        return j;
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}

        