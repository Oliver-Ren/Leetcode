/**
 * The divide and conquer solution.
 * time complexity: O(nlogn);
 * Space compelxity: O(1);
 * Status: Accepted.
 */
public class SolutionDC {
    public int majorityElement(int[] nums) {
        // precondition: nums is not null
        if (nums == null) throw new NullPointerException();

        return findMajority(nums, 0, nums.length);
    }

    private int findMajority(int[] nums, int lo, int hi) {
        // base case
        if (lo + 2 >= hi) {
            return nums[lo];
        }
        int mid = lo + (hi - lo) / 2;
        int leftMaj = findMajority(nums, lo, mid);
        int rightMaj = findMajority(nums, mid, hi);
        if (leftMaj == rightMaj) {
            return leftMaj;
        }
        if (count(nums, leftMaj, lo, hi) > count(nums, rightMaj, lo, hi)) {
            return leftMaj;
        } else {
            return rightMaj;
        }
    }

    private int count(int[] nums, int target, int lo, int hi) {
        int count = 0;
        for (int i = lo; i < hi; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
        
}
