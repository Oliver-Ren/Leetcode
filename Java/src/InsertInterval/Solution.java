package InsertInterval;

import java.util.*;
import java.lang.Math;



public class Solution{
	
//This is the bad code
//===============================================================================================
//	public static List<Interval> insertNaive(List<Interval> intervals, Interval newInterval){
//		if (newInterval == null) return intervals;
//		List<Interval> newIntervals = new ArrayList<Interval>();
//		if (intervals == null || intervals.isEmpty()) {
//			newIntervals.add(newInterval);
//			return newIntervals;
//		}
//		boolean isFound = false, isInserted = false;
//		if (newInterval.start > intervals.get(intervals.size()-1).start){
//			if (newInterval.start > intervals.get(intervals.size()-1).end){
//				intervals.add(newInterval);
//				return intervals;
//			}
//				
//			else if (newInterval.end > intervals.get(intervals.size()-1).end){
//				intervals.get(intervals.size()-1).end = newInterval.end;
//			}
//			return intervals;
//		}
//		if (newInterval.start < intervals.get(0).start){
//			if(newInterval.end < intervals.get(0).start){
//				newIntervals.add(newInterval);
//				isFound = true;
//				isInserted = false;
//			}
//			else if(newInterval.end > intervals.get(0).start){
//				newInterval.end = intervals.get(0).end;
//				isFound = true;
//			}
//		}
//
//		for (int i = 0; i < intervals.size() - 1; i++){
//			int prevStart = intervals.get(i).start;
//			int nextStart = intervals.get(i+1).start;
//			int prevEnd = intervals.get(i).end;
//			int nextEnd = intervals.get(i+1).end;
//			if(!isFound){
//				if (nextStart < newInterval.start){
//					newIntervals.add(intervals.get(i));
//				}
//				else if ( nextStart > newInterval.start){
//					isFound = true;
//					if (newInterval.start > prevEnd)
//						newIntervals.add(intervals.get(i));
//					else
//						newInterval.start = prevStart;
//				}
//
//			}
//			if (isFound && !isInserted){
//				if (newInterval.end < nextStart) {
//					newIntervals.add(newInterval);
//					isInserted = true;
//				}
//				else if (newInterval.end <= nextEnd) {
//					newInterval.end = nextEnd;
//					newIntervals.add(newInterval);
//					isInserted = true;
//					i++;
//				}
//			}
//			
//			if (isInserted)
//				newIntervals.add(intervals.get(i));
//		}
//		return newIntervals;
//	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
		List<Interval> returnedList = new ArrayList<Interval>();
		if ( intervals == null || intervals.isEmpty()){
			returnedList.add(newInterval);
			return returnedList;
		}
		
		if (newInterval.start > intervals.get(intervals.size() - 1).end){
			intervals.add(newInterval);
			return intervals;
		}
		
		boolean isStartFind = false;
		boolean isEndFind = false;
		
		for (int i = 0; i < intervals.size(); i++){
			int currStart = intervals.get(i).start;
			int currEnd = intervals.get(i).end;

			if ( !isStartFind && newInterval.start <= currEnd){
				newInterval.start = Math.min(newInterval.start, currStart);
				isStartFind = true;
			}
			if (!isEndFind && isStartFind && newInterval.end < currStart){
				returnedList.add(newInterval);
				isEndFind = true;
			}
			if (!isEndFind && isStartFind && newInterval.end <= currEnd){
				newInterval.end = currEnd;
				returnedList.add(newInterval);
				isEndFind = true;
				continue;
			}
			if(!isEndFind && newInterval.end > currEnd && i == intervals.size()-1){
				returnedList.add(newInterval);
			
			}
			
			if(!(isStartFind ^ isEndFind)) returnedList.add(intervals.get(i));
		}
		return returnedList;
	}
				
		


	
	public static void main(String args[]){
		List<Interval> testList = new ArrayList<Interval>();
		testList.add(new Interval(1,3));
		testList.add(new Interval(4,6));
		testList.add(new Interval(7,8));
		testList.add(new Interval(10,12));
		testList.add(new Interval(13,16));
		

		List<Interval> sortedList = insert(testList, new Interval(0,15));
 		for (Interval item : sortedList){
			System.out.println(item.start+"->"+item.end);
		}
	}
}

