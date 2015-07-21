

import java.util.List;
import java.util.ArrayList;
/**
  * Time Complexity: O(n) in the worst case;
  * Space Complexity: O(n)
  * Status: Accepted, 372ms.
  */

public class Solution {
    public int traps(int[] height) {
        int leftMaxValue = 0;
        int rightMaxValue = 0;
        int len = height.length;
        int [] traps = new int[len];
        int trap;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            if (leftMaxValue < height[i]) {
                leftMaxValue = height[i];
            }

            trap = Math.max(leftMaxValue - height[i], 0);
            traps[i] = trap;
        }

        for (int i = len - 1; i >= 0; i--) {
            if (rightMaxValue < height[i]) {
                rightMaxValue = height[i];
            }

            trap = Math.min(rightMaxValue - height[i], traps[i]);
            sum += Math.max(trap, 0);
        }

        return  sum;
    }

            

    public static void main(String [] args) {
        Solution test = new Solution();
        int [] input = {5, 4, 1, 2};
        System.out.println(test.traps(input));
    }


}
