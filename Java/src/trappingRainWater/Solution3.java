

import java.util.List;
import java.util.ArrayList;
/**
  * Time Complexity: O(n) in the worst case;
  * Space Complexity: O(1)
  * Status: Accepted, 376ms.
  */

public class Solution3 {
    public int traps(int[] height) {
        int maxIdx = 0;
        int len = height.length;
        int sum = 0;
        int peak = 0;
        for (int i = 0 ; i < len; i++) {
            if (height[i] > height[maxIdx]) {
                maxIdx = i;
            }
        }

        for (int i = 0; i < maxIdx; i++) {
            
            if (height[i] > peak) {
                peak = height[i];
            } else {
                sum += peak - height[i];
            }
        }

        peak = 0;

        for (int i = len - 1; i > maxIdx; i--) {
            if (height[i] > peak) {
                peak = height[i];
            } else {
                sum += peak -height[i];
            }
        }

        return sum;
    }

    public static void main(String [] args) {
        Solution3 test = new Solution3();
        int [] input = {5, 4, 1, 2};
        System.out.println(test.traps(input));
    }
}

