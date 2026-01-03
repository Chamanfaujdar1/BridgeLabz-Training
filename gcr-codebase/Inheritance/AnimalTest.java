class Animal {
    String name;
    int age;

    void makeSound(){
        System.out.println("Animals make sounds");
    }
}

class Dog extends Animal{
    @Override
    void makeSound(){
        System.out.println("Dog barks");
    }
}

class Cat extends Animal{
    @Override
    void makeSound(){
        System.out.println("Cat meows");
    }
}

class Bird extends Animal{
    @Override
    void makeSound(){
        System.out.println("Bird chirps");
    }
}

public class AnimalTest{
    public static void main(String[] args){
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        Animal myBird = new Bird();
        myAnimal.makeSound();
        myDog.makeSound();
        myCat.makeSound();
        myBird.makeSound();
    }
}
