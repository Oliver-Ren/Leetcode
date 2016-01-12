import java.util.List;
import java.util.ArrayList;
/**
 * The solution based on Moore's voting algorithm.
 * Time complexity: O(n);
 * Space complexity; O(1);
 * Status: Accepted.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // precondition: nums is not null
        if (nums == null) throw new NullPointerException();
        int count1 = 0;
        int count2 = 0;
        int cand1 = 0;
        int cand2 = 0;
        List<Integer> result = new ArrayList<Integer>();

        for (int n : nums) {
            if (n == cand1) {
                count1++;
            } else if (n == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == cand1) {
                count1++;
            }

            if (n == cand2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            result.add(cand1);
        }

        if (cand1 != cand2 && count2 > nums.length / 3) {
            result.add(cand2);
        }

        return result;
    }
}
