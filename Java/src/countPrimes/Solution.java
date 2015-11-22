/**
 * Solution using Sieve of Eratosthenes.
 * Time complexity: O(nloglogn):
 * Space compelxity: O(n);
 * Status:Accepted, 34ms.
 */
public class Solution {
    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (i <= 2) isNotPrime[i] = false;
            if (!isNotPrime[i]) {
                for (int k = i << 1; k < n; k += i) isNotPrime[k] = true;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) count += isNotPrime[i] ? 0 : 1; 
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPrimes(5));
    }
}
