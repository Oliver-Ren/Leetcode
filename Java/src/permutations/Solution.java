import java.util.*;
/**
 * The simple DFS solution.
 * Time complexity: O(n!)
 * Space complexity: O(n)
 * status: accepted.
 */ 
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // precondition: nums is not null
        if (nums == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>(nums.length);
        dfs(result, path, nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            boolean ok = true;
            int curr = path.size();
            for (int j = 0; j < curr; j++) {
               if (path.get(j) == nums[i]) {
                   ok = false;
               }
            }

            if (ok) {
                path.add(nums[i]);
                dfs(result, path, nums);
                path.remove(path.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Solution tes = new Solution();
        int[] nums = {1,3,5};
        List<List<Integer>> result = tes.permute(nums);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(", " + i);
            }
            System.out.println();
        }
    }

}
