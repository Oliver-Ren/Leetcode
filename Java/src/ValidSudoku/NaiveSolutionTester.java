package ValidSudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class NaiveSolutionTester {

	@Test
	public void test() {
		NaiveSolution newsolution = new NaiveSolution();
		char[][] test = {{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
		assertEquals(true,newsolution.isValidSudoku(test));
	}

}
