import java.util.*;

/* Iterative solution using bit vector.
 * time complexity: O(2^n);
 * space complxity: O(n);
 * Status:
 */

public class Solution_Iter2 {
    public List<List<Integer>> subsetWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        int prevSize = 0;

        for (int i = 0; i < nums.length; i++) {
            int currSize = result.size();
            for (int j = 0; j < currSize; j++) {
                if (i == 0 || nums[i] != nums[i - 1] || j >= prevSize) {
                    List<Integer> newPath = new ArrayList<Integer>(result.get(j));
                    newPath.add(nums[i]);
                    result.add(newPath);
                }
            }
            prevSize = currSize;
        }

        return result;

    }
                    
    public static void main(String[] args) {
        Solution_Iter2 test = new Solution_Iter2();
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
