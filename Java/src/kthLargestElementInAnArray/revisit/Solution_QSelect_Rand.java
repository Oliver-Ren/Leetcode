import java.util.*;

/** This solution is the randomized
  * quick select..
  * the Time complexity is: O(n);
  * space complexity is: O(logn);
  * Status: Accepted, 316ms. 
  */

public class Solution_QSelect_Rand {
    public int findKthLargest(int[] nums, int k) {
        // Dealing with invalid inputs
        if (nums == null || nums.length == 0 || k < 1
                || k > nums.length) {
            return -1;
        }
        shuffle(nums);
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

    // shuffle the whole array using knuth shuffling.
    private void shuffle(int [] nums) {
        for (int i = 0; i < nums.length; i++) {
            int k = (int)(Math.random() * i);
            exch(nums, i, k);
        }
    }

            
}

        
