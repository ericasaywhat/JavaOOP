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
	
	private static Dog[] makePack(int arraysize) {
		Random rand = new Random();
		String[] breeds = {"Chihuahua", "Terrier", "German Shepherd", "Collie"};
		Dog [] dogs = new Dog[arraysize];			
		
		for (int i = 0; i < arraysize; i++) {
			Dog oneDog = new Dog();
			int size = rand.nextInt(10) + 5;		
			int breedIndex = rand.nextInt(4);		
			oneDog.setSize(size);					
			oneDog.breed = breeds[breedIndex];		
			
			dogs[i] = oneDog;				
			
			System.out.println("Dog number " + String.valueOf(i+1) + ": " + oneDog.breed + " of size " + oneDog.getSize());
			}
		
		return dogs;
	}
	
	private static void bark(Dog[] pack) {
		for (int i = 0; i < pack.length; i++) {
			pack[i].bark();
		}
	}
	
	private static Dog findBiggestDog(Dog[] pack) {
		Dog biggestDog = new Dog();
		//To find the biggest dog
		for (int i = 0; i < pack.length; i++) {
			Dog oneDog = pack[i];
			if (oneDog.isBigger(biggestDog)) {
				biggestDog = oneDog;
				}		
		}
		return biggestDog;

	}		
	
	public static void main(String[] args) {
		Dog[] dogPack = makePack(4);
		bark(dogPack);
		Dog biggestDog = findBiggestDog(dogPack);
		System.out.println("The biggest dog is " + biggestDog.breed + " of size " + biggestDog.getSize());
		
	}
}

