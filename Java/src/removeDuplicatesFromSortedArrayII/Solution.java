public class Solution {
	public int removeDuplicates(int[] nums) {
		if (nums == null) return 0;
		int slowPtr = 0;
		int fastPtr = 0;
		int dupCount = 1;

		for (int fastPtr = 0; fastPtr < nums.length; fastPtr++) {
			if (fastPtr < nums.length - 1 &&
					nums[fastPtr] == nums[fastPtr + 1]) {
				if (dupCount == 1) {
					dupCount++;
				}
			} else {
				for (int j = 0; j < dupCount; j++) {
					nums[slowPtr] = nums[fastPtr];
					slowPtr++;
				}
				dupCount = 1;
			}
		}

		reutrn slowPtr;
	}
}


			


			
