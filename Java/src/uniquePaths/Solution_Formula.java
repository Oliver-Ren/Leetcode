/* Status: Accepted, 216ms. */
public class Solution_Formula {
    public int combination(int m, int n) {
        if (n == 0 || m == n) return 1;
        if (n == 1) return m;
        long result =  factor(m, n) / factor(m - n, 0);
        return (int) result;
    
    }

    private long factor(int m, int n) {
        long result = m;
        for (int i = m - 1; i > n; i--) {
           result *= i;
        }
        return result;
    }

    public int uniquePaths(int m, int n) {
        return combination(m + n - 2, Math.max(m -1, n -1));
    }

    public static void main(String[] args) {
        Solution_Formula test = new Solution_Formula();
        System.out.println(test.uniquePaths(1,100));
    }
}
