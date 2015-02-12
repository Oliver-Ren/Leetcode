package ExcelSheetColumnTitle;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTester {

	@Test
	public void test() {
		Solution test = new Solution();
		assertEquals("A",test.convertToTitle(1));
		assertEquals("B",test.convertToTitle(2));
		assertEquals("Z",test.convertToTitle(26));
		assertEquals("AA",test.convertToTitle(27));
	}
}
