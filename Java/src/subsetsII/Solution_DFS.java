import java.util.*;

/** This solution seems not able to deal with duplicates. 
  * Time complexity: O(2^n)
  * Space compexity: O(n)
  * Staus: Accepted, 344ms. 
  */
public class Solution_DFS {
    public List<List<Integer>> subsetWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<Integer>();
        dfs(0, result, path, nums);
        return result;
    }

    private void dfs(int index, List<List<Integer>> result
        , List<Integer> path, int[] nums) {
        result.add(new ArrayList<Integer>(path));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            dfs(i + 1, result, path, nums);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_DFS test = new Solution_DFS();
        int[] nums = {1, 2 ,2};
        List<List<Integer>> result = test.subsetWithDup(nums);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(" " + i) ;
            }
            System.out.println();
        }
    }
}
