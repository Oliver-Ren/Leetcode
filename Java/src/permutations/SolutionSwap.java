/**
 * The DFS solution, instead inserting new numbers, the opeartion is
 * based on the swap
 * Status: Accepted.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> numsList = new ArrayList<Integer>();
        for (int i : nums) {
            numsList.add(i);
        }
        
        dfs(result, numsList, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> numsList, int pos) {
        if (pos == numsList.size()) {
            result.add(new ArrayList<Integer>(numsList));
            return;
        }
        
        for (int i = pos; i < numsList.size(); i++) {
            exch(numsList, i, pos);
            dfs(result, numsList, pos + 1);
            exch(numsList, i, pos);
        }
        
    }
    
    private void exch(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}