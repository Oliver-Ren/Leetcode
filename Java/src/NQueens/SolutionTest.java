package NQueens;

import java.util.List;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution test = new Solution();
		List<String[]> result = test.solveNQueens(4);
		System.out.print(result.get(0)[1]);
	}

}
