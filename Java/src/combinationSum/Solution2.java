import java.util.*;
/** The DFS + backtracking solution,
  * time complexity: Combinitorial;
  * space complexity: Combinitorial;
  * Status: Accepted, 360ms.
  */

public class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);

        dfs(target, 0, candidates, result, path);
        return result;
    }

    private void dfs(int target, int index, int[] candidates, List<List<Integer>> result,
            List<Integer> path) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int newTarget= target - candidates[i];
            if (newTarget < 0) {
                break;
            }
            path.add(candidates[i]);
            dfs(newTarget, i, candidates, result, path);
            path.remove(path.size() - 1);
        }
    }
}
        
