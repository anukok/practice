package interviewcake.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Meeting {

    public int startTime;
    public int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public String toString() {
        return String.format("(%d, %d)", startTime, endTime);
    }
    
    
}