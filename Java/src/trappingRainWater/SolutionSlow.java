
import java.util.List;
import java.util.ArrayList;
/**
  * Time Complexity: O(n^2)
  * Space Complexity: O(1)
  * Status: Time Limit Exceede.
  */

public class Solution {
    public int traps(int[] height) {
        int len = height.length;
        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = 0; j < i; j++) {
                if (height[j] > leftMax) {
                    leftMax = height[j];
                }
            }

            for (int j = i + 1; j < len; j++) {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                }
            }

            int edge = Math.min(leftMax, rightMax);
            int trap = Math.max(edge - height[i], 0);
            sum += trap;
        }

        return sum;
    }

    
    public static void main(String [] args) {
        Solution test = new Solution();
        int [] input = {5, 4, 1, 2};
        System.out.println(test.traps(input));
    }
}

        





            
            
