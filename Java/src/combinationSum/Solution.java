import java.util.*;
/** The DFS + backtracking solution,
  * time complexity: Combinitorial;
  * space complexity: Combinitorial;
  * Status: Accepted, 444ms.
  */

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        
        dfs(0, target, 0, candidates, result, path);
        return result;
    }

    private void dfs(int i, int target, int sum, int[] candidates,
            List<List<Integer>> result, List<Integer> path) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<Integer>(path));
            return;
        }


        while (i < candidates.length) {
            path.add(candidates[i]);
            dfs(i, target, sum + candidates[i], candidates, result, path);
            path.remove(path.size() - 1);
            i++;
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int [] cand = {2,3,4,7};
        List<List<Integer>> result = test.combinationSum(cand, 7);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
}

