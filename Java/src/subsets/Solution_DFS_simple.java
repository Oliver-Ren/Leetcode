import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/** This is the DFS + backtracking
  * solution for the problem.
  * In order to get the non-descnending
  * order, the given array is firstly sorted.
  * time complexity: O(2^n);
  * space complexity: O(n);
  * Status: Accepted, 256ms.
  */

public class Solution_DFS_simple {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(0, nums, result, path);
        return result;
    }

    private void dfs(int start, int[] nums,  List<List<Integer>> result, List<Integer> path) {
        if (start == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }



        /* number of position i is chosen. */
        path.add(nums[start]);
        dfs(start + 1, nums, result, path);
        path.remove(path.size() - 1);

        /* number of position i is not chose. */
        dfs(start + 1, nums, result, path);
    }





    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution_DFS_simple test = new Solution_DFS_simple();
        List<List<Integer>> result = test.subsets(nums);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
        
}

        
