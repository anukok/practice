package interviewcake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import interviewcake.models.Meeting;

public class MergeMeeting4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Meeting> input = new ArrayList<Meeting>();
		input.add(new Meeting(0,1));
		input.add(new Meeting(3,5));
		input.add(new Meeting(4,8));
		input.add(new Meeting(10,12));
		input.add(new Meeting(9,10));
		
		System.out.println(mergeMeetings(input));
	}
	
	public static List<Meeting> mergeMeetings(List<Meeting> meetings) {
    	// edge cases
		if (meetings.size() <= 1) {
			return meetings;
		}
    	
    	List<Meeting> merged = new ArrayList<Meeting>();
    	
    	// sort meetings
    	
    	Collections.sort(meetings, new Comparator<Meeting>(){
    		public int compare(Meeting m1, Meeting m2){
    			return m1.startTime - m2.startTime;
    		}
    	});
    	
    	Iterator<Meeting> iter = meetings.iterator();
    	Meeting previous = (Meeting) iter.next();
    	
    	while (iter.hasNext()) {
    		Meeting nextM = iter.next();
    		boolean overlap = overlap(previous,nextM);
    		if (overlap) {
    			Meeting condensed= union(previous, nextM);
    			previous = condensed;
    		}
    		else {
    			merged.add(previous);
    			previous = nextM;
    		}
    	}
    	merged.add(previous);
    	
    	return merged;
    }

	public static Meeting union(Meeting m1, Meeting m2) {
		if (!overlap(m1, m2)) return null;
				
		return new Meeting(m1.startTime, Math.max(m1.endTime,m2.endTime));
			
	}

	public static boolean overlap(Meeting m1, Meeting m2) {
		return m1.endTime >= m2.startTime;
	}

}
