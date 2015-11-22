/**
 * Using Swap, attention, the element at index 0 should be 1.
 * Time complexity: O(n);
 * Space complexity: O(1)
 * Status: Accepted, 1ms. 
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        // precondition: nums is neither null nor empty
        if (nums == null || nums.length == 0) return 1;
        final int N = nums.length;
        for (int i = 0; i < N; i++) {
            while (nums[i] > 0 && nums[i] < N && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < N; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return N + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2};
        System.out.println(s.firstMissingPositive(nums));
    }
}
