import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
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
 * Status: Accepted.
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
    
    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        
        sb.append(root.val);
        sb.append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // precondition: data is not null
        if (data == null) {
            throw new NullPointerException();
        }
        String[] datas = data.split(",");
        ArrayList<String> dataList = new ArrayList<String>(Arrays.asList(datas));
        Iterator<String> dataIter = dataList.iterator();
        return preorderConstruct(dataIter);
    }
    
    
    private TreeNode  preorderConstruct(Iterator<String> iter) {
        String curr = iter.hasNext() ? iter.next() : "null";
        if (curr.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = preorderConstruct(iter);
        root.right = preorderConstruct(iter);
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(2);
        String str = codec.serialize(root);
        TreeNode newroot = codec.deserialize(str);
        System.out.println(newroot.val);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
