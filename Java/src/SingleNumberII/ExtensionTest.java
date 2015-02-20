package SingleNumberII;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExtensionTest {

	@Test
	public void test() {
		Extension test = new Extension();
		int [] A = {1,1,1,1,2,2,2,-8,-8,2,3,3,3,3,5,5,5,5,6,6,6,6};
		int result = test.singleNumber(A);
		System.out.print(result);
	}

}
