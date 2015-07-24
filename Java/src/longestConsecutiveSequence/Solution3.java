/** This soluiton usesd the
  * property of union-find.
  * It only loop one round.
  * Time complexity is O(n).
  * Spcace complexity is O(n).
  * Status: Not finished.
  */

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }

            int left = nums[i];
            int right = nums[i];

            if (map.containsKey(nums[i] - 1)) {
                left = map.get(nums[i] - 1);
            }

            if (map.containsKey(nums[i] + 1)) {
                right = map.get(nums[i] + 1);
            }
            
            map.put(nums[i], nums[i]);
            map.put(left, right);
            map.put(right, left);

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}



