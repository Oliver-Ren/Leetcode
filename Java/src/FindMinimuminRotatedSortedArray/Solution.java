package FindMinimuminRotatedSortedArray;

public class Solution {
    public int findMin(int[] num) {
        if (num == null) return -1;
        return helper(num, 0, num.length - 1);
    }
    
    private int helper(int[] num, int left, int right) {
        int mid = (left + right) / 2;
        if (right - left == 0) return num[right];
        if (num[mid] < num[right]) {
            return helper(num, left, mid);
        }
        else if (num[mid] > num[right]) {
            return helper(num, mid + 1, right);
        }
        return 0;
    }
}