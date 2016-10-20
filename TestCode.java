/**
*These are text exercises from Head First Java.
*Thus, the class names don't match file name.
*@author erica lee
*/

//Page 21
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