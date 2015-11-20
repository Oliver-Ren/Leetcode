/**
 * Time complexity: O(n).
 * Space complexity: O(1).
 * Status: accepted;
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        // precondition: nums is not null
        if (nums == null) throw new NullPointerException();
        int slow = 0;
        int fast = 0;
        while (slow < nums.length) {
            if (fast < nums.length) {
                if (nums[fast] != 0) nums[slow++] = nums[fast++];
                else fast++;
            } else {
                nums[slow++] = 0;
            }
        }
    }
}
