/** A simpler recursive solution 
  * Time compexity is O(
  * Space complexity is O(n)
  * Status: time limit exceeded.
  */

public class Solution {
    public int numTrees(int n) {
        if (n <= 0) return 0;
        return numOfTrees(1, n); 
            
            
    }

    private int numOfTrees(int left, int right) {
        if (right <= left) {
            return 1;
        }
        int totalNum = 0;
        for (int mid = left; mid <= right; mid++) {
           totalNum +=  numOfTrees(left, mid - 1) * numOfTrees(mid + 1, right);
        }
        return totalNum;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.numTrees(2));
    }
}



