import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * The DFS method based on swap operation.
 * always hold the condition that subarray is in
 * sorted order.
 * Time complexity: O(n!).
 * Space complexity: O(n) for recursion.
 * Status: Wrong Answer.
 */
public class SolutionSwapDFS {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // precondition: nums is not null
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(nums);
        for (int num : nums) {
            path.add(num);
        }
        dfs(path, result, 0);
        return result;
    }

    private void dfs(List<Integer> path, List<List<Integer>> result, int pos) {
        if (pos == path.size()) {
            result.add(path);
            return;
        }

        for (int i = pos; i < path.size(); i++) {
            if (i != pos && path.get(i).equals(path.get(pos))) continue;
            exch(path, i, pos);
            dfs(new ArrayList<Integer>(path), result, pos + 1);
        }
    }

    private void exch(List<Integer> path, int i, int j) {
        int temp = path.get(i);
        path.set(i, path.get(j));
        path.set(j, temp);
    }

    private void printinfo(int[] nums, int pos, int i) {
        for (int j = 0; j < pos; j++) {
            System.out.print("  ");
        }
        System.out.print("current: " + pos + "," + i + "------");
        printArr(nums);
    }

    private void printArr(int[] nums) {
        for (int i : nums) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SolutionSwapDFS s = new SolutionSwapDFS();
        int[] nums = {0,1,0,0,9};
        List<List<Integer>> result = s.permuteUnique(nums);
        System.out.println("size:" + result.size());
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }

}
