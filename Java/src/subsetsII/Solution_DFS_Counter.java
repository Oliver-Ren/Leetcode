/**
 * The DFS soluion,
 * to avoid duplicates, we have a counter
 * for each candidate, and pick elements 
 * from the counters.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // precondition: nums is not null
        if (nums == null) throw new NullPointerException();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (!counter.containsKey(i)) {
                counter.put(i, 0);
            }

            counter.put(i, counter.get(i) + 1);
        }

        dfs(result, path, 0, nums);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> path, int pos, int[] nums) {
         
    }
}
