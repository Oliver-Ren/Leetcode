import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * My first attempt using DFS.
 * Time complexity: O(n) where n is the number of nodes.
 * Space complexity: O(logn).
 * Status: accetped;
 */
public class SolutionTem {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // precodition: p and q are in the tree and the tree is not null
        if (root == null || p == null || q == null) {
            return null;
        }
       	ArrayList<TreeNode> rst1 = new ArrayList<TreeNode>();
	    ArrayList<TreeNode> path =new ArrayList<TreeNode>();
	    //先找第一个node
	    dfs(rst1,path,root,p); 
	    ArrayList<TreeNode> rst2 = new ArrayList<TreeNode>();
	    //先找第二个node
	    dfs(rst2,path,root,q); 
        System.out.println(rst2);
	    for(int i=0; i<Math.min(rst1.size(),rst2.size()); i++){
		    if(rst1.get(i) != rst2.get(i)){
			    return rst1.get(i-1);
		    }
	    }
	    return null;
    }
    
 public void dfs(ArrayList<TreeNode> rst,ArrayList<TreeNode>path,
	TreeNode root,TreeNode target){
	    if(root == null) return;
	    if(root == target) {
		    rst.addAll(path);
		    return;
	    }
	    //recursion
	    path.add(root.left);
	    dfs(rst,path,root.left,target);
	    path.remove(path.size()-1);	
	    path.add(root.right);
		dfs(rst,path,root.right,target);
	    path.remove(path.size()-1);
    }   
    
    private TreeNode lastCommon(List<TreeNode> l1, List<TreeNode>l2) {
        int i = 0;
        TreeNode parent = null;
        int minSize = Math.min(l1.size(), l2.size());
        for (TreeNode n : l2) {
            System.out.print("->" + n.val);
        }
        
        while (i < minSize && l1.get(i) == l2.get(i)) {
            parent = l1.get(i);
            System.out.print(parent.val);
            i++;
        }
        return parent;
    }

    public static void main(String[] args) {
        SolutionTem test = new SolutionTem();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        test.lowestCommonAncestor(root, left, root);
    }
}
