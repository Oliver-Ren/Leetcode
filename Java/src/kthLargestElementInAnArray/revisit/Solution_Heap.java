/** This solution is makes use of 
  * the priority queue.
  * the Time complexity is: O(nlogk);
  * space complexity is: O(k);
  * Status: accepted, 380ms. 
  */

public class Solution_Heap {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
        for (int i : nums) {
            minPQ.offer(i);
            if (minPQ.size() > k) {
                minPQ.poll();
            }
        }

        return minPQ.peek();
    }
}
