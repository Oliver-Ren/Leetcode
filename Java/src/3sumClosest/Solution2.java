import java.util.Arrays;
/** The second solution. it uses the property that in a sorted array,
  * two pointer at the left and the right respectively, if the sum is
  * small, we only need to move the left pointer to right and vise versa.
  * This property makes it possible to choose the closest sum of two number
  * in O(n) complexity.
  *
  * time complexity: O(n^2).
  * space complexity: O(1);
  * status: accepted, 332ms.
  */

public class Solution2 {
     public int threeSumClosest(int[] nums, int target) {
		 if (nums == null || nums.length == 0) {
			 return -1;
		 }

		 Arrays.sort(nums);
		 int sum = Integer.MAX_VALUE;
		 int diff = Integer.MAX_VALUE;

		 for (int i = 0; i < nums.length; i++) {
			 int j = i + 1;
			 int k = nums.length - 1;
			 while (j < k) {
				 int currSum = nums[i] + nums[j] + nums[k];
				 int newDiff = Math.abs(currSum - target);
				 if (newDiff < diff) {
					 diff = newDiff;
					 sum = currSum;
				 }

				 if (currSum < target) {
					 j++;
				 } else if (currSum > target) {
					 k--;
				 } else {
					 return target;
				 }
			 }
		 }

		 return sum;
	 }

     public static void main(String[] args) {
         Solution2 test = new Solution2();
         int[] testcase = {-3,-2,-5,3,-4};
         System.out.println(test.threeSumClosest(testcase, -1));
     } 
}
