public class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        
        int temp = n;
        boolean detectedCycle = false;
        Set<Integer> numSet = new HashSet<Integer>();
        while (temp != 1 && !detectedCycle) {
            int nextNum = 0;
            while (temp != 0) {
                int digit = temp % 10;
                nextNum += digit * digit;
                temp /= 10;
            }
            temp = nextNum;
            if (numSet.contains(temp)) {
                detectedCycle = true;
            } else {
                numSet.add(temp);
            }
        }
        return temp == 1;
    }
}
