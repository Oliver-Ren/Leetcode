/** This solution is the basic 
  * quick select..
  * the Time complexity is: O(n);
  * space complexity is: O(1);
  * Status: accepted, 284ms. 
  */

public class Solution_QSelect_MedianOf3 {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        int pos = -1;
        
        while (pos != nums.length - k) {
            pos = partition(nums, lo, hi);
            if (pos > nums.length - k) {
                hi = pos - 1;
            } else {
                lo = pos + 1;
            }
        }

        return nums[pos];
        
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        medianOfThree(nums, lo, hi);
        int pivot = nums[lo];

        while (i < j) {
            while (i < hi && nums[++i] < pivot);
            while (j > lo && nums[--j] > pivot);

            if (i < j) {
                exch(nums, i, j);
            }
        }

        exch(nums, lo, j);
        return j;
        
    }

    private void exch(int[] nums, int lo, int hi) {
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }

    private void medianOfThree(int[] nums, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] > nums[lo]) {
            if (nums[mid] > nums[hi]) {
                exch(nums, lo, nums[hi] > nums[lo] ? hi : lo);
            } else {
                exch(nums, lo, mid);
            }
        } else {
            if (nums[lo] > nums[hi]) {
                exch(nums, lo, nums[mid] > nums[hi] ? mid : hi);
            } 
        }
    }
        
} 
