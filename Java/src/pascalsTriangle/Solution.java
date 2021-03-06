//package pascalsTriangle;
import java.util.List;
import java.util.ArrayList;

/** 
  * the time complexity is O(n^2), 
  * the space complexity is O(1).
  * Status: Not finished.
  */

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 1; i <= numRows; i++) {
            List<Integer> level = new ArrayList<Integer>();
	        for (int j = 0; j < i; j++) {
                if (j == 0 || j == i -1) {
                    level.add(1);
                } else {
                    level.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
                }
            }
            result.add(level);
        }

        return result;

    }

    public static void main(String [] args) {
        Solution test = new Solution();
        List<List<Integer>> result = test.generate(5);
        for (List<Integer> level : result) {
            for (int i : level) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
