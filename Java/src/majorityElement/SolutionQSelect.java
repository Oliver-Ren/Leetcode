/**
 * Based on the quick select algorithm.
 * Time complexity: Avg: O(n).
 * Space Complexity: O(1);
 */
public class Solution {
    public int majorityElement(int[] nums) {
        // preconditon: nums is not null
        if (nums == null) {
            throw new NullPointerException();
        }
        
        return select(nums, nums.length / 2);
    }
    
    private int select(int[] nums, int k) {
        shuffle(nums);
        return select(nums, 0, nums.length, k);
    }
    
    // lo: inclusive, hi: exclusive.
    private int select(int[] nums, int lo, int hi, int k) {
        if (hi == k) {
            return nums[k - 1];
        }
        
        while (lo + 1 < hi) {
            int mid = partition(nums, lo, hi);
            if (mid == k) {
                return nums[k];
            } else if (mid > k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return nums[lo];
        
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo;
        int j = hi;
        while (true) {
            while (i < hi - 1 && nums[++i] < pivot);
            while (j > 0 && nums[--j] > pivot);
            if (i < j) {
               swap(nums, i, j);
            } else {
                break;
            }
        }
        
        swap(nums, lo, j);
        return j;
    }
    
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void shuffle(int[] nums) {
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < nums.length; i++) {
            swap(nums, i, r.nextInt(i + 1));
        }
    }
    
}
