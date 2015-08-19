import java.util.HashSet;

/** My first attempt,
 * simply use the hashtable.
 * Time complexity: O(n);
 * Space complexity: O(n);
 * Status: Accepted, 380ms.
 */

public class Solution {
	public int[] singleNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				set.remove(nums[i]);
			} else {
				set.add(nums[i]);
			}
		}

		int[] result = new int[2];
		int i = 0;
		for (int num : set) {
			result[i] = num;
			i++;
		}
		
		return result;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		int[] nums = {1,2,4,2,1,5};
		int[] result = test.singleNumber(nums);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}	
