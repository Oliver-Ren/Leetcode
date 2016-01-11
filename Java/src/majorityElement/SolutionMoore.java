/**
 * Solution based on Moore's Voting Algorithm.
 * Time: O(n);
 * Space: O(1);
 */
public class Solution {
    public int majorityElement(int[] nums) {
        // precondition: nums is not null
        if (nums == null) throw new NullPointerException();
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}

    
