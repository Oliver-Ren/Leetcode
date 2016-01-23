/**
 * Using stack to simulate the process of preorder traversal
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Status: Accepted.
 */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        // precondition: preorder is not null
        if (preorder == null) {
            throw new NullPointerException();
        }
        
        Stack<Integer> numStack = new Stack<Integer>();
        int lowerBnd = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < lowerBnd) {
                return false;
            }
            
            while (!numStack.isEmpty() && numStack.peek() < num) {
                lowerBnd = numStack.pop();
            }
            
            numStack.push(num);
        }
        
        return true;
    }
}
