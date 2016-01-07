/**
 * 4 Solutions in total.
 * 1. Using extra space to copy.
 * 2. Continuously moving elements until n elemenets are moved, the Juggling Algo
 *
public class Solution {
    /**
     * Solution with the help of buffer.
     * Time complexity: O(n + k);
     * Space complexity: O(k);
     * Status: Accepted.
     */
    public void rotate(int[] nums, int k) {
        if (nums == null) throw new NullPointerException();
        int n = nums.length;
        k = k % n;
        int[] buffer = new int[k];
        for (int i = 0; i < k; i++) {
            buffer[i] = nums[n - k + i];
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i - k >= 0) { 
                nums[i] = nums[i - k];
            } else {
                nums[i] = buffer[i];
            }
        }
        
    }

    /**
     * Solution 2: Juggling Algorithm
     * Status: Accepted.
     */
    public void rotate2(int[] nums, int k) {
        // precondition: nums is not null, k >= 0
        if (nums == null) throw new NullPointerException();
        if (k < 0) throw new IllegalArgumentException();

        int n = nums.length;
        k %= n;
        int start = 0;
        int curr = start;
        int distance = 0;
        int prev = nums[start];
        for (int i = 0; i < n; i++) {
            curr = (curr + k) % n;
            int temp = nums[curr];
            nums[curr] = prev;
            prev = temp;
            distance += k;
            if (distance % n == 0) {
                start = (start + 1) % n;
                curr = start;
                distance = 0;
                prev = nums[start];
            }
        }
            
    }

    /**
     * Solution 3: The method of David Gries,
     * Similar to the Euclid's method for GCD.
     */
    public void raotate3(int[] nums, int k) {
        // precondition: nums is not null, k >= 0
        if (nums == null) throw new NullPointerException();
        if (k < 0) throw new IllegalArgumentException();
        int n = nums.length; 
        k %= n;
        if (k == 0) return;
        int i = n - k;
        int p = n - k;
        int j = k;
        while (i != j) {
            /*
             * Invariant: [0, p - i) in final position.
             *            [p - i, p) = a (to be swapped with b)
             *            [p, p + j) = b (to be swapped with a)
             *            [p + j, n) in final position.
             */
            if (i > j) {
                swap(nums, p - i, p, j);
                i -= j;
            } else {
                swap(nums, p - i, p + j - i, i);
                j -= i;
            }
        }

        swap(nums, p - i, p, i);
    }

    // helper method for the solution 3
    private void swap(int[] nums, int left, int right, int length) {
        for (int i = 0; i < length; i++) {
            int temp = nums[left + i];
            nums[left + i] = nums[right + i];
            nums[right + i] = temp;
        }
    }

    /**
     * Another Juggling Algorithm implementation.
     */
    public void rotate4(int[] nums, int k) {
        // precondition: nums is not null
        if (nums == null) throw new NullPointerException();
        // precondition; 0 <= k < n;
        int n = nums.length;
        k %= n;
        if (k == 0) return;
        int start = 0;
        
        for (int i = 0; i < gcd(n,k); i++) {
            int prev = nums[start];
            int curr = (start + k) % n;
            int steps = n / gcd(n, k);
            for (int j = 0; j < steps; j++) {
                int temp = nums[curr];
                nums[curr] = prev;
                prev = temp;
                curr = (curr + k) % n;
            }
            start++;
        }
    }
    
    private int gcd(int n, int k) {
        return k == 0 ? n : gcd(k, n % k);
    }

    /**
     * The method based on three reverses.
     * time complexity: O(n);
     * space complexity O(1);
     * Status: Accepted.
     */
    public void rotateInplace(int[] nums, int k) {
        if (nums == null) throw new NullPointerException();
        if (nums.length == 0) return;
        int n = nums.length;
        k %= n; 
        reverse(nums, 0, n - k);
        reverse(nums, n - k, n);
        reverse(nums, 0, n);
    }

    // lo is inclusive, hi is exclusive.
    private void reverse(int[] nums, int lo, int hi) {
        if (nums == null) throw new NullPointerException();
        while (lo < hi) {
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
        }
    }
                
}
