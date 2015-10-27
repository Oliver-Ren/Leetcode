import java.util.List;
import java.util.ArrayList;
/**
 * time complexity: O(n);
 * Space Complexity: O(1)
 * Status: Accepted, 1ms.
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        // precondition: nums is not null.
        if (nums == null) throw new NullPointerException();
        List<String> result = new ArrayList<String>();
        if (nums.length == 0) return result;
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        int prev = nums[0];
        boolean moreThanOne = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev + 1) {
                if (moreThanOne) {
                    sb.append("->" + prev);
                    moreThanOne = false;
                }
                result.add(sb.toString());
                sb.setLength(0);
                sb.append(nums[i]);
            } else {
                moreThanOne = true;
            }
            prev = nums[i];
        }

        if (moreThanOne) sb.append("->" + prev);
        result.add(sb.toString());


        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3, 5, 7};
        List<String> result = s.summaryRanges(nums);
        for (String str : result) {
            System.out.println(str);
        }
    }

}
