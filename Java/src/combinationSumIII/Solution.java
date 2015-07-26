import java.util.List;
import java.util.ArrayList;

/** This is the DFS solutoin 
  * The time complexity is O(k * n)
  * The space complexity is O(k * n)
  * Status:Accepted, 244ms.
  */

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if (n <= k * 9) {
            dfs(0, k, 0, n, 0, path, result);
        }
        return result;
    }

    private void dfs(int level, int k, int sum, int n, int lastEle,
        List<Integer> path, List<List<Integer>> result) {
        if (level == k - 1) {
            if (n - sum > lastEle && n - sum < 10) {
                path.add(n - sum);
                result.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
                return;
            }
        }
            
        for (int i = lastEle  + 1; i < n && i < 10; i++) {
            path.add(i);
            dfs(level + 1, k, sum + i, n, i, path, result);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String [] args) {
        Solution test = new Solution();
        List<List<Integer>> result = test.combinationSum3(4, 54);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
}


            
