import java.util.*;

public class Solution2 {
	public List<Integer> grayCode(int n) {
		Set<Integer> occurance = new HashSet<Integer>();
		List<Integer> graycode = new LinkedList<Integer>();
		int numbers = 1 << n;
		int cand = 0;
		occurance.add(0);
		graycode.add(0);

		for (int i = 0; i < numbers - 1; i++) {
			int manipulator = 1;

			while (true) {
				if (occurance.contains(cand ^ manipulator)) {
					manipulator <<= 1;
				} else {
					cand ^= manipulator;
					occurance.add(cand);
					graycode.add(cand);
					break;
				}	
			}
		}

		return graycode;
	}

	public static void main(String [] args) {
		Solution2 testcase = new Solution2();
		List<Integer> graycode = testcase.grayCode(3);
		for (Integer i : graycode) {
			System.out.println(i);
		}
	}
}
