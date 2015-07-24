import java.util.HashMap;
import java.util.HashSet;

/** The optimized Solution 
  * for the problem which 
  * uses the faster HashMap
  * instead of the HashSet.
  *
  * the time complexity is O(n)
  * Space complexity is O(n)
  * Status: Accepted, 388ms.
  */

public class Solution2 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> numSet = 
            new HashMap<Integer, Boolean>(nums.length);
        int longestConsec = 0;

        for (int i = 0; i < nums.length; i++) {
            numSet.put(nums[i], true);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (numSet.get(nums[i])) {
                int left = 1;
                int right = 1;
                while (numSet.containsKey(nums[i] - left)) {
                    numSet.put(nums[i] - left, false);
                    left++;
                }

                while (numSet.containsKey(nums[i] + right)) {
                    numSet.put(nums[i] + right, false);
                    right++;
                }

                longestConsec = Math.max(longestConsec,
                    right + left - 1);
            }
        }

        return longestConsec;
    }

    public static void main(String [] args) {
        Solution test = new Solution();
        int [] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(test.longestConsecutive(arr));
    }

}

