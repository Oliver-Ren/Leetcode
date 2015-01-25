public class Solution{
	public List<Interval> insert(List<Interval> intervals, Interval newInterval){
		if (newInterval == null) return intervals;
		List<Interval> newIntervals = new ArrayList<Interval>();
		if (intervals == null || intervals.isEmpty()) return newIntervals.add(newInterval);
		boolean isFound = false, isInserted = false;
		if (newInterval.start > intervals.get(intervals.size()-1).start){
			if (newInterval.start > intervals.get(intervals.size()-1).end)
				return intervals.add(newInterval);
			else{
				intervals.get(intervals.size()-1).end = newInterval.end;
				return intervals;
			}
		}
		if (newInterval.start < intervals.get(0).start){
			if(newIntervals.end < intervals.get(0).start){
				newIntervals.add(newInterval);
				isFound = true;
				isInserted = false;
			}
			else if(newIntervals.end > intervals.get(0).start){
				newIntervals.end = intervals.get(0).end;
				isFound = true;
			}
		}

		for (int i = 0; i < intervals.size() - 1; i++){
			int prevStart = intervals.get(i).start;
			int nextStart = intervals.get(i+1).start;
			int prevEnd = intervals.get(i).end;
			int nextEnd = intervals.get(i+1).end;
			if(!isFound){
				if (nextStart < newInterval.start){
					newIntervals.add(intervals.get(i));
				}
				else if ( nextStart > newInterval.start){
					isFound = true;
					if (newInterval.start > prevEnd)
						newIntervals.add(intervals.get(i));
					else
						newInterval.start = prevStart;
				}

			}
			else if (isFound && !isInserted){
				if (newInterval.end < nextStart) {
					newIntervals.add(newInterval);
					isInserted = true;
				}
				else if (newInterval.end < nextEnd) {
					newInterval.end = next.end;
					newIntervals.add(newInterval);
					isInserted = true;
					i++;
				}
			}
			
			else if (isInserted)
				newIntervals.add(intervals.get(i));
		}

