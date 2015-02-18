#include <iostream>
#include <vector>
#include <string>

using std::string;
using std::vector;
using std::cout;
using std::endl;

class Solution {
	public:
		vector<vector<string> > solveNQueens(int n) {
			this->columns = vector<int>(n, 0);
			this->main_diag = vector<int>(2 * n, 0);
			this->anti_diag = vector<int>(2 * n, 0);

			vector<vector<string> > result;
			vector<int> C(n, 0);  //C[i] means the column number of queen at row i;
			dfs(C, result, 0);
			return result;
		}
	private:
		// these three var is used for pruning
		vector<int> columns; // the occupied columns by current queens;
		vector<int> main_diag;  // the occupied main diagonal;
		vector<int> anti_diag;  // the occupied anti-diagonal;

		void dfs(vector<int> &C, vector<vector<string> > &result, int row) {
			const int N = C.size();
			if (row == N) {   // end condition
				vector<string> solution;
				for (int i = 0; i < N; ++i) {
					string s(N, '.');
					for (int j = 0; j < N; ++j) {
						if (j == C[i]) s[j] = 'Q';
					}
					solution.push_back(s);
				}
				result.push_back(solution);
				return;
			}

			for (int j = 0; j < N; ++j) { // extension
				const bool ok = columns[j] == 0 && main_diag[row + j] 
					== 0 && anti_diag[row - j + N] == 0;
				if (! ok) continue;
				// do extension
				C[row] = j;
				columns[j] = main_diag[row + j] = anti_diag[row - j + N] = 1;
				dfs(C, result, row + 1);
				columns[j] = main_diag[row + j] = anti_diag[row - j + N] = 0;
			}
		}
};



int main() {
	Solution aa;
	vector<vector<string> > result = aa.solveNQueens(8);
	cout << "hee" << endl;
	for (int i = 0; i < result.size(); i++) {
		for (int j = 0; j < result[0].size(); j++) {
			cout << result[i][j] << endl;
		}
		cout << "===================" << endl;
	}
	return 0;
}
