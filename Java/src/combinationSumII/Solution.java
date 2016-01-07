import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/** 
 * The DFS backtracking solution.
 * Time complexity: O(2^n);
 * Space complexity: O(2^n);
 * Status: Accepted, 5ms.
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // precondition: candidtes is not null
        if (candidates == null) throw new NullPointerException();

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(candidates, result, path, 0, target);
        return result;
    }

    private void dfs(int[] candidates, List<List<Integer>> result, List<Integer> path, int pos, int remainder) {
        if (remainder == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if (i != pos && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > remainder) return; // trimming
            path.add(candidates[i]);
            dfs(candidates, result, path, i + 1, remainder - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}

