/** This is a simple 
  * dynamic programming 
  * solution for the problem
  * where opt[i] = max(opt[i - 1], opt[i - 2] + num[i]
  * Time complexity: O(n);
  * Space complexity: additional O(1);
  * Status: Accepted, 320ms.
  */

public class Solution2 {
    public int rob(int [] nums) {
        int len = nums.length;
        int [] opt = new int[len + 2];

        for (int i = 2; i < len + 2; i++) {
            opt[i] = Math.max(opt[i - 1], opt[i - 2] + nums[i - 2]);
        }

        return opt[len + 1];
    }

    public static void main(String [] args) {
        Solution2 test = new Solution2();
        int [] tt = {1, 100, 120, 100, 1};
        System.out.println(test.rob(tt));
    }
}
