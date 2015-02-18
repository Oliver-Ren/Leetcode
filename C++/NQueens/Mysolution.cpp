#include <iostream>
#include <vector>
#include <string>

using std::vector;
using std::string;
using std::endl;
using std::cout;

class Mysolution {
	public:
		vector<vector<string> > NQueens(int N) {
			this->column = vector<int>(N, 0);
			this->diag = vector<int>(2*N, 0);
			this->anti_diag = vector<int>(2*N, 0);
			vector<int> C(N, 0);
			vector<vector<string> > result;
			dfs(C, result, 0);
			return result;
		}
	private:
		vector<int> column;
		vector<int> diag;
		vector<int> anti_diag;
		void dfs(vector<int> &C, vector<vector<string> > &result, int row) {
			const int N = C.size();
			if (row == N) {
				vector<string> solution;
				for(int i = 0; i < N; ++i) {
					string s(N,'.');
					for (int j = 0; j < N; ++j) {
						if (j == C[i]) {
							s[j] = 'Q';
						}

					}
					solution.push_back(s);
				}
				result.push_back(solution);
				return;
			}

			for (int j = 0; j < N; ++j) {
				const bool ok =  (column[j] == 0 && diag[row+j] == 0 && anti_diag[row-j+N] == 0);
				if (! ok) {
					continue;
				}
				C[row] = j;
				column[j] = diag[row + j] = anti_diag[row -j + N] = 1;
				dfs(C, result, row + 1);
				//back
				column[j] = diag[row + j] = anti_diag[row - j + N] = 0;
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
				
