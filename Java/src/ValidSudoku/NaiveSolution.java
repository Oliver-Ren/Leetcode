package ValidSudoku;

public class NaiveSolution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false; 
        if (!checkMatrix(board)) return false;
        transpose(board);
        if (!checkMatrix(board)) return false;
        if (!checkSmallGrid(board)) return false;
        return true;
        
    }
    
    private boolean checkMatrix(char [][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidLine(board[i])) {
                return false;
            }
        }
        return true;
    }
    
    private boolean checkSmallGrid(char [][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                char [] tempLine = new char[9];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        tempLine[k*3 + l] = board[i+k][j+l];
                    }
                }
                if(!isValidLine(tempLine)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void transpose(char [][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                char temp = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = temp;
            }
        }
    }
    
    private boolean isValidLine(char [] line) {
        if (line.length != 9) return false;
        for (int i = 1; i < 10; i++) {
            int counter = 0;
            for (int j = 0; j < 9; j++) {
                if (line[j] == ('0' + (char)i)) {
                    counter++;
                }
                else if((line[j] < '0' || line[j] > '9') && line[j] != '.') {
                    return false;
                }
            }
            if (counter > 1) {
                return false;
            }
        }
        return true;
    }
}