class Solution {
public:
	vector<vector<int> > combine(int n, int k) {

		vector<vector<int> > result;
		vector<int> path;
		dfs(n, k, 1, 0, result, path);
		return result;
	}


private:
	void dfs(int n, int k, int start, int currPos,
			vector<vector<int> > &result, vector<int> &path) {
		if (currPos == k) {
			result.push_back(path);
			return;
		}

		for (int i = start; i <= n; i++) {
			path.push_back(i);
			dfs(n, k, i + 1, currPos + 1, result, path);
			path.pop();
		}
	}
};
