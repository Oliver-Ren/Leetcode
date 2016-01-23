/**
 * Using stack to simulate the process of preorder traversal
 * The "stack" is reused through the given array.
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Status: Accepted.
 */
public class Solution2 {
    public boolean verifyPreorder(int[] preorder) {
        // precondition: preorder is not null
        if (preorder == null) {
            throw new NullPointerException();
        }

        int stackPtr = -1;
        int lowerBnd = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < lowerBnd) {
                return false;
            }

            while (stackPtr >= 0 && preorder[stackPtr] < preorder[i]) {
                lowerBnd = preorder[stackPtr--];
            }

            preorder[++stackPtr] = preorder[i];
        }
        
        return true;
    }
}
        
