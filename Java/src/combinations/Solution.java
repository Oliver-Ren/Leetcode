import java.util.*;

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		dfs(n, k, 1, 0, path, result);
		return result;
	}

	private void dfs(int n, int k, int start, int currPos, 
			List<Integer> path, List<List<Integer>> result) {
		if (currPos == k) {
			result.add(new ArrayList(path));
			return;
		}

		for (int i = start; i <= n; i++) {
			path.add(i);
			dfs(n, k, i + 1, currPos + 1, path, result);
			path.remove(path.size() - 1);
		}
	}


	public static void main(String [] args) {
		Solution test = new Solution();
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();

	}
}
