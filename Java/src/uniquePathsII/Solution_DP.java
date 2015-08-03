/** Status: Accepted, 320 ms. */

public class Solution_DP {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        obstacleGrid[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 1; i < obstacleGrid.length; i++) {
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 
                : obstacleGrid[i - 1][0];
        }

        for (int j = 1; j < obstacleGrid[0].length; j++) {
            obstacleGrid[0][j] = obstacleGrid[0][j] == 1 ? 0
                : obstacleGrid[0][j - 1];
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }

                obstacleGrid[i][j] = obstacleGrid[i - 1][j]
                    + obstacleGrid[i][j - 1];
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {}
}

                

                

