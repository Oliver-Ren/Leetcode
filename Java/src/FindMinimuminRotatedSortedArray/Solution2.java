/**
 * Revisit the Problem.
 * idea: Binary Search.
 * Time Complexity: O(logn)
 * Space Complexity: O(logn)
 * Status: Accepted.
 */
public class Solution2 {
    public int findMin(int[] nums) {
        // precondition: nums is not null
        if (nums == null) {
            throw new NullPointerException();
        }

        int min = findMin(nums, 0, nums.length);
        return min;
    }

    // i is the start, j is the end exclusive.
    private int findMin(int[] nums, int i, int j) {
        if (j <= i + 2) {
            return Math.min(nums[i], nums[j - 1]);
        }

        int mid = i + (j - i) / 2;
        if (nums[mid] < nums[j - 1]) return findMin(nums, i, mid + 1);
        else return findMin(nums, mid, j);
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        int[] nums = {5,6,7,8,1,2,3};
        System.out.println(test.findMin(nums));
    }
}
