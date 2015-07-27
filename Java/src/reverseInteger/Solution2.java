/** a more concise solution.
  * time complexity is O(logn)
  * space compexity is O(1)
  * Status: Accepted, reverse: 304ms, reverse2: 368ms.
  */

public class Solution2 {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)result;
    }

    public int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int prev = result;
            result = result * 10 + x % 10;
            if (result/10 != prev) {
                return 0;
            }
            x /= 10;
        }


        return result;
    }

    public static void main(String[] args) {
	System.out.println(-25 % 10);
        Solution2 test = new Solution2();
        System.out.println(test.reverse(12345));
    }
}

