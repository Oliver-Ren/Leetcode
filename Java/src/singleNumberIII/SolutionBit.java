import java.util.HashSet;

/** This solution uses bit manipulation.
 * find the last different bit and divide
 * array into two groups.
 * Time complexity: O(n);
 * Space complexity: O(1);
 * Status: Accepted, 364ms.
 */

public class SolutionBit {
	public int[] singleNumber(int[] nums) {
		int xorOfAll = 0;
		for (int i = 0; i < nums.length; i++) {
			xorOfAll ^= nums[i];
		}

		int lastBit = 1;
		while ((xorOfAll & lastBit) == 0) {
			lastBit <<= 1;
		}

		int xorOfG1 = 0;
		int xorOfG2 = 0;

		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & lastBit) == 0) {
				xorOfG1 ^= nums[i];
			} else {
				xorOfG2 ^= nums[i];
			}
		}

		int[] result = new int[2];
		result[0] = xorOfG1;
		result[1] = xorOfG2;

		return result;

	}
		
		

	public static void main(String[] args) {
		SolutionBit test = new SolutionBit();
		int[] nums = {1,2,4,2,1,5};
		int[] result = test.singleNumber(nums);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}	
