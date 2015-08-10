import java.util.*;
/** this is the dfs solution which uses a vector to record
  * how many times the element is used.
  * ftime complexity: O(2^n);
  * space compelxity: O(n);
  * Status: 
  */

/* recursive solution using bit vector.
 * time complexity: O(2^2);
 * space complxity: O(n);
 * Status: Accepted, 340ms.
 */

public class Solution_DFS_Bit {
    public List<List<Integer>> subsetWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums};
        List<Integer> path = new ArrayList<Integer>();
        List<Integer> uniqueNumsIdx = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                uniqueNumsIdx.add(i);
            }
        }
        uniqueNumsIdx.add(nums.length);

        int[] selected = new int[uniqueNumsIdx.size() - 1];

        dfs(result, uniqueNumsIdx, selected, nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> uniqueNumsIdx, 
            int[] selected, int[] nums, int step) {
        if (step == selected.length) {
            List<Integer> path = new ArrayList<Integer>();
            for (int i = 0; i < selected.length; i++) {
                for (int j = 0; j < selected[i]; j++) {
                    path.add(nums[uniqueNumsIdx.get(i)]);
                }
            }
            result.add(path);
            return;
        }

        for (int i = 0; i <= uniqueNumsIdx.get(step + 1) - uniqueNumsIdx.get(step); i++) {
            selected[step] = i;
            dfs(result, uniqueNumsIdx, selected, nums, step + 1);
        }
    }
                    



    public static void main(String[] args) {
        Solution_DFS_Bit test = new Solution_DFS_Bit();
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
