import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
*This is for Exercise 8 for the JavaOOP Independent Study
*@author erica lee
*/

abstract class Animal implements Comparable<Animal>{
	private int size;
	String name;
	
	public Animal() {
		System.out.println("Making an animal!");		
	}
	
	public Animal(int size, String name) {
		this.size = size;
		this.name = name;
	}
	
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
	
	public int compareTo(Animal a) {
		return Integer.compare(this.size, a.size);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	
}

interface Fetcher{
	public String fetch(String string);
}

class Dog extends Animal implements Fetcher{
	public Dog() {
		super();
		System.out.println("It's a dog!");
	}
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
	public Cat() {
		super();
		System.out.println("It's a cat!");
	}
	@Override
	void makeNoise(){
		System.out.println("Meow!");
	}
}
class AnimalPack {
	private ArrayList<Animal> animals;

	//uses ArrayList so that we can put more dogs than we initially define the array to be
	public AnimalPack() {
		animals = new ArrayList<Animal>();
		System.out.println("Making an animal pack!");
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
	
	double geoMean(){
		double total = 1;
		for (Animal a: animals){
			total = total*a.getSize();
		}
		double mean = Math.pow(total, 1.0/animals.size());
		return mean;
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
	
	class NameCompare implements Comparator<Animal>{
		public int compare(Animal a, Animal b) {
			return a.getName().compareTo(b.getName());
		}
	}
	
	
	void sortBySize(){
		Collections.sort(animals);
	}
	
	void sortByName(){
		NameCompare sortName = new NameCompare();
		Collections.sort(animals, sortName);
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
	
	public AnimalTest() {
		System.out.println("Animal Test Drive");
	}

	public static void main(String[] args) {
		Fetcher f = new Dog();
		System.out.println("Play fetch: You throw a " + "tennis ball. " + "Fetcher gives you a " + f.fetch("tennis ball"));
		
		Random rand = new Random();
		
		int packSize = 3;
		
		String[] names = {"Green Tea", "Milk Tea", "Earl Grey", "Black Tea", "Chamomile", "Peppermint", "Apricot Green"};

		AnimalPack animalPack = new AnimalPack();
		
		//for all sizes make an Animal and put into animalPack
		for(int i = 0; i < packSize; i++) {
			
			boolean isCat = rand.nextBoolean();
			if (isCat) {
				Cat c = new Cat();
				c.setSize(rand.nextInt(10)+10);
				c.setName(names[i]);
				animalPack.addAnimal(c);
				System.out.println("Cat: " + String.valueOf(c.getSize()));
			} else {
				Dog d = new Dog();
				d.setSize(rand.nextInt(10)+10);
				d.setName(names[i]);
				animalPack.addAnimal(d);
				
				System.out.println("Dog: " + String.valueOf(d.getSize()));
			}
		}
		
		animalPack.makeNoise();
		animalPack.sortBySize();
		for (Animal a : animalPack.getList()){
			System.out.println(a.getSize());	
		}
		
		animalPack.sortByName();
		for (Animal a : animalPack.getList()){
			System.out.println(a.getName());
		}
		
		System.out.println("The biggest animal is a " + animalPack.biggestAnimal().getClass().getName() +
							" of size " + String.valueOf(animalPack.biggestAnimal().getSize())+ '\n' + "Geometric mean of sizes is " + animalPack.geoMean());
	}
}

