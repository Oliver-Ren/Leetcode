import java.util.Arrays;
/**
 * The greedy approach.
 * Time complexity: O(n)
 * Space complexity: O(1).
 * Status: Accepted.
 */
public class Solution2 {
    public int candy(int[] ratings) {
        // precondition: ratings is not null
        if (ratings == null) {
            throw new NullPointerException();
        }
        
        int[] nums = new int[ratings.length];
        Arrays.fill(nums, 1);
        for (int i = 0; i < ratings.length; i++) {
            int leftIdx = Math.max(0, i - 1);
            if (ratings[i] > ratings[leftIdx] && nums[i] <= nums[leftIdx]) {
                nums[i] = nums[leftIdx] + 1;
            }
        }

        int count = 0;
        // round two/
        for (int i = ratings.length - 1; i >= 0; i--) {
            int rightIdx = Math.min(ratings.length - 1, i + 1);
            if (ratings[i] > ratings[rightIdx] && nums[i] <= nums[rightIdx]) {
                nums[i] = nums[rightIdx] + 1;
            }
            count += nums[i];
        }

        return count;
    }
}
            
        
        

