/**
 * Solution based on the quick select algorithm.
 * 0         1/3          2/3           1
 *  .........cand1........cand2..........
 * if there is a candidate, it must cover the 1/3th
 * of the 2/3 smallest position in a sorted array.
 * Time complexity: O(n) in average case.
 * Space complexity: O(1).
 * Status: Accepted.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // precondition: nums is not null
        if (nums == null) throw new NullPointerException();
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0) return result;
        int cand1 = select(nums, nums.length / 3);
        int cand2 = select(nums, 2 * nums.length / 3);
        int count1 = 0;
        int count2 = 0;
        
        for (int n : nums) {
            if (n == cand1) {
                count1++;
            }
            
            if (n == cand2) {
                count2++;
            }
        }
        
        if (count1 > nums.length / 3) {
            result.add(cand1);
        }

        if (cand1 != cand2 && count2 > nums.length / 3) {
            result.add(cand2);
        }

        return result;
    }
    
    private int select(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length;
        while (lo + 1 < hi) {
            int mid = partition(nums, lo, hi);
            if (mid == k) {
                return nums[k];
            } else if (mid > k) {
                hi = mid;
            } else if (mid < k) {
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
                exch(nums, i, j);
            } else {
                break;
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

