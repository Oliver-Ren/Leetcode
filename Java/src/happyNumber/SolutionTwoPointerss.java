/**
 * The solution based on two chasing pointers
 * similar to the problem of linked list cycle.
 */
public class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        
        int fast = getNext(n);
        int slow = n;
        
        while (fast != 1 && fast != slow) {
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        }
        
        return fast == 1;
    }
    
    private int getNext(int n) {
        int next = 0;
        while (n != 0) {
            next += (n % 10) * (n % 10);
            n /= 10;
        }
        return next;
    }
}
