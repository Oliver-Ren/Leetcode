import java.util.*;
/**
 * My first attempt for the problem.
 * idea: using the deque and keep a local maximum.
 * Time complexity: O(n)
 * Space complexity: O(k)
 * Status: accepted.
 * Time: 1 hour.
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // precondition: nums is not null and k <= nums.length.
        if (nums == null || k < 1 || k > nums.length) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            if (i >= k && nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            if (i + 1 >= k) {
                result[i + 1 - k] = deque.peekFirst();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = {9,8,7,6,5,4,3,2};
        int[] result = test.maxSlidingWindow(nums, 3);
        for (int i : result) {
            System.out.print(", " + i);
        }
    }
}
