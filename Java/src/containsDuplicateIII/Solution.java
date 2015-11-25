/**
 * My first attempt.
 * using the Tree Data structure.
 * Time Compleixty: O(nlogk);
 * Space Complexity: O(k);
 * Status: Accepted.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // precondition: nums is not null.
        if (nums == null) {
            throw new NullPointerException();
        }
        
        TreeMap<Long, Integer> slideWindow = new TreeMap();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                slideWindow.remove(Long.valueOf(nums[i - k - 1]));
            }

            Long curr = Long.valueOf(nums[i]);
            Long ceil = slideWindow.ceilingKey(curr);
            if (ceil != null && ceil <= curr + t) return true;
            Long floor = slideWindow.lowerKey(curr);
            if (floor != null && floor >= curr - t) return true;
            
            slideWindow.put(curr, i);
        }
        
        return false;
    }
}
                
