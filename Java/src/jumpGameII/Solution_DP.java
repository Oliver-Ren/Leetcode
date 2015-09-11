/**
 * The dynamic programming solution
 * uses the property that the opt
 * is non-descending array.
 * time complexity: O(n^2);
 * space complexity: O(n);
 * Status: accepted, 624ms.
 */
public class Solution {
    public int jump(int[] nums) {
        int[] opt = new int[nums.length];
        
        Arrays.fill(opt, -1);
        
        opt[0] = 0;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    opt[i] = opt[j] + 1;
                    break; // we could break 
                    // because candidate after
                    // that will have result
                    // no better than this
                }
            }
        }
        
        return opt[nums.length - 1];
        
    }
}
