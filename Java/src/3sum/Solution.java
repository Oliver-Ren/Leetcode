import java.util.*;
/**
 * My first attempt for the problem
 * idea: sort, and using two pointer.
 * Time complexity: O(n^2).
 * Space complexity: O(logn) for sort.
 * Status: Accepted.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // precondition: nums is not null and the length of nums
        // is greater than or equal to 3.
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int i = 0;
        int prev = nums[0];
        while (i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                int small = nums[j];
                int big = nums[k];
                int sum = nums[i] + nums[j] + nums[k];
                //System.out.println(sum);
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == small) j++;
                    while (k > j && nums[k] == big) k--;
                } else if (sum > 0) {
                    while (k > j && nums[k] == big) k--;
                } else {
                    while (j < k && nums[j] == small) j++;
                }
            }
            
            prev = nums[i];
            while (i < nums.length - 2 && nums[i] == prev) i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = {-5, -5, -3, -3, -2, -2, -1, 0, 1, 2, 2, 3, 3, 5, 5};
        List<List<Integer>> result = test.threeSum(nums);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(", " + i);
            }
            System.out.println();
        }
    }
}
