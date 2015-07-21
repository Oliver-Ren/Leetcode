
import java.util.List;
import java.util.ArrayList;
/**
  * Time Complexity: O(n^2) in the worst case;
  * Space Complexity: O(1)
  * Status: Accepted, 384ms.
  */

public class Solution {
    public int traps(int[] height) {
        int leftMaxIdx = 0;
        int rightMaxIdx = 0;
        int len = height.length;
        int sum = 0;

        for (int i = 0; i < len - 1; i++) {
            if (height[i] > height[leftMaxIdx]) {
                leftMaxIdx = i;
            }

            if (i >= rightMaxIdx) {
                rightMaxIdx = i + 1;
                for (int j = i + 1; j < len; j++) {
                    if (height[j] > height[rightMaxIdx]) {
                        rightMaxIdx = j;
                    }
                }
            }

            int edge = Math.min(height[leftMaxIdx], height[rightMaxIdx]);
            sum += Math.max(edge - height[i], 0);
        }

        return sum;
    }

    public static void main(String [] args) {
        Solution test = new Solution();
        int [] input = {5, 4, 1, 2};
        System.out.println(test.traps(input));
    }


}
