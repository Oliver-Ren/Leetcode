import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/** This is the iterative solution.
  * the time complexity is O(2^n).
  * the space complexity is O(n);
  * Status: Acceted, 288ms.
  */

public class Solution_Recursive_Bitvec {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(result, 0, used, nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, int pos,
            boolean[] used, int[] nums) {
        if (pos == nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    list.add(nums[i]);
                }
            }
                    
            result.add(list);
            return;
        }

        used[pos] = true;
        dfs(result, pos + 1, used, nums);
        
        used[pos] = false;
        dfs(result, pos + 1, used,nums);
    }



    public static void main(String[] args) {
        Solution_Recursive_Bitvec test = new Solution_Recursive_Bitvec();
        int[] cand = {1,2,3};
        List<List<Integer>> result = test.subsets(cand);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
}

                
 
