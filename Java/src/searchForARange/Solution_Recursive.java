/**
 * The recursive solution.
 * Time complexity: O(logn);
 * Space complexity: O(logn);
 * Status:
 */
public class Solution_Recursive {
    public int[] searchRange(int[] nums, int target) {
        // precondition: nums is not null and is sorted. target in the nums.
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = -1;
        
        searchRange(nums, target, 0, nums.length, result);
        if (result[0] == Integer.MAX_VALUE) {
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }

    private void searchRange(int[] nums, int target, int lo, int hi, int[] result) {
        if (lo + 1 >= hi) {
            if (lo + 1 == hi &&  nums[lo] == target) {
                if (lo == 0 || nums[lo - 1] < nums[lo]) result[0] = Math.min(result[0], lo);
                if (lo == nums.length - 1 || nums[lo + 1] > nums[lo]) result[1] = Math.max(result[1], lo);
            }
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] < target) {
            searchRange(nums, target, mid + 1, hi, result);
        } else if (nums[mid] > target) {
            searchRange(nums, target, lo, mid, result);
        } else if (nums[mid] == target) {
            searchRange(nums,target, lo, mid, result);
            searchRange(nums,target, mid + 1, hi, result);
        }
    }

    public static void main(String[] args) {
        Solution_Recursive s = new Solution_Recursive();
        int[] input = {2,2};
        int[] result = s.searchRange(input, 3);
        for (int i : result) {
            System.out.println(" " + i);
        }
    }

}
