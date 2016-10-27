import java.util.Random;

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

/**
 * DogTestDrive tests the dog class above.
 * Randomly generates an array of dogs of either Chihuahua, Terrier, German Shepherd,
 * or Collie breed of random size between 10 and 20.
 * 
 * @author erica
 *
 */
class DogTestDrive {
	private static int biggest = 0;
	private static Dog bigDog;
	private static Random rand = new Random();
	private static String[] breeds = new String[4];

	
	private static Dog[] makePack(int arraysize) {
		breeds[0] = "Chihuahua";
		breeds[1] = "Terrier";
		breeds[2] = "German Shepherd";
		breeds[3] = "Collie";
		
		Dog [] dogs = new Dog[arraysize];			//Creates a Dog array of size that is defined above that is null
		
		for (int i = 0; i < arraysize; i++) {
			Dog oneDog = new Dog();
			int size = rand.nextInt(10) + 5;		//chooses a random size between 5 and 15
			int breedIndex = rand.nextInt(4);		//chooses a random breed of the four breeds defined above
			oneDog.size = size;						//sets dog's size to be the random size
			oneDog.breed = breeds[breedIndex];		//sets dog's breed to be the random breed
			
			dogs[i] = oneDog;						//puts each dog in the array	
			
			System.out.println("Dog number " + String.valueOf(i+1) + ": " + oneDog.breed + " of size " + oneDog.size);
			}
		
		return dogs;
	}
	
	private static void bark(Dog[] pack) {
		for (int i = 0; i < pack.length; i++) {
			pack[i].bark();
		}
	}
	
	private static Dog findBiggestDog(Dog[] pack) {
		//To find the biggest dog
		for (int i = 0; i < pack.length; i++) {
			Dog oneDog = pack[i];
		if (oneDog.size > biggest) {
			biggest = oneDog.size;
			bigDog = oneDog;
			}		
		}
		return bigDog;

	}		
	
	public static void main(String[] args) {
		Dog[] dogPack = makePack(4);
		bark(dogPack);
		Dog biggestDog = findBiggestDog(dogPack);
		System.out.println("The biggest dog is " + biggestDog.breed + " of size " + biggestDog.size);
		
	}
}

