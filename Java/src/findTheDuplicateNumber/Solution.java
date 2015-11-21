/**
 * Using binary search based on Pigeonhole princeple.
 * Time Complexity: O(n);
 * Space Complexity: O(1);
 * Status: Accepted;
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int lo = 1;
        int hi = nums.length;
        while (lo < hi) {
            int pivot = lo + (hi - lo) / 2; 
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= pivot) count++;
            }
            if (count <= pivot) lo = pivot + 1;
            else hi = pivot;
        }


        return lo;
    }
}
