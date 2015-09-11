/**
 * The greedy solution
 * uses the property that the opt
 * is non-descending array.
 * time complexity: O(n^2);
 * space complexity: O(n);
 * Status: accepted, 624ms.
 */
public class Solution {
    public int jump(int[] nums) {
        // dealing with invalid inputs
        if (nums == null) {
            return -1;
        }

        int right = 0;
        int jumpNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] > right) {
                jumpNum++;
                right = i + nums[i];
            }

            if (right >= nums.length - 1) {
                return jumpNum;
            }
        }

        return -1;
    }
}

            
