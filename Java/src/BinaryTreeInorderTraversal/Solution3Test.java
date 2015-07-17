package BinaryTreeInorderTraversal;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

public class Solution3Test {

	@Test
	public void test() {
		Solution3 test = new Solution3();
		TreeNode tr = new TreeNode(1);
		tr.left = new TreeNode(2);
		tr.left.right = new TreeNode(3);
		
		List<Integer> result = test.inorderTraversal(tr);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
