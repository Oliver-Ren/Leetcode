public class Solution {
	public boolean isHappy(int n) {
		HashSet<Integer> occured = new HashSet<Integer>();
		int oldNumber = n;	
		int newNumber = 0;
		while (true) {
			while (oldNumber != 0) {
				int digit = oldNumber % 10;
				oldNumber /= 10;
		      	newNumber += digit * digit;
			}

			if (occured.contains(newNumber)) {
				return false;
			} else {
				occured.add(newNumber);
			}

			if (newNumber == 1) {
				return true;
			}

			oldNumber = newNumber;
			newNumber = 0;
		}
	}
}

