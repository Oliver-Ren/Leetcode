/** according to the observation,
 * find the solution.
 * time complexity: O(1).
 * space complexity: O(1).
 * Status: Accepted, 292ms.
 */

public class Solution {
	public int addDigits(int num) {
		if (num == 0) {
			return num;
		} else {
			int result = num % 9;
			return result == 0 ? 9 : result;
		}
	}
}
		
