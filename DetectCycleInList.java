package interviewcake;

import interviewcake.models.LinkedListNode;

public class DetectCycleInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public boolean detectCycle(LinkedListNode list) {
		
		if (list == null) return false;
		
		LinkedListNode slowRunner = list;
		LinkedListNode fastRunner = list;
		
		while (fastRunner !=null && fastRunner.next !=null) { // if either is null, we reached end
			
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			
			if (slowRunner == fastRunner) return true;
		}
		
		return false;
	}
	

}
