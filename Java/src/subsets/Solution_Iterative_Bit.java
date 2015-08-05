import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/** This is the iterative solution.
  * the time complexity is O(2^n).
  * the space complexity is O(1);
  * Status: Accepted, 272ms.
  */

public class Solution_Iterative_Bit {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        return result;
    }
                    




    public static void main(String[] args) {
        Solution_Iterative_Bit test = new Solution_Iterative_Bit();
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

                
 
