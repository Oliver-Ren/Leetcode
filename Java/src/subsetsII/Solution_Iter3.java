import java.util.*;

/* Iterative solution using bit vector.
 * time complexity: O(2^n);
 * space complxity: O(n);
 * Status: Accepted, 288ms. 
 */

public class Solution_Iter3 {
    public List<List<Integer>> subsetWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());
        
        int k = 0;
        while (k < nums.length) {

            int count = 0;
            while (k + count < nums.length && nums[k] == nums[k + count]) {
                count++;
            }

            int prevSize = result.size();
            for (int i = 0; i < prevSize; i++) {
                List<Integer> newPath = new ArrayList<Integer>(result.get(i));

                for (int j = 0; j < count; j++) {
                    newPath.add(nums[k]);
                    result.add(new ArrayList<Integer>(newPath));
                }

            }
            
            k += count;

        }
        return result;
    }


                    
    public static void main(String[] args) {
        Solution_Iter3 test = new Solution_Iter3();
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
