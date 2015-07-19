/** The solution for the problem is 
  * the algoritm includes two passes:
  * 1. from left to right calculate the 
  * the product of all the elements before
  * the current element.
  * 2, from right to left calculate the 
  * the product of all the elements right to 
  * the current element in order and then 
  * times the current stored value.
  * Time complexity: O(n), Space complexity: O(1)
  * Sutats: Accepted, 444ms. 
  */

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        result[0] = 1;

        for (int i = 1; i < result.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        int temp = 1;

        for (int i = result.length - 2; i >= 0; i--) {
            temp = nums[i + 1] * temp;
            result[i] = result[i] * temp;
        }

        return result;
        
    }
}
