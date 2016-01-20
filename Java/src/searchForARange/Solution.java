/** This is a not so concise but easy to write solution 
  * for the problem, it adapts the template of the 9 chpater
  * binary search.
  * The time complexity is O(lgn), and the space complexity
  * is O(1).
  * Status: Accepted.
  */

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int [] result = {0,0};
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }


        if (nums[left] == target) {
            result[0] = left;
        } else if (nums[right] == target) {
            result[0] = right;
        } else {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        left = 0;
        right = nums.length - 1;
    
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (nums[right] == target) {
            result[1] = right;
        } else if (nums[left] == target) {
            result[1] = left;
        } 

        return result;
        
    
    }
}

