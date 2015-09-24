/**
 * My accepted solution for sort colors.
 * This is actually the Dutch National flag
 * problem. I used the loop invarient to solve the problem.
 * which only take one round.
 */
public class Solution {
    public void sortColors(int[] nums) {
        // check the precondition.
        if (nums == null) {
            return;
        }
        
        int ptr0 = 0;
        int ptr1 = 0;
        int ptr2 = nums.length - 1;
        
        while (ptr1 <= ptr2) {
            if (nums[ptr1] == 0) {
                swap(nums, ptr1, ptr0);
                ptr0++;
                ptr1++;
            } else if (nums[ptr1] == 1) {
                ptr1++;
            } else if (nums[ptr1] == 2) {
                swap(nums, ptr1, ptr2--);
            }
            
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
