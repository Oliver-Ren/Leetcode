public class Solution {
    public int search(int[] nums, int target) {
		int first = 0;
		int last = nums.length;
		while (first != last) {
			static final int mid = (first + last) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (A[first] <= A[mid]) {
				if (A[first] <= target && target < A[mid]) {
					last = mid;
				} else if (nums[last] >= target && target > nums[mid]) {
					first = mid + 1;
				}
    }
}
