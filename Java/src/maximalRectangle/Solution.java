import java.util.Arrays;
/**
 * My first attempt for the problem.
 * idea: dynamic programming.
 * Status: failed.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // precondition: matrix is not null matrix is not 
        // empty
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int numRow = matrix.length;
        int numCol = matrix[0].length;
        int[][] optRow = new int[numRow + 1][numCol + 1];
        int[][] optCol = new int[numRow + 1][numCol + 1];
        int[] highestCol = new int[numCol];
        int[] longestRow = new int[numRow]; 

        Arrays.fill(optRow[0], 0);
        Arrays.fill(optCol[0], 0);

        for (int i = 0; i < numRow + 1; i++) {
            optRow[i][0] = 0;
            optCol[i][0] = 0;
        }

        for (int i = 1; i < numRow + 1; i++) {
            for (int j = 1; j < numCol + 1; j++) {
                optRow[i][j] = -1;
                optCol[i][j] = -1;
            }
        }

        int maxArea = 0;
       
        for (int i = 1; i <= numRow; i++) {
            for (int j = 1; j <= numCol; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    highestCol[j - 1] = -1;
                    longestRow[i - 1] = -1;
                }

                if (matrix[i - 1][j - 1] == '1') {
                    // candidate 1: row only
                    int originRow = i - 1;
                    int originCol = j - 1;
                    int areaBlock = 1;
                    int currArea = 0;
                    if (highestCol[j - 1] == -1) {
                        highestCol[j - 1] = i - 1;
                    }
                    if (longestRow[i - 1] == -1) {
                        longestRow[i - 1] = j - 1;
                    }
                    int areaRow = j - longestRow[i - 1];
                    int areaCol = i - highestCol[j - 1]; 
                    int areaTwoCol = 0;
                    int areaTwoRow = 0;
                    
                    if (optRow[i - 1][j - 1] >= 0) {
                        originRow = Math.max(optRow[i - 1][j - 1], highestCol[j - 1]);
                        originCol = Math.max(optCol[i - 1][j - 1], longestRow[i - 1]);
                       
                        if (j > 1 && highestCol[j - 2] >= 0) {
                            areaTwoCol = 2 * (i - 
                                    Math.max(highestCol[j - 2], highestCol[j - 1]));
                        }

                        if (i > 1 && longestRow[i - 2] >= 0) {
                            areaTwoRow = 2 * (j - 
                                    Math.max(longestRow[i - 2], longestRow[i - 1])); 
                        }
                    } else {
                        originRow = i - 1;
                        originCol = j - 1;
                    }
                    int height = i - originRow;
                    int width = j - originCol;
                    areaBlock = height * width;
                    
                    optRow[i][j] = originRow;
                    optCol[i][j] = originCol;
                    currArea = Math.max(Math.max(areaRow, areaCol), areaBlock);
                    currArea = Math.max(currArea, Math.max(areaTwoCol, areaTwoRow));
                    if (currArea == 10) System.out.println("longsetRow" + longestRow[i - 1]);
                    maxArea = Math.max(maxArea, currArea);
                }

            }
        }
        
        for (int i = 0; i <= numRow; i++) {
            for (int j = 0; j <= numCol; j++) {
                System.out.print("(" + optRow[i][j] + ", " + optCol[i][j] + ") ");
            }
            System.out.println();
        }

        for (int i = 0; i < numRow; i++) {
            System.out.print(", " + longestRow[i]);
        }


        return maxArea;    
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        /*char[][] mat = {{'0', '1', '1', '0', '1'},
                        {'1', '1', '0', '1', '0'},
                        {'0', '1', '1', '1', '0'},
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '1', '1', '1'},
                        {'0', '0', '0', '0', '0'}};*/
        char[][] mat = {{'1', '0', '1', '0'}, {'1', '0', '1', '1'},  {'1', '0', '1', '1'}, 
           {'1', '1', '1', '1'}};
        System.out.println(test.maximalRectangle(mat));
    }
}
