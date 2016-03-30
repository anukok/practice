package interviewcake;

import java.util.Arrays;
import java.util.Comparator;

public class MergingIntervals {

	public static void main(String[] args) {

		Interval[] intervals = new Interval[]{new Interval(1,4), new Interval(5,9), new Interval(5,7), new Interval(7,9),
			new Interval(10,11), new Interval(10, 12), new Interval(15, 17)};
		
		print(intervals);
		
		intervals = busyTimes(intervals);
		
		print(intervals);
	}
	
	public static void print(Interval[] intervals){
		for(Interval i : intervals)
		System.out.print(i.toString());
		
		System.out.println("");
	}
	// W R
	// [(1,4), (5,9), (5,7), (7,9), (10,11), (10, 12), (15, 17)]
	// [(-1,-1),(-1,-1),(-1,-1), (5,9) (2,4) (10,12), (15,17)]
	//

	public static Interval[] busyTimes(Interval[] intervals) {
		// input validation
		if (intervals == null || intervals.length <= 1)
			return intervals;

		int len = intervals.length;

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i, Interval j) {
				return i.start - j.start;
			}
		});

		int count = 0;

		for (int curr = 1; curr < len; curr++) {
			Interval currInterval = intervals[curr];
			Interval prevInterval = intervals[curr - 1];
			boolean overlap = overlap(intervals[curr - 1], currInterval);
			if (overlap) {
				// condense intervals
				Interval condensed = new Interval(prevInterval.start, Math.max(prevInterval.end, currInterval.end));

				intervals[curr] = condensed;
				// swap invalid with first valid interval

				Interval firstValid = intervals[count];
				intervals[curr - 1] = firstValid;
				intervals[count] = new Interval(-1, -1);
				count++;

			}
		}

		return Arrays.copyOfRange(intervals, count, len);

	}

	public static boolean overlap(Interval m, Interval n) {
		return m.end >= n.start;
	}

	public static class Interval {
		public int start;
		public int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public String toString(){
			return "(" + start + "," + end + ")";
		}

	}

}
