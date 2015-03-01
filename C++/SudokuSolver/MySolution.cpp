#include <iostream>
#include <vector>
#include <string>

class Solution {
public:
	void solveSudoku(vector<vector<char> > &board) {		
		dfs(board, 0);
	}
private:
	dfs(vector<vector<char> > &board, int number) {
		if (number == 81) return;
		int row = number / 9;
		int column = number % 9;
		int grid = row - row % 3 + column / 3;		

		for (char c = '1'; c <= '9'; c++) {
			if (board[row][column] == '.') {
				board[row][column] = c;
				if (isValidRow(board, row) && isValidColumn(board,column)
						&& isValidGrid(board, grid)) {
					dfs(board, number + 1);
				} else {
					board[row][column] = '.';
				}
			} else {
				dfs(board, number + 1);
			}
		}
	}

	isValidRow(vector<vector<char> > &board, int row) {
		for (int i = 0; i < 9; i++) {
		       if (board[row][i] != '.') {
			       char c = board[row][i];
			       for (int j = i + 1; j < 9; j++) {
				       if (board[row][i] == board[row][j]) {
					       return false;
				       }
			       }
		       }
		}
		return true;
	}

	isValidColumn(vector<vector<char> > &board, int column) {
		for (int i = 0; i < 9; i++) {
			if (board[i][column] != '.') {
				char c = board[i][column];
				for (int j = i + 1; j < 9; j++) {
					if (board[i][column] == board[j][column]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	isValidGrid(vector<vector<char> > &board, int grid) {
		int originRow = grid / 3;
		int originColumn = grid % 3 * 3;
		for (int i = 0; i < 9; i++) {
			currRow = originRow + i / 3;
			currCol = originColumn + i % 3;
		      	
			if (board[currRow][currCol] != '.') {
				char c = board[currRow][currCol];
				for (int j = i + 1; j < 9; j++) {
					jRow = originRow + j / 3;
					jCol = originColumn + j % 3;
					if (board[currRow][currCol] ==  board[jRow][jCol]) {
						return false;
					}
				}
			}
		}
		return true;
	}

		       	       





			

