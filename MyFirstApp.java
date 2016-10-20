/**
*Prints a string variable if its length exceeds 3
*and prints another string variable thrice.
* 
*@author: erica lee
*/
public class MyFirstApp {

	public static void main (String[] args) {
		String subj = "I Rule!";
		String obj = "The World";

		if (subj.length() > 3) {
			System.out.println(subj);
		} else {
			System.out.println("Too Short!");
		}

		for (int i = 0; i<3; i++) {
			System.out.println(obj);
		}
	}
}