import java.util.ArrayList;
import java.util.Random;

/**
*This is for Exercise 5 for the JavaOOP Independent Study
*@author erica lee
*/

class Animal{
	private int size;
	String name;

	
	void makeNoise() {
		System.out.println("Animal Noise");
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int newSize) {
		size = newSize;
	}
	
	public boolean isBigger(Animal animal) {
		return this.getSize()> animal.getSize();
	}
}
class Dog extends Animal{
	@Override
	void makeNoise() {
		System.out.println("Ruff! Ruff!");
	}
}

class Cat extends Animal {	
	@Override
	void makeNoise(){
		System.out.println("Meow!");
	}
}
class AnimalPack {
	//uses ArrayList so that we can put more dogs than we initially define the array to be
	private ArrayList<Animal> animals;
	
	public AnimalPack() {
		animals = new ArrayList<Animal>();
	}
	
	public void addAnimal(Animal animal) {		
		animals.add(animal);
	}
	
	public ArrayList<Animal> getList() {
		return animals;
	}	
	
	public void makeNoise() {
	for (int i = 0; i < animals.size(); i++) {
		animals.get(i).makeNoise();
	}
}
	
	public Animal biggestAnimal() {
		Animal biggestAnimal = new Animal();
		//To find the biggest dog
		for (int i = 0; i < animals.size(); i++) {
			Animal oneAnimal = animals.get(i);
			if (oneAnimal.isBigger(biggestAnimal)) {
				biggestAnimal = oneAnimal;
			}		
		}
		return biggestAnimal;
	}		
}



/**
 * AnimalTest tests the Animal class above.
 * Randomly generates an ArrayList of animals that are either cats or dogs,
 * of random size between 10 and 20.
 * 
 * @author erica
 *
 */
class AnimalTest {

	public static void main(String[] args) {
		Random rand = new Random();
		
		int packSize = 8;

		AnimalPack animalPack = new AnimalPack();
		
		//for all sizes make an Animal and put into animalPack
		for(int i = 0; i < packSize; i++) {
			
			boolean isCat = rand.nextBoolean();
			if (isCat) {
				Cat c = new Cat();
				c.setSize(rand.nextInt(10)+10);
				animalPack.addAnimal(c);
				System.out.println("Cat: " + String.valueOf(c.getSize()));
			} else {
				Dog d = new Dog();
				d.setSize(rand.nextInt(10)+10);
				animalPack.addAnimal(d);
				
				System.out.println("Dog: " + String.valueOf(d.getSize()));
			}
		}
		
		animalPack.makeNoise();
		
		System.out.println("The biggest animal is a " + animalPack.biggestAnimal().getClass().getName() +
							" of size " + String.valueOf(animalPack.biggestAnimal().getSize()));
	}
}

