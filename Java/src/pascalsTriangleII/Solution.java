import java.util.List;
import java.util.ArrayList;

i/** This is the solution using the rolling array.
   * the time complexity is O(k^2)
   * the space complexit is O(k).
   * Status: Accepted, 208ms.
   */

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int prev = 1;
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    result.add(1);
                } else {
                    int curr = result.get(j) + prev; 
                    prev = result.get(j);
                    result.set(j, curr);
                }
            }
        }

        return result;

    }

    public static void main(String [] args) {
        Solution test = new Solution();
        for (int i : test.getRow(4)) {
            System.out.print(i);
            System.out.print(' ');
        }
    }
    
        
}
