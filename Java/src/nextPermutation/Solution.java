/**
 * Linear time solution.
 * Time complexity: O(n);
 * Space complexity: O(1);
 * Status: Accepted.
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        // precondition: nums is not null
        if (nums == null) {
            throw new NullPointerException();
        }

        if (nums.length < 2) {
            return;
        }
        
        int left = nums.length - 1;
        
        while (left > 0 && nums[left - 1] >= nums[left]) {
            left--;
        }
        
        if (left == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        left--;
        int right = nums.length - 1;
        while (right > left && nums[right] <= nums[left]) {
            right--;
        }

        swap(nums, left, right);
        reverse(nums, right + 1, nums.length - 1);
       
   }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            swap(nums, i, j);
        }
    }

}
