import java.util.*;

/* Iterative solution using bit vector.
 * time complexity: O(2^n);
 * space complxity: O(n);
 * Status: Accepted, 432ms.
 */

public class Solution_Iter_Bit {
    public List<List<Integer>> subsetWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());
        int n_bits = nums.length;

        for (int i = 0; i < 1 << n_bits; i++) {
            List<Integer> path = new ArrayList<Integer>();
            for (int j = 0; j < n_bits; j++) {
                if ((i & (1 << j)) != 0) {
                    path.add(nums[j]);
                }
            }
            result.add(path);
        }

        List<List<Integer>> realResult = new ArrayList<List<Integer>>();
        for (List<Integer> l : result) {
            realResult.add(l);
        }

        return realResult;
    }



                    
    public static void main(String[] args) {
        Solution_Iter_Bit test = new Solution_Iter_Bit();
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
