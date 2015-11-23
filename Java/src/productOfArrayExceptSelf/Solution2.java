/** The solution for the problem is 
  * a kind of recursive solution.
  * Time complexity: O(n), Space complexity: O(n)
  * Sutats: Stack Overflow Error. 
  */

public class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        
        // precondition: nums is not null and length of nums is greater than 1
        if (nums == null || nums.length <= 1) {
            throw new IllegalArgumentException();
        }

        multiply(nums, 0, 1);
        return nums;
    }

    private int multiply(int[] nums, int index, int leftProd) {
        if (index == nums.length - 1) {
            int temp = nums[index];
            nums[index] = leftProd;
            return temp;
        }
        
        int curr = nums[index];
        nums[index] = leftProd;
        int rightProd = multiply(nums, index + 1, leftProd * curr);
        nums[index] *= rightProd;
        return rightProd * curr;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] pr = {1,2,3,4};
        int[] result = s.productExceptSelf(pr);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

      
