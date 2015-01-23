package MergeIntervals;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


public class Solution {
	public static List<Interval> merge( List<Interval> intervals){
		List<Interval> mergedIntervals = new ArrayList<Interval>();	
		if (intervals == null || intervals.isEmpty()) return mergedIntervals;
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		
		mergedIntervals.add(intervals.get(0));
		int j = 0;
		for ( int i = 1; i < intervals.size(); i++){
			if (mergedIntervals.get(j).end >= intervals.get(i).start && mergedIntervals.get(j).end > intervals.get(i).end)
				continue;
			else if (mergedIntervals.get(j).end >= intervals.get(i).start && mergedIntervals.get(j).end <= intervals.get(i).end)
				mergedIntervals.get(j).end = intervals.get(i).end;
			else{
				mergedIntervals.add(intervals.get(i));
				j++;
			}
		}
		
		return mergedIntervals;
	}
	

	public static void main(String[] args) {
		List<Interval> testList = new ArrayList<Interval>();
		testList.add(new Interval(9,10));
		testList.add(new Interval(8,8));
		testList.add(new Interval(7,8));
		testList.add(new Interval(6,8));
		testList.add(new Interval(5,8));
		testList.add(new Interval(4,8));
		testList.add(new Interval(3,8));
		testList.add(new Interval(2,8));
		testList.add(new Interval(1,8));
		List<Interval> sortedList = merge(testList);
 		for (Interval item : sortedList){
			System.out.println(item.start+"->"+item.end);
		}
		
		// TODO Auto-generated method stub

	}

}


