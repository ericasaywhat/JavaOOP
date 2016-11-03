/**
*This is text exercise B from page 88 in Head First Java.
*
*@author erica lee
*/

public class Clock {
	String time;
	
	void setTime(String t) {
		time = t;
	}
	
	// can't be void
	String getTime() {
		return time;
	}
	
}

class ClockTestDrive {
	
	public static void main(String[] args) {
		Clock c = new Clock();
		
		c.setTime("12345");
		String tod = c.getTime();
		System.out.println("time: " + tod);
	}
	
}