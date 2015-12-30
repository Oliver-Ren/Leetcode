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
        Arrays.sort(nums);
        dfs(nums, result, 0);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, int pos) {
        if (pos == nums.length) {
            List<Integer> cand = new ArrayList<Integer>();
            for (int i : nums) {
                cand.add(i);
            }
            result.add(cand);
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) continue;
            printinfo(nums, pos, i);
            exch(nums, i, pos);
            dfs(nums, result, pos + 1);
            exch(nums, i, pos);
            printinfo(nums, pos, i);
        }
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
