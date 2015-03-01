// SudokuSolver.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

#include <iostream>
#include <vector>
#include <string>

using std::vector;
using std::string;


class Solution {
public:
	void sayHello() {
		std::cout << "Hello!";
	}

	void solveSudoku(vector<vector<char> > &board) {
		dfs(board, 0);
	}
private:
	bool found = false;
	void dfs(vector<vector<char> > &board, int number) {
		if (number == 81) {
			found = true;
			return;
		}
		int row = number / 9;
		int column = number % 9;
		int grid = row - row % 3 + column / 3;

		if (board[row][column] == '.') {
			for (char c = '1'; c <= '9'; c++) {
				board[row][column] = c;
				if (isValid(board, row, column)) {
					dfs(board, number + 1);
					if (!found) board[row][column] = '.';
					else return;
				}
				else {
					board[row][column] = '.';
				}
			}
		}
		else {
			dfs(board, number + 1);
		}
	}

	bool isValid(vector<vector<char> > &board, int row, int column) {
		int originR = row - row % 3;
		int originC = column - column % 3;

		for (int i = 0; i < 9; i++) {
			/* Check for the valid row. */
			if (board[row][i] == board[row][column] && i != column) {
				return false;
			}

			/* check for the valid column. */
			if (board[i][column] == board[row][column] && i != row) {
				return false;
			}

			/* check for the valid grid. */
			int currR = originR + i / 3;
			int currC = originC + i % 3;
			if (board[currR][currC] == board[row][column] && !(currR == row && currC == column)) {
				return false;
			}
		}

		return true;
	}
};



int _tmain(int argc, _TCHAR* argv[])
{
	vector<string> aa = { "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.."};
	vector<vector<char> > testInput;
	for (int i = 0; i < aa.size(); i++) {
		vector<char> line(aa[i].begin(), aa[i].end());
		testInput.push_back(line);
	}
	
	Solution test;
	test.solveSudoku(testInput);
	for (int i = 0; i < testInput.size(); i++) {
		string str(testInput[i].begin(), testInput[i].end());
		std::cout << str << std::endl;
	}
	getchar();
	return 0;
}

