package SingleNumberII;

/** This is the class for extension cases that every number appears for 4 times 
 *  and the only one appears twice, find that number.
 * @author Chengxiang
 *
 */
public class Extension {
	public int singleNumber(int[] A) {
		int bitSum = 0;
		int singleNumber = 0;
		for (int i = 0; i < 32; i++) {
			bitSum = 0;
			for (int j = 0; j < A.length; j++) {
				bitSum += (A[j] >> i) & 1; 
				bitSum %= 4;
			}
			singleNumber |= bitSum << (i-1);
		}
		return singleNumber;
	}

}
