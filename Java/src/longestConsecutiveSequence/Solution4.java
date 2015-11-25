import java.util.Map;
import java.util.HashMap;

/** This soluiton usesd the
  * property of union-find.
  * It only loop one round.
  * Time complexity is O(n).
  * Spcace complexity is O(n).
  * Status: Accepted, 20ms. new timing method.
  */

public class Solution4 {
    public int longestConsecutive(int[] nums) {
        // precondtion: nums is not null.
        if (nums == null) {
            throw new NullPointerException();
        }
        // maps the the number to the size of the connected component current in.
        HashMap<Integer, Integer> sizeMap = new HashMap<Integer, Integer>();
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sizeMap.containsKey(nums[i])) continue;
            int prev = nums[i] - 1;
            int prevSize = 0;
            if (sizeMap.containsKey(prev)) {
                prevSize = sizeMap.get(prev);
            }

            int next = nums[i] + 1;
            int nextSize = 0;
            if (sizeMap.containsKey(next)) {
                nextSize = sizeMap.get(next);
            }

            int newSize = prevSize + 1 + nextSize;

            sizeMap.put(nums[i] - prevSize, newSize);

            sizeMap.put(nums[i] + nextSize, newSize);

            sizeMap.put(nums[i], newSize);
            maxLength = Math.max(maxLength, newSize);
            
        }

        return maxLength;
    }
}



