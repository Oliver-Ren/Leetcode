/**
 * Status: DNF.
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Dealing with corner cases.
        if (nums1 == null && nums2 == null) {
            return -1;
        }

        if (nums1 == null) {
            return findMedian(nums2);
        }

        if (nums2 == null) {
            return findMedian(nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        // Switch order cuz we assume n >= m
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int minidx = 0;
        int maxidx = m; //I am not sure
        int i, j, n1, mid = (m + n + 1) >> 1, n2;

        while (minidx <= maxidx) {
            i = (minidx + maxidx) / 2;
            j = mid - i;
            if (i < m && j > 0 && nums2[j - 1] > nums1[i]) {
                minidx = i + 1;
            } else if (i > 0 && j < n && nums1[i - 1] > nums2[j]) {
                maxidx = i - 1;
            } else {
                if (i == 0) n1 = num2[j - 1];
                else if (j == 0) n1 = num1[i - 1];
                else n1 = max(nums1[i - 1], nums2[j - 1]);
                break;
            }





    }

    // Helper method for dealing with finding 
    // median of a single array.
    private double findMedian(int[] nums) {
        int len = nums.length;
        // Dealing with even length
        if (nums.length % 2 == 0) {
            return (double)(nums[len / 2] + nums[len / 2 - 1]) / 2;
        } else {
            // Dealing with odd length
            return nums[len / 2];
        }
    }
            
}
