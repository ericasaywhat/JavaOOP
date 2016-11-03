import java.util.Random;

/**
*These are text exercises from page 36 in Head First Java.
*
*@author erica lee
*/

class Dog {
	private int size;
	String breed;
	String name;

	public int getSize() {
		return size;
	}
	
	public void setSize(int newSize) {
		size = newSize;
	}
	void bark() {
		System.out.println("Ruff! Ruff!");
	}
	
	public boolean isBigger(Dog otherDog) {
		if (this.getSize()> otherDog.getSize()){
			return true;
		} else {
			return false;
		}
	}
}

class DogPack {
	private Dog [] dogs;		

	public void makeArray(int arraysize) {
		dogs = new Dog[arraysize];
	}
	
	public void addDog(int intIndex, Dog oneDog) {		
		dogs[intIndex] = oneDog;
	}
	
	public Dog[] getArray() {
		return dogs;
	}	
	
	public Dog biggestDog() {
		Dog biggestDog = new Dog();
		//To find the biggest dog
		for (int i = 0; i < dogs.length; i++) {
			Dog oneDog = dogs[i];
			if (oneDog.isBigger(biggestDog)) {
				biggestDog = oneDog;
				}		
		}
		return biggestDog;
	}		
}

class Cat extends Dog {
	@Override
	void bark(){
		System.out.println("I'm a cat!");
	}
}

/**
 * DogTestDrive tests the dog class above.
 * Randomly generates an array of dogs of either Chihuahua, Terrier, German Shepherd,
 * or Collie breed of random size between 10 and 20.
 * 
 * @author erica
 *
 */
class DogTestDrive {

	private static void bark(Dog[] pack) {
		for (int i = 0; i < pack.length; i++) {
			pack[i].bark();
		}
	}
	
	
	public static void main(String[] args) {
	Random rand = new Random();
		String[] breeds = {"Chihuahua", "Terrier", "German Shepherd", "Collie"};

		int[] intSizes = {5,10,12,15};
		DogPack dogPack = new DogPack();
		dogPack.makeArray(4);
		
		//for all sizes make a dog and put into dogPack
		for(int i = 0; i < intSizes.length; i++) {
			Dog oneDog = new Dog();
			oneDog.breed = breeds[rand.nextInt(4)];		
			oneDog.setSize(intSizes[i]);
			dogPack.addDog(i, oneDog);
			System.out.println(oneDog.breed.toString() + ": " + oneDog.getSize());
		}
		
		Dog biggestDog = dogPack.biggestDog();
		System.out.println("The biggest dog is " + biggestDog.breed + " of size " + biggestDog.getSize());
		
	}
}

