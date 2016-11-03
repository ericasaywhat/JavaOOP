/**
*This is text exercise A from page 88 in Head First Java.
*
*@author erica lee
*/

public class XCopy {
	public static void main(String [] args) {
		
		int orig = 42;
		
		XCopy x = new XCopy();
		
		int y = x.go(orig);
		
		System.out.println(orig + " " + y);
	}
	
	int go(int arg) {
		arg = arg*2;
		return arg;
	}
}
