/**
 * The greedy solution
 * uses the property that the opt
 * is non-descending array.
 * time complexity: O(n);
 * space complexity: O(1);
 * Status: accepted, 408ms.
 */
public class Solution {
    public int jump(int[] nums) {
        // dealing with invalid inputs
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int right = 0;
        int left = 0;
        int jumpNum = 0;

        while (right < nums.length - 1) {
            jumpNum++;
            int end = right;

            for (int i = left; i <= right; i++) {
                end = nums[i] + i > end ? nums[i] + i : end;
            }

            left = right + 1;
            right = end;
        }
        
        return jumpNum;
    }
}

            
