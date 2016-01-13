public class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        
        Set<Integer> numSet = new HashSet<Integer>();
        return isHappy(n, numSet);
    }
    
    private boolean isHappy(int n, Set<Integer> numSet) {
        if (n == 1) {
            return true;
        }
        
        if (numSet.contains(n)) {
            return false;
        } else {
            numSet.add(n);
        }
        
        int next = 0;
        while (n != 0) {
            next += (n % 10) * (n % 10);
            n /= 10;
        }
        return isHappy(next, numSet);
    }
}
