/**
*These are text exercises from page 36 in Head First Java.
*
*@author erica lee
*/

class Dog {
	int size;
	String breed;
	String name;

	void bark() {
		System.out.println("Ruff! Ruff!");
	}
}

class Cat extends Dog {
	@Override
	void bark(){
		System.out.println("I'm a cat!");
	}
}

class DogTestDrive {
	public static void main(String[] args) {
		Dog d = new Dog();
		Cat c = new Cat();

		d.size = 40;
		d.bark();

		c.size = 10;
		c.breed = "Maine Coon";
		c.bark();
	}
}

