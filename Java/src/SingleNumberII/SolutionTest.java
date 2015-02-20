package SingleNumberII;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution test = new Solution();
		int [] A = {1,1,1,-6};
		int result = test.singleNumber(A);
		System.out.print(result);
	}

}
