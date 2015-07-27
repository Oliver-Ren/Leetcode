public class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0 ? true : false;
        x = Math.abs(x);
        if (x == 0) {
            return 0;
        }

        long result = 0;

        while (x > 0) {
            result *= 10;
            result += x % 10;
            x /= 10;
        }

        if (result > Integer.MAX_VALUE) {
            result = 0;
        }

        int finalResult = (int)result;

        return isNegative  ? -finalResult : finalResult;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.reverse(12345));
    }
}

