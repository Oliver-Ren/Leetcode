import java.util.*;

/* Iterative solution using bit vector.
 * time complexity: O(2^n);
 * space complxity: O(1);
 * Status: Accepted, 316ms.
 */

public class Solution_Iter {
    public List<List<Integer>> subsetWithDup(int[] nums) {
        List<List<Integer>> lastResult = null; 
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newResult = new ArrayList<List<Integer>>();
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (List<Integer> path : result) {
                    List<Integer> newPath = new ArrayList<Integer>(path);
                    newPath.add(nums[i]);
                    newResult.add(newPath);
                }
            } else {
                for (List<Integer> path : lastResult) {
                    List<Integer> newPath = new ArrayList<Integer>(path);
                    newPath.add(nums[i]);
                    newResult.add(newPath);
                }
            }
            result.addAll(newResult);
            lastResult = newResult;
        }

        return result;
    }
                    
    public static void main(String[] args) {
        Solution_Iter test = new Solution_Iter();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = test.subsetWithDup(nums);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(" " + i) ;
            }
            System.out.println();
        }
    }
}
