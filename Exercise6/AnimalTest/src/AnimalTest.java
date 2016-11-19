import java.util.ArrayList;
import java.util.Random;

/**
*This is for Exercise 6 for the JavaOOP Independent Study
*@author erica lee
*/

abstract class Animal{
	private int size;
	String name;

	
	abstract void makeNoise();
	
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

interface Fetcher{
	public String fetch(String string);
}

class Dog extends Animal implements Fetcher{
	@Override
	void makeNoise() {
		System.out.println("Ruff! Ruff!");
	}
	@Override
	public
	String fetch(String string) {
		return "damp " + string;
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
	
	AnimalPack() {
		animals = new ArrayList<Animal>();
	}
	
	void addAnimal(Animal animal) {		
		animals.add(animal);
	}
	
	ArrayList<Animal> getList() {
		return animals;
	}	
	
	void makeNoise() {
	for (Animal a: animals) {
		a.makeNoise();
	}	
}
	
	Animal biggestAnimal() {
		Animal biggestAnimal = new Dog();
		//To find the biggest animal
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
public class AnimalTest {

	public static void main(String[] args) {
		Fetcher f = new Dog();
		System.out.println(f.fetch("tennis ball"));
		
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

