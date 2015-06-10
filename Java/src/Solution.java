public class Solution {
	public int findMin(int [] nums) {
		int left = 0;
		int right = nums.length - 1;
		
		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] < nums[left]) {
				right = mid;
				continue;
			} else if (nums[mid] > nums[right]) {
				left = mid + 1;
				continue;
			} else if (nums[left] == nums[mid] 
					&& nums[left] == nums[right]) {
				left++;
				continue;
			} else {
				return nums[left];
			}
		}

		return nums[left];
	}
}
