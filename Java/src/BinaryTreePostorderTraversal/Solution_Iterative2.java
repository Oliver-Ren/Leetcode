/** This is a simple iterative solution for postorder traversal.
  * the first step is to calculate the revesred order of the
  * postorder traveral which is much simpler than directly 
  * solve the problem; the second step is to reverse the 
  * generated list.
  * The time complexity is O(n), the space complexity is O(n).
  */

public class Solution_Iterative2 {
	public static List<Integer> reorderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<Integer> ();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        if (root != null) {
            nodeStack.push(root);
        }

        while (!nodeStack.empty()) {
            TreeNode curr = nodeStack.pop();
            result.add(curr.val);
            if (curr.left != null) {
                nodeStack.push(curr.left);
            } 

            if (curr.right != null) {
                nodeStack.push(curr.right);
            }
        }

        Collections.reverse(result);
        return result;
    }
}

            
            
        
