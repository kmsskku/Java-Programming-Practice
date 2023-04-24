public class Animal {
	public static void main(String[] args) {
		String name = "Arcs";
		float weight = (float) 8.5565;
		String nameSlave = "SKKU";
		Cat cat = new Cat(name, weight, nameSlave);
		cat.getName();
		cat.setName("Arcs2");
		cat.getName();
		cat.getWeight();
		cat.setWeight((float) 8.556);
		cat.getWeight();
		cat.getNameslave();
		cat.setNameslave("SNU");
		cat.getNameslave();
		cat.bark();
		cat.getFood();
	}
}

abstract class Mammal extends Animal {
	abstract void bark();

	abstract void getFood();
}

abstract class Reptile extends Animal {
	abstract void getFood();
}

final class Cat extends Mammal {

	String name;
	float weight;
	String nameSlave;

	public Cat(String name, float weight, String nameSlave) {
		this.name = name;
		this.weight = weight;
		this.nameSlave = nameSlave;
	}

	public void getName() {
		System.out.println("Name: " + name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void getWeight() {
		System.out.println("Weight: " + weight);
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public void getNameslave() {
		System.out.println("NameSlave: " + nameSlave);
	}

	public void setNameslave(String nameSlave) {
		this.nameSlave = nameSlave;
	}

	public void bark() {
		System.out.println("Meow");
	}

	public void getFood() {
		System.out.println("Fish");
	}
}

final class Dog extends Mammal {
	String name;
	float weight;
	String nameMaster;

	public Dog(String name, float weight, String nameMaster) {
		this.name = name;
		this.weight = weight;
		this.nameMaster = nameMaster;
	}

	public void getName() {
		System.out.println("Name: " + name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void getWeight() {
		System.out.println("Weight: " + weight);
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public void getNameslave() {
		System.out.println("NameMaster: " + nameMaster);
	}

	public void setNameslave(String nameMaster) {
		this.nameMaster = nameMaster;
	}

	public void bark() {
		System.out.println("Bowbow");
	}

	public void getFood() {
		System.out.println("Apple");
	}

}

final class Crocodile extends Reptile {
	String name;
	float weight;

	public Crocodile(String name, float weight) {
		this.name = name;
		this.weight = weight;
	}

	public void getName() {
		System.out.println("Name: " + name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void getWeight() {
		System.out.println("WEight: " + weight);
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public void getFood() {
		System.out.println("Meat");
	}
}
