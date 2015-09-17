import java.util.*;
/** This solution is makes use of 
  * the priority queue.
  * the Time complexity is: O(nlogk),
  * where k is the kth maximum number;
  * space complexity is: O(k);
  * Status: accepted, 284ms. 
  */

public class Solution_Heap2 {
    public int findKthLargest(int[] nums, int k) {
        // precondition: nums is not null, and 1 <= k < nums.length
   
        int result = 0;
        PriorityQueue<Integer> minPQ 
            = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            minPQ.offer(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            result = minPQ.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Heap2 test = new Solution_Heap2();
        int[] nums = {3, 4, 6, 1};
        System.out.println(test.findKthLargest(nums, 1));
    }
}
            

