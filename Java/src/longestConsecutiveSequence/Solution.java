import java.util.Set;
import java.util.HashSet;

/** The first Solution 
  * for the problem.
  * the time complexity is O(n)
  * Space complexity is O(n)
  * Status: Accepted, 464ms.
  */

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>(); 
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i])) {
                int left = -1;
                int right = 1;
                while (numSet.contains(nums[i] + left)) {
                    numSet.remove(nums[i] + left);
                    left--;
                }

                while (numSet.contains(nums[i] + right)) {
                    numSet.remove(nums[i] + right);
                    right++;
                }

                longest = Math.max(longest, right - left - 1); 
            }
        }

        return longest;
    }

    public static void main(String [] args) {
        Solution test = new Solution();
        int [] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(test.longestConsecutive(arr));
    }

}


                            


