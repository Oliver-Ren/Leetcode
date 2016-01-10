/**
 * Solution based on heap.
 * keep the max heap and the min heap.
 * Time complexity: addNum -> O(logn);
 *                  findMedian -> O(1);
 * Space complexity: O(n);
 * Status: Accepted.
 */
class MedianFinder {
    private PriorityQueue<Integer> maxPQ;
    private PriorityQueue<Integer> minPQ;
    
    public MedianFinder() {
        minPQ = new PriorityQueue<Integer>();
        maxPQ = new PriorityQueue<Integer>(10, Collections.reverseOrder());
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxPQ.offer(num);
        minPQ.offer(maxPQ.poll());
        if (maxPQ.size() < minPQ.size()) {
            maxPQ.offer(minPQ.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minPQ.size() == maxPQ.size()) {
            double left = maxPQ.peek();
            double right = minPQ.peek();
            return (left + right) / 2;
        } else {
            return (double) maxPQ.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
