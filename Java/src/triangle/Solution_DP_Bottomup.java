import java.util.*;

/** bottom up dp solution for the problem.
  * time complexity: O(n^2), where n 
  * is the height of the triangle.
  * space complexity: O(n).
  * Status: Accepted, 264ms.
  */

public class Solution_DP_Bottomup {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Precondition: triangle is not null.
        if (triangle == null) {
            throw new NullPointerException();
        }

        int height = triangle.size();
        int width = triangle.get(height - 1).size();
        int[][] opt = new int[height + 1][width + 1];
        
        for (int i = height - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int curr = triangle.get(i).get(j);
                opt[i][j] = 
                    curr + Math.min(opt[i + 1][j], opt[i + 1][j + 1]);
            } 
        }

        return opt[0][0];
    }
}

