import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/** This is the DFS + backtracking
  * solution for the problem.
  * In order to get the non-descnending
  * order, the given array is firstly sorted.
  * time complexity: O(2^n);
  * space complexity: O(n);
  * Status: Accepted, 320ms
  */

public class Solution_DFS_simple2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(0, nums, result, path);
        return result;
    }

    private void dfs(int start, int[] nums,  List<List<Integer>> result, List<Integer> path) {
        /* each time the new path is added. */
        result.add(new ArrayList<Integer>(path));
        
        for (int i = start; i < nums.length; i++) {
            /* number of position i is chosen. */
            path.add(nums[i]);
            dfs(i+ 1, nums, result, path);
            path.remove(path.size() - 1);
        }

    }





    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution_DFS_simple2 test = new Solution_DFS_simple2();
        List<List<Integer>> result = test.subsets(nums);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
        
}

        
