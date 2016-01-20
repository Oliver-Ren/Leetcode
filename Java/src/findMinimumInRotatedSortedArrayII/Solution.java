/** 
 * This implementation makes it easier to write
 * correct code.
 *
 * Time complexity: O(n) in the worst case.
 * Space complexity: O(1);
 * Status: Accepted.
 */
public class Solution {
	public int findMin(int[] nums) {
		// The condition when the array is null
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int firstElement = nums[0];
		boolean isFound = false;
		// The condition where the array is not rotated.
		if (nums[0] < nums[nums.length - 1] || nums.length == 1) {
			return nums[0];
		}


		// The condition where the array is rotated.
		int leftBound = 0;
		int rightBound = nums.length - 1;


		/* We should firstly consider the condition
		   where the left most element and the right 
		   most element are the same, the target might
		   be hidden between the left most and the 
		   right most element. 

		   for eample 3333333313. */
		if (nums[0] == nums[nums.length - 1]) {
			while (nums[leftBound] == nums[rightBound]) {
				rightBound--;
				if (rightBound == 0) {
					return nums[0];
				}
			}

		}

		int pointer = (rightBound - leftBound) / 2;

		while (true) {
			if (nums[pointer] > nums[pointer + 1]) {
				return nums[pointer + 1];
			}

			if (nums[pointer] < nums[rightBound]) {
				leftBound = pointer + 1;
			} else {
				rightBound = pointer - 1;

			}

			pointer = (rightBound - leftBound) / 2;
			if (rightBound - leftBound <= 1) {
				return nums[leftBound] < nums[rightBound] ? 
					nums[leftBound] : nums[rightBound];
			}
		}
	}
}


