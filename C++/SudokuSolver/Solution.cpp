#include <iostream>
#include <vector>
#include <string>

class Solution {
public:
	void solveSudoku(vector<vector<char> > &board) {		
		dfs(board, 0);
	}
private:
	const int N = 9;
	vector<unordered_set<char> > row(N);
	vector<unordered_set<char> > column(N);
	vector<unordered_set<char> > grid(N);
	vector<vector<unordered_set<char> >

	void dfs(vector<vector<char> > &board, int r, int j) {
		if (r == N || || j == N || board[r][j] == '.') {
			return;
		}
		
			if (board[r][j] != '.') {
				for (char k = '0'; k < '9'; k++) {
					if (row[r].count(k) == 0
						&& column[j].count(k) == 0
						&& grid[(r - r % 3 + j / 3)].count(k) == 0) {
						board[r][j] = k;
						row[r].insert(k);
						column[j].insert(k);
						grid[(r - r % 3 + j /3)].insert(k);
						dfs(board, r, j + 1);

					}
				}
			}
			dfs(board, r + 1, 0);
	}
};

