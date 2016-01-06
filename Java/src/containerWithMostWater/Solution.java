/**
 * The two pointer solution.
 * As we have two dimensioins, to reduce
 * the complexity, we want to:
 *  1. make one dimension change monotonically, that is the width.
 *  2. have only have one bound change.
 *    2.1 if the the bound is the higher one, moving does not make result
 *        better.
 *    2.2 if the bound is the lower one, moving may increase the area,
 *        so, increase the lower bound.
 *  If the two pointers grow in same direction, width is not guaranteed to 
 *  grow monotonically.
 *  So move two pointers in reverse directions.
 *
 * Time complexity: O(n).
 * Space complexity: O(1).
 * Status: Accepted.
 */
public class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) { 
            if (height[i] < height[j]) {
                maxArea = Math.max(height[i] * (j - i), maxArea);
                i++;
            } else {
                maxArea = Math.max(height[j] * (j - i), maxArea);
                j--;
            }
        }
        return maxArea;
    }
}
