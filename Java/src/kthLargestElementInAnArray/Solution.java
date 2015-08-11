/** This solution is an implementation
  * of quick select, 
  * the Time complexity is: O(n);
  * space complexity is: O(logn);
  * Status: Accepted, 328ms. 
  */

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) return 0;
        return qSelect(nums, 0, nums.length - 1, nums.length - k);

    }

    private int qSelect(int[] nums, int start, int end, int target) {
        if (end == start) {
            return nums[end];
        }
        int median = partition(nums, start, end);
        if (median < target) {
            return  qSelect(nums, median + 1, end, target);
        } else if (median > target) {
            return qSelect(nums, start, median - 1, target);
        } else {
            return nums[median];
        }
    }

    private int partition(int[] nums, int start, int end) {
        int medianIdx = medianOfThree(nums, start, start + (end - start) / 2, end);
        exch(nums, medianIdx, start);
        medianIdx = start;
        start++;

        while (true) {
            while (nums[start] <= nums[medianIdx] && start < end) {
                start++;
            }

            while (nums[end] > nums[medianIdx]) {
                end--;
            }

            if (end > start) {
                exch(nums, end, start);
            } else {
                break;
            }
        }

        exch(nums, end, medianIdx);
        return end;
    }

    private void exch(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private int medianOfThree(int[] nums, int left, int mid, int right) {
        int greater;
        int smaller;
        if (nums[left] == nums[mid] || nums[right] == nums[mid]) {
            return mid;
        }

        if (nums[left] > nums[mid]) {
            greater = left;
            smaller = mid;
        } else {
            greater = mid;
            smaller = left;
        }

        return nums[greater] < nums[right] ? greater
            : nums[right] > nums[smaller] ? right : smaller;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = {-1, 2, 0};
        System.out.print(test.findKthLargest(nums, 1));
    }
}
