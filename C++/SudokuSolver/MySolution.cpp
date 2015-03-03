#include <iostream>
#include <vector>
#include <string>

class Solution {
public:
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
					if (found) return;
  				} else {
  					board[row][column] = '.';
  				}
  			} 
  		} else {
  		  dfs(board, number + 1);
  		  }
		}

	  bool isValid(vector<vector<char> > &board, int row, int column) {
		  int originR = row - row % 3;
		  int originC = column - column % 3;

		  for (int i = 0; i < 9; i++) {
		  	  /* Check for the valid row. */
			  if (board[row][i] == board[row][column]) {
				  return false;
			  }

			  /* check for the valid column. */
			  if (board[i][column] == board[row][column]) {
				  return false;
			  }

			  /* check for the valid grid. */
			  if (board[originR + i / 3][originC + i % 3] == board[row][column]) {
				  return false;
			  }
		  }

		  return true;
	  }
};
			 
