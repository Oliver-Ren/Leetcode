package MergeIntervals;

import java.util.Comparator;

/**
 * 
 * @author Chengxiang
 * This class is abandoned because the no two public classes in a single file.
 */

public class CustomComparator implements Comparator<Interval> {
	@Override
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
	
}