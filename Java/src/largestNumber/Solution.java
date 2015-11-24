import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
/**
 * My first solution. based on the sorting 
 * using customized comparator.
 * Time complexity: O(nlogn).
 * Space Complexity: O(n).
 * Status: accepted, 123ms;
 */
public class Solution {
    private Comparator<Integer> CompareWithDigit = new Comparator<Integer>() { 
        public int compare(Integer x, Integer y) {
            String str1 = String.valueOf(x);
            String str2 = String.valueOf(y);
            return (str2 + str1).compareTo(str1 + str2);
        }
    };

    public String largestNumber(int[] nums) {
        // precondition: nums is not null
        if (nums == null) throw new NullPointerException();
        
        Integer[] nums2 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = Integer.valueOf(nums[i]);
        }

        Arrays.sort(nums2, CompareWithDigit);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums2.length; i++) {
                sb.append(nums2[i]);
        }

        while (sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);
        return sb.toString();

    }
}


        
        

