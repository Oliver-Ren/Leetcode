public class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        if (x <= 1) {
            return x;
        }

        int lo = 1;
        int hi = x;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid > x / mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo - 1;
    }
}
