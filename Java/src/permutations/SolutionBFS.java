/**
 * The BFS based solution.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // iterative solution
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> initpath = new ArrayList<Integer>();
        result.add(initpath);
        if (nums == null || nums.length == 0) return result;
        // number of levels
        for (int i = 0; i < nums.length; i++) { 
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> path = result.pollFirst();
                int pathLen = path.size();
                for (int k = 0; k <= pathLen; k++) {
                    path.add(k, nums[i]);
                    result.add(new ArrayList<Integer>(path));
                    path.remove(k);
                }
            }
        }
        
        return result;
            
        
    }
}
