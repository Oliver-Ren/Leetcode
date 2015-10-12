import java.util.*;
/**
 * The solution using incremental construction approach.
 * Time complexity: O(n!)
 * Space complexity: O(n)
 * status: accepted, 5ms.
 */ 
public class SolutionIncre {
    public List<List<Integer>> permute(int[] nums) {
        // precondition: nums is not null
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            int size = result.size();
            List<List<Integer>> newResult = new ArrayList<List<Integer>>();
            for (int j = 0; j < size; j++) {
                List<Integer> currPermute = result.get(j);
                for (int k = 0; k <= currPermute.size(); k++) {
                    currPermute.add(k, currNum);
                    newResult.add(new ArrayList<Integer>(currPermute));
                    currPermute.remove(k);
                }
            }
            result = newResult;
        }

        return result;
    }

    public static void main(String[] args) {
        SolutionIncre test = new SolutionIncre();
        int[] nums = {1, 3, 5};
        List<List<Integer>> result = test.permute(nums);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(", " + i);
            }
            System.out.println();
        }
    }

}


