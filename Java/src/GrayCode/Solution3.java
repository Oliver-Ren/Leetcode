import java.util.*;

/** This is the recursive version of the solution. */
public class Solution3 {
	    public static List<Integer> grayCode(int n) {
			if (n <= 0) {
				List<Integer> result = new ArrayList<Integer>();
				result.add(0);
				return result;
			}

			List<Integer> result = grayCode(n - 1);

			int rightHand = 1 << (n - 1);
			for (int i = (1 << (n - 1)) - 1; i >= 0; i--) {
				result.add(rightHand + result.get(i));
			}

			return result;

		}
	
		public static void main(String [] args) {

			Solution3 testcase = new Solution3();
			List<Integer> graycode = testcase.grayCode(3);
			for (Integer i : graycode) {
				System.out.println(i);
			}

		
		}

}



	      
