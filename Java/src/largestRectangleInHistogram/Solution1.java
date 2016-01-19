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

public class Solution1 {
    public int largestRectangleArea(int[] heights) {
        // precondition: heights is not null
        if (heights == null) {
            throw new NullPointerException();
        }

        int maxArea = 0;
        Stack<Integer> window = new Stack<Integer>();
        for (int i = 0; i < heights.length; i++) {
            if (window.isEmpty() || heights[window.peek()] <= heights[i]) {
                window.push(i);
            } else {
                while (!window.isEmpty() && heights[window.peek()] >= heights[i]) {
                    int minIdx = window.pop();
                    maxArea = Math.max(maxArea, window.isEmpty()
                            ? heights[minIdx] * i : heights[minIdx] * (i - window.peek() - 1)); 
                }
                window.push(i);
            }
        }

        while (!window.isEmpty()) {
            int len = heights.length;
            int minIdx = window.pop();
            maxArea = Math.max(maxArea, window.isEmpty() 
                    ? heights[minIdx] * len : heights[minIdx] * (len - window.peek() - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] heights = {4,2,0,3,2,5};
        System.out.println(s.largestRectangleArea(heights));
    }
}
