import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * The DFS incremental construction method.
 * first sort the array and then choose 
 * the elements in the order from left to right.
 * Time complexity: O(n!).
 * Space complexity: O(n) for recursion.
 * Status: Accepted.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // precondition: nums is not null
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(nums);
        boolean[] marked = new boolean[nums.length];
        dfs(nums, result, path, marked);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> path,
            boolean[] marked) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (marked[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !marked[i - 1]) continue;
            marked[i] = true;
            path.add(nums[i]);
            dfs(nums, result, path, marked);
            path.remove(path.size() - 1);
            marked[i] = false;
        }
    }
}
