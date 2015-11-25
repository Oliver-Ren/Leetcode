/**
 * The solution based on Bit manipulation.
 * Status: Accepted.
 */
public class SolutionBit {
    int solution_total = 0;
    int upperlim;
    public int totalNQueens(int n) {
       upperlim = (1 << n) - 1;
       test(0, 0, 0);
       return solution_total;
    }

    private void test(int row, int ld, int rd) {
        int pos, p;
        if (row != upperlim) {
            pos = upperlim & (~(row | ld | rd));
            while (pos != 0) {
                p = pos & (~pos + 1);
                pos -= p;
                test(row | p, (ld | p) << 1, (rd | p) >> 1);
            }
        } else {
            solution_total++;
        }
    }

    public static void main(String[] args) {
        SolutionBit s = new SolutionBit();
        System.out.println(s.totalNQueens(15));
    }
}
