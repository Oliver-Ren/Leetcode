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
  * Sutats: Accepted, 4ms. 
  */

public class Solution_Rev {
    public int[] productExceptSelf(int[] nums) {
        // precondition: nums is not null and length of nums is greater than 1
        if (nums == null || nums.length <= 1) {
            throw new IllegalArgumentException();
        }

        int len = nums.length;
        int[] leftProd = new int[len];
        int[] rightProd = new int[len];
        
        leftProd[0] = 1;
        rightProd[len - 1] = 1;
         
        for (int i = 1; i < len; i++) {
            leftProd[i] = leftProd[i - 1] * nums[i - 1];
            rightProd[len - 1 - i] = rightProd[len - i] * nums[len - i];
        }


        int[] result = new int[len];
        // round two
        for (int i = 0; i < len; i++) {
            result[i] = leftProd[i] * rightProd[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Rev s = new Solution_Rev();
        int[] pr = {1,2,3,4};
        int[] result = s.productExceptSelf(pr);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

