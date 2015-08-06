import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/** This is the iterative solution.
  * the time complexity is O(2^n).
  * the space complexity is O(n);
  * Status:
  */

/* Stusas: Accepted, 312ms. */

public class Solution_Iterative {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path1 = new ArrayList<Integer>();
        result.add(path1);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newResult = new ArrayList<List<Integer>>();
            for (List<Integer> path : result) {
                List<Integer> newPath = new ArrayList<Integer>(path);
                newPath.add(nums[i]);
                newResult.add(newPath);
            }

            result.addAll(newResult);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Iterative test = new Solution_Iterative();
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

                
 
