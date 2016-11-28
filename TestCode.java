/**
*These are text exercises from page 21 in Head First Java.
*
*@author erica lee
*/

public class TestCode {
	public static void main(String[] args) {
		int x = 1;
		int y = 5;
		while (x < 10) {
			x++;
			if (x > 3) {
				System.out.println("big x");
			}
		}

		while (y > 1) {
			y--;
			if (y < 3) {
				System.out.println("small x");
			}
		}
	}
}