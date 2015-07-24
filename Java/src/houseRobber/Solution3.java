/** This is a simple 
  * dynamic programming 
  * solution for the problem
  * where opt[i] = max(opt[i - 1], opt[i - 2] + num[i]
  * Time complexity: O(n);
  * Space complexity: additional O(1);
  * Status: Accepted.
  */

public class Solution3 {
    public int rob(int [] nums) {
        int notRobPrev = 0;
        int robPrev = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.max(notRobPrev + nums[i], robPrev); 
            notRobPrev = robPrev;
            robPrev = nums[i];
        }

        return robPrev;
    }

    public static void main(String [] args) {
        Solution3 test = new Solution3();
        int [] tt = {1, 100, 120, 100, 1};
        System.out.println(test.rob(tt));
    }
}
