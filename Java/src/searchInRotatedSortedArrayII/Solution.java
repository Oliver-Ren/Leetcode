public class Solution {
    public boolean search(int[] nums, int target) {
		// Precondition
		if (nums == null || nums.length == 0) {
			return false;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (target == nums[mid]) {
				return true;
			} 
			
			if (nums[left] > nums[mid]) {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			
			} else if (nums[left] < nums[mid]) {
				if (target < nums[mid] && target >= nums[left]) {
					right = mid;
				} else {
					left = mid + 1;
				}
			} else if (nums[left] == nums[mid]) {
				if (nums[left] == nums[right]) {
					right--;
				} else {
					left = mid + 1;
				}
			}
		}

		return false;
	}
}
		

