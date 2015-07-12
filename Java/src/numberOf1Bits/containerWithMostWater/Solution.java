public class Solution {
    public int maxArea(int[] height) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        int maxArea = 0;
        int leftPtr = 0;
        int rightPtr = 0;

        while (leftPtr < height.length) {
           for (rightPtr = leftPtr; rightPtr < height.length; rightPtr++) {
               /* set the first min index in this loop. */
               if (height[rightPtr] < minValue && minIndex < leftPtr) {
                   minIndex = rightPtr;
                   minValue = height[rightPtr];
               }

               maxArea = Math.max(maxArea, minValue * (rightPtr - leftPtr));
           }
           
           leftPtr = minIndex + 1;
        }

        return maxArea;

        
    }

    public static void main(String [] args) {
        Solution test = new Solution();
        int[] height = {1,1};
        System.out.println(test.maxArea(height));
    }
}
