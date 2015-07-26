import java.util.List;
import java.util.ArrayList;

/** This is the DFS solutoin 
  * The time complexity is O(n)
  * The space complexity is O(k * n)
  * Status:Accepted, 220ms.
  */

public class Solution_simpler {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(k, n, 0, result, path);
        return result;
    }

    private void dfs(int k, int n, int lastEle, List<List<Integer>> result,
            List<Integer> path) {
        if (k == 1) {
            if (n < 10 & n > lastEle) {
                path.add(n);
                result.add(new ArrayList<Integer>(path));
                path.remove(path.size()  - 1);
            }
            return;
        }

        for (int i = lastEle + 1; i <= n / k && i < 10; i++) {
            path.add(i);
            dfs(k - 1, n - i, i, result, path);
            path.remove(path.size() - 1);
        }
    }
}
