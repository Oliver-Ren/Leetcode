import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/** This is the DFS + backtracking
  * solution for the problem.
  * In order to get the non-descnending
  * order, the given array is firstly sorted.
  * time complexity: O(n!);
  * space complexity: O(n!);
  * Status: Accepted, 408ms.
  */

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cand = new ArrayList<Integer>();
        Arrays.sort(nums);

        for (int len = 0; len <= nums.length; len++) {
            dfs(len, -1, nums, result, cand);
        }

        return result;
    }

    private void dfs(int len, int lastEle, int[] nums, List<List<Integer>> result, List<Integer> cand) {
        if (len == 0) {
            result.add(new ArrayList<Integer>(cand));
            return;
        }

        for (int i = lastEle + 1; i < nums.length; i++) {
            cand.add(nums[i]);
            dfs(len - 1, i, nums, result, cand);
            cand.remove(cand.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution test = new Solution();
        List<List<Integer>> result = test.subsets(nums);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
        
}

        
