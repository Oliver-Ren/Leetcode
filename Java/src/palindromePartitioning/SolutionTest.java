package palindromePartitioning;

import java.util.List;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution3 test1 = new Solution3();
		List<List<String>> result = test1.partition("bb");
		for (List<String> li : result) {
			for (String s : li) {
				System.out.print(s + ",");
			}
			System.out.println();
		}
	}

}
