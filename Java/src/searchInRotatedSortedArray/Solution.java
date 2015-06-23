public class Solution {
    public int search(int[] nums, int target) {
        // Precondition
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (target == nums[mid]) {
				return mid;
			} 
			
			if (nums[left] > nums[mid]) {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			
			} else {
				if (target < nums[mid] && target >= nums[left]) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}
		}

		return -1;
		
    }

	public static void main(String [] args) {
		Solution test = new Solution();
		int [] nums = {1};
		System.out.println(test.search(nums, 0));
	}
}
