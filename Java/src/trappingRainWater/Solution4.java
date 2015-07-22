

import java.util.List;
import java.util.ArrayList;
/**
  * Time Complexity: O(n) in the worst case;
  * Space Complexity: O(1)
  * Status: Accepted, 344ms.
  */

public class Solution4 {
    public int traps(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int i = 0, j = height.length - 1;
        int sum = 0;
        
        while (i < j) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            } 

            if (height[j] > rightMax) {
                rightMax = height[j];
            }

            if (leftMax > rightMax) {
                sum += rightMax - height[j];
                j--;
            } else {
                sum += leftMax - height[i];
                i++;
            }
        }

        return sum;
    }

    public static void main(String [] args) {
        Solution4 test = new Solution4();
        int [] input = {5, 4, 1, 2};
        System.out.println(test.traps(input));
    }
}

