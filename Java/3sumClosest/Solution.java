import java.util.Arrays;
/** My first solution, firstly
  * sort the array and then using the
  * two nested loop to select first two 
  * elements. using the binary search to 
  * find the third one.
  * time complexity: O(n^2 logn).
  * space complexity: O(1);
  * status: accepted, 392ms.
  */

public class Solution {
     public int threeSumClosest(int[] nums, int target) {
		 if (nums == null || nums.length == 0) {
			 return -1;
		 }

         int closest = Integer.MAX_VALUE;
         Arrays.sort(nums);
         for (int i = 0; i < nums.length; i++) {
             for (int j = i + 1; j < nums.length; j++) {
                 int remain = target - nums[i] - nums[j];
                 int third = Arrays.binarySearch(nums, j + 1, nums.length, remain);
                 if (third >= 0) {
                     return target;
                 }

                 third = -(third + 1); 
				 if (third < nums.length) {

					 int newSum = nums[i] + nums[j] + nums[third];
					 //System.out.println("i = " + i + " j = " + j + " third = " + third + " newSum = " + newSum + "sep:" + nums[i]);
					 if (target - closest == Integer.MIN_VALUE) {
						 closest = newSum;
					 } else {
						 closest = Math.abs(target - newSum) < Math.abs(target - closest) ? newSum : closest; 
					 }
				 }

				 if (third - 1 > j) {
					 int newSum2 = nums[i] + nums[j] + nums[third - 1];
					 //System.out.println("i = " + i + " j = " + j + " third- 1 = " + third + "newSum2=" + newSum2);
					 if (target - closest == Integer.MIN_VALUE) {
						 closest = newSum2;
					 } else {
						 closest = Math.abs(target - newSum2) < Math.abs(target - closest) ? newSum2 : closest; 
					 }
				 }
             }
         }

         return closest;
     }

     public static void main(String[] args) {
         Solution test = new Solution();
         int[] testcase = {-3,-2,-5,3,-4};
         System.out.println(test.threeSumClosest(testcase, -1));
     } 
}
