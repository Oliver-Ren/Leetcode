/** This solution is the basic 
  * quick select..
  * the Time complexity is: O(n);
  * space complexity is: O(1);
  * Status: accepted, 296ms. 
  */

public class Solution_QSelect {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length; 
        int left = 0;
        int right = nums.length - 1;
        int pos = -1;

        while (pos != len - k) {
            pos = partition(nums, left, right);

            if (pos < len - k) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }

        return nums[pos];

    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
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

    public static void main(String[] args) {
        Solution_QSelect test = new Solution_QSelect();
        int[] nums = {3, 2, 7, 1, 10, 44};
        System.out.println(test.findKthLargest(nums,2));
    }
}

