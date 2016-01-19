import java.util.Stack;

/**
 * The stack based solution.
 * This code is easier to follow the thoughts but not 
 * so concise.
 *
 * Time complexity: O(n);
 * Space complexity: O(n);
 * Status: Accepted;
 */

public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        // precondition: heights is not null
        if (heights == null) {
            throw new NullPointerException();
        }

        int maxArea = 0;
        Stack<Integer> window = new Stack<Integer>();
        for (int i = 0; i <= heights.length; i++) {
            int height = i >= heights.length ? -1 : heights[i];
            if (window.isEmpty() || height >= heights[window.peek()]) {
                window.push(i);
            } else {
                int minIdx = window.pop();
                maxArea = Math.max(maxArea, heights[minIdx] 
                        * (window.isEmpty() ? i : i - window.peek() - 1));
                i--;
            }
        }
        return maxArea;
    }
}
