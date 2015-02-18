#include<iostream>
#include<vector>
#include<string>

using std::vector;
using std::cout;
using std::endl;
using std::string;

class Mysolution2 {
	public:
		vector<vector<string> > solveNQueens(int N) {
			this->columns = vector<int>(N, 0);
			this->main_diag = vector<int>(2*N, 0);
			this->anti_diag = vector<int>(2*N, 0);
			vector<vector<string> > result;
			vector<int> C = vector<int>(N, 0);
			dfs(C, result, 0);
			return result;
		}
	private:
		vector<int> columns;
		vector<int> main_diag;
		vector<int> anti_diag;
		void dfs(vector<int> &C, vector<vector<string> > &result, int row) {
			const int N = C.size();
			if (row == N) {
				vector<string> solution;
				for (int i = 0; i < N; ++i) {
					string s = string(N,'.');
					for (int j = 0; j < N; ++j) {
						if (C[i] == j) s[j] = 'S';
					}
					solution.push_back(s);
				}
				result.push_back(solution);
				return;
			}

			for (int j = 0; j < N; j++) {
				const bool ok = (columns[j] == 0 && main_diag[row + j] == 0 && anti_diag[row - j + N] == 0);
				if (! ok) {
					continue;
				}
				C[row] = j;
				columns[j] = main_diag[row + j] = anti_diag[row - j + N] =1;
				dfs(C, result, row+1);
				columns[j] = main_diag[row + j] = anti_diag[row - j + N] =0;
			}	
		}
};

int main() {
	Mysolution2 aa;
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
